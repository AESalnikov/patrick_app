package ru.patrick.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import ru.patrick.application.controller.request.AuthRequest;
import ru.patrick.application.controller.response.AuthResponse;
import ru.patrick.application.entity.ApplicationUser;
import ru.patrick.application.repository.UserRepository;
import ru.patrick.application.security.jwt.JwtProvider;
import ru.patrick.application.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthServiceImpl(final AuthenticationManager authenticationManager,
                           final UserRepository userRepository,
                           final JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthResponse authentication(AuthRequest request) {
        String login = request.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(), request.getPassword()));
        ApplicationUser applicationUser = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist!"));
        String token = jwtProvider.createToken(login, applicationUser.getRole().getName());
        AuthResponse response = new AuthResponse();
        response.setLogin(login);
        response.setToken(token);
        return response;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

}
