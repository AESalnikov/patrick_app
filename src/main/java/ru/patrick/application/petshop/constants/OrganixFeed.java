package ru.patrick.application.petshop.constants;

import lombok.Getter;

import static ru.patrick.application.petshop.constants.Constants.ORGANIX_BEEF_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_BEEF_IN_SAUCE;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_CHICKEN_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_CHICKEN_IN_SAUCE;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_SALMON_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_SALMON_IN_SAUCE;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_TURKEY_IN_JELLY;
import static ru.patrick.application.petshop.constants.Constants.ORGANIX_TURKEY_IN_SAUCE;

@Getter
public enum OrganixFeed {

    BEEF_IN_JELLY(ORGANIX_BEEF_IN_JELLY),
    TURKEY_IN_JELLY(ORGANIX_TURKEY_IN_JELLY),
    FOR_KITTENS_TURKEY_IN_JELLY(ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY),
    CHICKEN_IN_JELLY(ORGANIX_CHICKEN_IN_JELLY),
    FOR_KITTENS_CHICKEN_IN_JELLY(ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY),
    SALMON_IN_JELLY(ORGANIX_SALMON_IN_JELLY),
    BEEF_IN_SAUCE(ORGANIX_BEEF_IN_SAUCE),
    TURKEY_IN_SAUCE(ORGANIX_TURKEY_IN_SAUCE),
    FOR_KITTENS_TURKEY_IN_SAUCE(ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE),
    CHICKEN_IN_SAUCE(ORGANIX_CHICKEN_IN_SAUCE),
    FOR_KITTENS_CHICKEN_IN_SAUCE(ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE),
    SALMON_IN_SAUCE(ORGANIX_SALMON_IN_SAUCE);

    private String url;

    OrganixFeed(String url) {
        this.url = url;
    }

}
