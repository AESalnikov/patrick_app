package ru.patrick.application.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.patrick.application.constatns.Zapovednik96Constants;
import ru.patrick.application.controller.model.FeedModel;
import ru.patrick.application.controller.response.FeedListResponse;
import ru.patrick.application.service.PetStoreService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.patrick.application.constatns.Zapovednik96Constants.STATUS;

@Service("zapovednik96Service")
public class Zapovednik96Service implements PetStoreService {

    @Override
    public List<FeedModel> checkAllApplawsFeed() {
        try {
            Document document = Optional.of(Jsoup.connect(Zapovednik96Constants.APPLAWS_URL).get())
                    .orElseThrow(() -> new IOException("Failed to parse page!"));
            Elements elements = document.getElementsByAttributeValue(Zapovednik96Constants.DATA_ECOMMERCE_BRAND, Zapovednik96Constants.DATA_ECOMMERCE_BRAND_VALUE);
            return elements.stream()
                    .map(this::fromElementToFeedModel)
                    .parallel()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public List<FeedModel> checkAllOrganixFeed() {
        return new ArrayList<>();
    }

    @Override
    public FeedListResponse getAllOrganixInStock() {
        return new FeedListResponse();
    }

    private FeedModel fromElementToFeedModel(Element element) {
        FeedModel feedModel = new FeedModel();
        feedModel.setName(element.attributes().get(Zapovednik96Constants.DATA_ECOMMERCE_NAME));
        feedModel.setSize(weightDetector(feedModel.getName()));
        feedModel.setPrice(BigDecimal.valueOf(Double.parseDouble(element.attributes().get(Zapovednik96Constants.DATA_ECOMMERCE_PRICE))));
        String url = getProductUrl(element);
        String status = checkStatus(url);
        feedModel.setIsAvailable(isAvailable(status));
        return feedModel;
    }

    private String getProductUrl(Element element) {
        return Zapovednik96Constants.APPLAWS_ROOT_URL + element.getElementsByClass(Zapovednik96Constants.QB_CORNER)
                .get(0)
                .attributes()
                .get(Zapovednik96Constants.HREF);
    }

    private String checkStatus(String url) {
        try {
            return Jsoup.connect(url)
                    .get()
                    .getElementsByClass(STATUS).
                    text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAvailable(String status) {
        return Zapovednik96Constants.AVAILABLE.equals(status) || Zapovednik96Constants.FEW.equals(status);
    }

    private Integer weightDetector(String str) {
        if (str.contains(Zapovednik96Constants.WEIGHT_400))
            return 400;
        if (str.contains(Zapovednik96Constants.WEIGHT_2000))
            return 2000;
        if (str.contains(Zapovednik96Constants.WEIGHT_6000))
            return 6000;
        if (str.contains(Zapovednik96Constants.WEIGHT_7500))
            return 7500;
        return null;
    }

    private FeedModel applawsPrettyInfo(FeedModel response) {
        response.setName(response.getName()
                .substring(0, response.getName().lastIndexOf(";") + 1)
                .replaceAll("&quot", "")
                .replaceAll(";", "'"));
        return response;
    }

}
