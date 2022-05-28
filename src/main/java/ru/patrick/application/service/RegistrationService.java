package ru.patrick.application.service;

import ru.patrick.application.controller.request.RegistrationRequest;
import ru.patrick.application.entity.ApplicationUser;

public interface RegistrationService {

    ApplicationUser saveUser(RegistrationRequest request);

}
