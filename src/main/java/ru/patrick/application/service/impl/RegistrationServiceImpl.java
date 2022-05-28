package ru.patrick.application.service.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.patrick.application.controller.request.RegistrationRequest;
import ru.patrick.application.entity.ApplicationUser;
import ru.patrick.application.entity.Role;
import ru.patrick.application.entity.Status;
import ru.patrick.application.exception.RegistrationException;
import ru.patrick.application.repository.RoleRepository;
import ru.patrick.application.repository.UserRepository;
import ru.patrick.application.service.RegistrationService;

import javax.management.relation.RoleNotFoundException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @SneakyThrows
    public ApplicationUser saveUser(RegistrationRequest request) {
        ApplicationUser user = userRepository.findByLogin(request.getLogin()).orElse(null);
        if (user == null) {
            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RoleNotFoundException("Role doesn't exist!"));
            user = fillingApplicationUserFromRequest(request);
            user.setRole(userRole);
            user.setStatus(Status.ACTIVE);
            return userRepository.save(user);
        }
        throw new RegistrationException("User already exist!");
    }

    private ApplicationUser fillingApplicationUserFromRequest(RegistrationRequest request) {
        ApplicationUser user = new ApplicationUser();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setAge(request.getAge());
        return user;
    }


}
