package ru.patrick.application.utils;

import lombok.experimental.UtilityClass;
import ru.patrick.application.controller.model.PetShopFeedModel;

@UtilityClass
public class PetShopUtils {

    public static PetShopFeedModel applawsPrettyInfo(PetShopFeedModel response) {
        response.setName(response.getName()
                .replaceAll("&quot", "")
                .replaceAll(";", "'"));
        return response;
    }

    public static PetShopFeedModel organixPrettyInfo(PetShopFeedModel response) {
        response.setName("Organix " + response.getName().trim());
        return response;
    }

}
