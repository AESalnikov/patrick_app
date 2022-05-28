package ru.patrick.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.patrick.application.controller.model.AdminGetUsersModel;

import java.io.Serializable;
import java.util.List;

@Data
public class AdminGetUsersResponse implements Serializable {

    @JsonProperty("users")
    private List<AdminGetUsersModel> users;

}
