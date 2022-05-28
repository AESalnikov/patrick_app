package ru.patrick.application.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.patrick.application.entity.Status;

import java.io.Serializable;

@Data
public class AdminGetUsersModel implements Serializable {

    @JsonProperty("login")
    private String login;

    @JsonProperty("email")
    private String email;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("status")
    private Status status;

}
