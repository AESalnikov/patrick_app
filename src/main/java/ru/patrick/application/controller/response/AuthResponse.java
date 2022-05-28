package ru.patrick.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResponse implements Serializable {

    @JsonProperty("login")
    private String login;

    @JsonProperty("token")
    private String token;

}
