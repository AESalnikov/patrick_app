package ru.patrick.application.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.patrick.application.entity.Role;

import java.io.Serializable;

@Data
public class AdminSetRoleRequest implements Serializable {

    @JsonProperty("role")
    private String roleName;

}
