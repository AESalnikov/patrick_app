package ru.patrick.application.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequest implements Serializable {

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

}
