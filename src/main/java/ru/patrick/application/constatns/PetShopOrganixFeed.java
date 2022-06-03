package ru.patrick.application.constatns;

import lombok.Getter;

@Getter
public enum PetShopOrganixFeed {

    BEEF_IN_JELLY(PetShopConstants.ORGANIX_BEEF_IN_JELLY),
    TURKEY_IN_JELLY(PetShopConstants.ORGANIX_TURKEY_IN_JELLY),
    FOR_KITTENS_TURKEY_IN_JELLY(PetShopConstants.ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY),
    CHICKEN_IN_JELLY(PetShopConstants.ORGANIX_CHICKEN_IN_JELLY),
    FOR_KITTENS_CHICKEN_IN_JELLY(PetShopConstants.ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY),
    SALMON_IN_JELLY(PetShopConstants.ORGANIX_SALMON_IN_JELLY),
    BEEF_IN_SAUCE(PetShopConstants.ORGANIX_BEEF_IN_SAUCE),
    TURKEY_IN_SAUCE(PetShopConstants.ORGANIX_TURKEY_IN_SAUCE),
    FOR_KITTENS_TURKEY_IN_SAUCE(PetShopConstants.ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE),
    CHICKEN_IN_SAUCE(PetShopConstants.ORGANIX_CHICKEN_IN_SAUCE),
    FOR_KITTENS_CHICKEN_IN_SAUCE(PetShopConstants.ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE),
    SALMON_IN_SAUCE(PetShopConstants.ORGANIX_SALMON_IN_SAUCE);

    private final String url;

    PetShopOrganixFeed(final String url) {
        this.url = url;
    }

}
