package ru.patrick.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.patrick.application.controller.request.AdminSetRoleRequest;
import ru.patrick.application.controller.request.AdminSetStatusRequest;
import ru.patrick.application.controller.response.AdminGetUsersResponse;
import ru.patrick.application.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<AdminGetUsersResponse> users() {
        AdminGetUsersResponse response = service.users();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/role/{username}")
    public ResponseEntity<?> setRole(@RequestBody AdminSetRoleRequest request,
                                     @PathVariable("username") String username) {
        service.setRole(request, username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/status/{username}")
    public ResponseEntity<?> setStatus(@RequestBody AdminSetStatusRequest request,
                                     @PathVariable("username") String status) {
        service.setStatus(request, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
