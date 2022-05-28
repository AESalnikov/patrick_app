package ru.patrick.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.patrick.application.controller.model.PetShopFeedModel;

import java.io.Serializable;
import java.util.List;

@Data
public class PetShopFeedListResponse implements Serializable {

    @JsonProperty("feeds")
    private List<PetShopFeedModel> feeds;

}
