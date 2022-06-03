package ru.patrick.application.constatns;

import lombok.Getter;

import static ru.patrick.application.constatns.PetShopConstants.APPLAWS_CHICKEN;
import static ru.patrick.application.constatns.PetShopConstants.APPLAWS_CHICKEN_OLD;
import static ru.patrick.application.constatns.PetShopConstants.APPLAWS_DUCK_CHICKEN;
import static ru.patrick.application.constatns.PetShopConstants.APPLAWS_FISH;
import static ru.patrick.application.constatns.PetShopConstants.APPLAWS_FISH_CHICKEN;

@Getter
public enum PetShopApplawsFeed {

    DUCK_CHICKEN(APPLAWS_DUCK_CHICKEN),
    FISH_CHICKEN(APPLAWS_FISH_CHICKEN),
    CHICKEN(APPLAWS_CHICKEN),
    FISH(APPLAWS_FISH),
    CHICKEN_OLD(APPLAWS_CHICKEN_OLD);

    private final String url;

    PetShopApplawsFeed(final String url) {
        this.url = url;
    }

}
