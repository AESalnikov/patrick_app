package ru.patrick.application.service;

import ru.patrick.application.controller.response.PetShopFeedListResponse;

public interface PetShopService {

    PetShopFeedListResponse getAllFeedInfoInStock();

    PetShopFeedListResponse getAllApplawsInStock();

    PetShopFeedListResponse getAllOrganixInStock();

}
