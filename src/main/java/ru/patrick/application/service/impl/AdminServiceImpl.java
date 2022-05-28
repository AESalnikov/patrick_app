package ru.patrick.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.patrick.application.controller.model.AdminGetUsersModel;
import ru.patrick.application.controller.request.AdminSetRoleRequest;
import ru.patrick.application.controller.request.AdminSetStatusRequest;
import ru.patrick.application.controller.response.AdminGetUsersResponse;
import ru.patrick.application.entity.ApplicationUser;
import ru.patrick.application.entity.Role;
import ru.patrick.application.entity.Status;
import ru.patrick.application.repository.RoleRepository;
import ru.patrick.application.repository.UserRepository;
import ru.patrick.application.service.AdminService;

import javax.management.relation.RoleNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public AdminGetUsersResponse users() {
        List<ApplicationUser> users = userRepository.findAll();
        List<AdminGetUsersModel> usersModelList = users.stream()
                .map(user -> fromApplicationUserToAdminGetUsersModel(user))
                .collect(Collectors.toList());
        AdminGetUsersResponse response = new AdminGetUsersResponse();
        response.setUsers(usersModelList);
        return response;
    }

    @Override
    public void setRole(AdminSetRoleRequest request, String username) {
        try {
            ApplicationUser user = userRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist!"));
            Role role = roleRepository.findByName(request.getRoleName())
                    .orElseThrow(() -> new RoleNotFoundException("Role doesn't exist!"));
            user.setRole(role);
            userRepository.save(user);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setStatus(AdminSetStatusRequest request, String username) {
        ApplicationUser user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist!"));
        Status newStatus = Arrays.stream(Status.values())
                .filter(s -> s.toString().equals(request.getStatus()))
                .collect(Collectors.toList())
                .get(0);
        user.setStatus(newStatus);
        userRepository.save(user);
    }

    private AdminGetUsersModel fromApplicationUserToAdminGetUsersModel(ApplicationUser applicationUser) {
        AdminGetUsersModel adminGetUsersModel = new AdminGetUsersModel();
        adminGetUsersModel.setLogin(applicationUser.getLogin());
        adminGetUsersModel.setEmail(applicationUser.getEmail());
        adminGetUsersModel.setFirstName(applicationUser.getFirstName());
        adminGetUsersModel.setLastName(applicationUser.getLastName());
        adminGetUsersModel.setMiddleName(applicationUser.getMiddleName());
        adminGetUsersModel.setAge(applicationUser.getAge());
        adminGetUsersModel.setStatus(applicationUser.getStatus());
        return adminGetUsersModel;
    }

}
