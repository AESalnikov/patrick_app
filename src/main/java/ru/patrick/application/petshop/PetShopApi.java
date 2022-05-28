package ru.patrick.application.petshop;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.patrick.application.petshop.constants.ApplawsFeed;
import ru.patrick.application.petshop.constants.OrganixFeed;
import ru.patrick.application.controller.model.PetShopFeedModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetShopApi {

    public PetShopFeedModel[] checkFeed(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, PetShopFeedModel[].class).getBody();
    }

    public List<PetShopFeedModel> checkAllApplawsFeed() {
        List<PetShopFeedModel[]> responseList = Arrays.stream(ApplawsFeed.values())
                .map(value -> checkFeed(value.getUrl()))
                .collect(Collectors.toList());
        List<PetShopFeedModel> result = new ArrayList<>();
        responseList.forEach(values -> result.addAll(Arrays.asList(values)));
        return result;
    }

    public List<PetShopFeedModel> checkAllOrganixFeed() {
        List<PetShopFeedModel[]> responseList = Arrays.stream(OrganixFeed.values())
                .map(value -> checkFeed(value.getUrl()))
                .collect(Collectors.toList());
        List<PetShopFeedModel> result = new ArrayList<>();
        responseList.forEach(values -> result.addAll(Arrays.asList(values)));
        return result;
    }

}
