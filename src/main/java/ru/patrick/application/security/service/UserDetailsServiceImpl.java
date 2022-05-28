package ru.patrick.application.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.patrick.application.entity.ApplicationUser;
import ru.patrick.application.repository.UserRepository;
import ru.patrick.application.security.model.CustomUserDetails;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = repository
                .findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist!"));
        return CustomUserDetails.fromApplicationUser(user);
    }

}
