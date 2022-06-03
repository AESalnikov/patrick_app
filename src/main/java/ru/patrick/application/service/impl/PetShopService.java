package ru.patrick.application.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.patrick.application.constatns.PetShopApplawsFeed;
import ru.patrick.application.constatns.PetShopOrganixFeed;
import ru.patrick.application.controller.model.FeedModel;
import ru.patrick.application.controller.response.FeedListResponse;
import ru.patrick.application.service.PetStoreService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("petShopService")
public class PetShopService implements PetStoreService {

    @Override
    public List<FeedModel> checkAllApplawsFeed() {
        List<FeedModel[]> responseList = Arrays.stream(PetShopApplawsFeed.values())
                .map(value -> checkFeed(value.getUrl()))
                .collect(Collectors.toList());
        List<FeedModel> result = new ArrayList<>();
        responseList.forEach(values -> result.addAll(Arrays.asList(values)));
        return result;
    }

    @Override
    public List<FeedModel> checkAllOrganixFeed() {
        List<FeedModel[]> responseList = Arrays.stream(PetShopOrganixFeed.values())
                .map(value -> checkFeed(value.getUrl()))
                .collect(Collectors.toList());
        List<FeedModel> result = new ArrayList<>();
        responseList.forEach(values -> result.addAll(Arrays.asList(values)));
        return result;
    }

    private FeedModel[] checkFeed(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, FeedModel[].class).getBody();
    }

    @Override
    public FeedListResponse getAllApplawsInStock() {
        List<FeedModel> feeds = checkAllApplawsFeed().stream()
                .filter(FeedModel::getIsAvailable)
                .map(this::applawsPrettyInfo)
                .collect(Collectors.toList());
        FeedListResponse response = new FeedListResponse();
        response.setFeeds(feeds);
        return response;
    }

    @Override
    public FeedListResponse getAllOrganixInStock() {
        List<FeedModel> feeds = checkAllOrganixFeed().stream()
                .filter(FeedModel::getIsAvailable)
                .map(this::organixPrettyInfo)
                .collect(Collectors.toList());
        FeedListResponse response = new FeedListResponse();
        response.setFeeds(feeds);
        return response;
    }

    private FeedModel applawsPrettyInfo(FeedModel response) {
        response.setName(response.getName()
                .replaceAll("&quot", "")
                .replaceAll(";", "'"));
        return response;
    }

    private FeedModel organixPrettyInfo(FeedModel response) {
        response.setName("Organix " + response.getName().trim());
        return response;
    }

}
