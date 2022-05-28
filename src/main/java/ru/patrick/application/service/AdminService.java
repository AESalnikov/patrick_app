package ru.patrick.application.service;

import ru.patrick.application.controller.request.AdminSetRoleRequest;
import ru.patrick.application.controller.request.AdminSetStatusRequest;
import ru.patrick.application.controller.response.AdminGetUsersResponse;

public interface AdminService {

    AdminGetUsersResponse users();

    void setRole(AdminSetRoleRequest request, String username);

    void setStatus(AdminSetStatusRequest request, String status);

}
