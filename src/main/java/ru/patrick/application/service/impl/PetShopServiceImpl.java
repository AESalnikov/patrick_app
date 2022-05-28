package ru.patrick.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.patrick.application.controller.model.PetShopFeedModel;
import ru.patrick.application.petshop.PetShopApi;
import ru.patrick.application.controller.response.PetShopFeedListResponse;
import ru.patrick.application.service.PetShopService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.patrick.application.utils.PetShopUtils.applawsPrettyInfo;
import static ru.patrick.application.utils.PetShopUtils.organixPrettyInfo;

@Service
public class PetShopServiceImpl implements PetShopService {

    private PetShopApi petShopApi;

    @Autowired
    public PetShopServiceImpl(PetShopApi petShopApi) {
        this.petShopApi = petShopApi;
    }

    @Override
    public PetShopFeedListResponse getAllFeedInfoInStock() {
        PetShopFeedListResponse response = new PetShopFeedListResponse();
        return null;
    }

    @Override
    public PetShopFeedListResponse getAllApplawsInStock() {
        List<PetShopFeedModel> feeds = petShopApi.checkAllApplawsFeed().stream()
                .filter(feed -> feed.getIsAvailable() == true)
                .map(feed -> applawsPrettyInfo(feed))
                .collect(Collectors.toList());
        PetShopFeedListResponse response = new PetShopFeedListResponse();
        response.setFeeds(feeds);
        return response;
    }

    @Override
    public PetShopFeedListResponse getAllOrganixInStock() {
        List<PetShopFeedModel> feeds = petShopApi.checkAllOrganixFeed().stream()
                .filter(feed -> feed.getIsAvailable() == true)
                .map(feed -> organixPrettyInfo(feed))
                .collect(Collectors.toList());
        PetShopFeedListResponse response = new PetShopFeedListResponse();
        response.setFeeds(feeds);
        return response;
    }

}
