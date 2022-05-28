package ru.patrick.application.service;

import ru.patrick.application.controller.request.AuthRequest;
import ru.patrick.application.controller.response.AuthResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthResponse authentication(AuthRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);

}
