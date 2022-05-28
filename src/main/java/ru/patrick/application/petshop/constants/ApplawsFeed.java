package ru.patrick.application.petshop.constants;

import lombok.Getter;

import static ru.patrick.application.petshop.constants.Constants.APPLAWS_CHICKEN;
import static ru.patrick.application.petshop.constants.Constants.APPLAWS_CHICKEN_OLD;
import static ru.patrick.application.petshop.constants.Constants.APPLAWS_DUCK_CHICKEN;
import static ru.patrick.application.petshop.constants.Constants.APPLAWS_FISH;
import static ru.patrick.application.petshop.constants.Constants.APPLAWS_FISH_CHICKEN;

@Getter
public enum ApplawsFeed {

    DUCK_CHICKEN(APPLAWS_DUCK_CHICKEN),
    FISH_CHICKEN(APPLAWS_FISH_CHICKEN),
    CHICKEN(APPLAWS_CHICKEN),
    FISH(APPLAWS_FISH),
    CHICKEN_OLD(APPLAWS_CHICKEN_OLD);

    private String url;

    ApplawsFeed(String url) {
        this.url = url;
    }

}
