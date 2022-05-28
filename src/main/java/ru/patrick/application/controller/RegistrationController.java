package ru.patrick.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.patrick.application.controller.request.RegistrationRequest;
import ru.patrick.application.service.RegistrationService;

@RestController
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationRequest request) {
        service.saveUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
