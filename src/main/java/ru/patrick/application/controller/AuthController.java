package ru.patrick.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.patrick.application.controller.request.AuthRequest;
import ru.patrick.application.controller.response.AuthResponse;
import ru.patrick.application.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authentication(@RequestBody AuthRequest request) {
        AuthResponse response = service.authentication(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
