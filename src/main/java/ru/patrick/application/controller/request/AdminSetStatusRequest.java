package ru.patrick.application.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdminSetStatusRequest implements Serializable {

    @JsonProperty("status")
    private String status;

}
