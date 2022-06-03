package ru.patrick.application.service;

import ru.patrick.application.controller.model.FeedModel;
import ru.patrick.application.controller.response.FeedListResponse;

import java.util.List;

public interface PetStoreService {

    List<FeedModel> checkAllApplawsFeed();

    List<FeedModel> checkAllOrganixFeed();

    FeedListResponse getAllApplawsInStock();

    FeedListResponse getAllOrganixInStock();

}
