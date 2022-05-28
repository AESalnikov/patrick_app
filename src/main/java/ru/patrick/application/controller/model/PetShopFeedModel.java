package ru.patrick.application.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetShopFeedModel implements Serializable {

    @JsonProperty("Size")
    private Integer size;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("IsAvailable")
    private Boolean isAvailable;

}
