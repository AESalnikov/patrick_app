package ru.patrick.application.constatns;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PetShopConstants {

    public static final String ROOT = "https://api.retailrocket.ru";
    public static final String API = "/api";
    public static final String API_VERSION = "/1.0";
    public static final String PARTNER = "/partner";
    public static final String PARTNER_CODE = "/523bf7210d422d33b4cacda5";
    public static final String ITEMS = "/items";
    public static final String ITEMS_IDS_PARAM = "/?itemsIds=";
    public static final String APPLAWS_DUCK_CHICKEN_ITEMS_IDS = "115554,115567,115579";
    public static final String APPLAWS_FISH_CHICKEN_ITEMS_IDS = "115556,115570,115580";
    public static final String APPLAWS_CHICKEN_ITEMS_IDS = "115559,115572,115581,667082";
    public static final String APPLAWS_FISH_ITEMS_IDS = "326104,326102,325988";
    public static final String APPLAWS_CHICKEN_OLD_IDS = "115552,115565,656735,115577";
    public static final String STOCK_PARAM = "&stock=";
    public static final String STOCK_PARAM_ID = "4"; //Екб
    public static final String FORMAT_PARAM = "&format=";
    public static final String FORMAT_PARAM_VALUE = "json";

    // Одинаковые части ссылок
    public static final String PETSHOP_BEGIN_LINK = ROOT + API + API_VERSION + PARTNER + PARTNER_CODE + ITEMS + ITEMS_IDS_PARAM;
    public static final String PETSHOP_END_LINK = STOCK_PARAM + STOCK_PARAM_ID + FORMAT_PARAM + FORMAT_PARAM_VALUE;

    // Сухой корм Applaws
    public static final String APPLAWS_DUCK_CHICKEN = PETSHOP_BEGIN_LINK + APPLAWS_DUCK_CHICKEN_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String APPLAWS_FISH_CHICKEN = PETSHOP_BEGIN_LINK + APPLAWS_FISH_CHICKEN_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String APPLAWS_CHICKEN = PETSHOP_BEGIN_LINK + APPLAWS_CHICKEN_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String APPLAWS_FISH = PETSHOP_BEGIN_LINK + APPLAWS_FISH_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String APPLAWS_CHICKEN_OLD = PETSHOP_BEGIN_LINK + APPLAWS_CHICKEN_OLD_IDS + PETSHOP_END_LINK;

    // Паучи Organix
    // желе
    public static final String ORGANIX_BEEF_IN_JELLY_ITEMS_IDS = "611719,773222";
    public static final String ORGANIX_TURKEY_IN_JELLY_ITEMS_IDS = "611718";
    public static final String ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY_ITEMS_IDS = "658205";
    public static final String ORGANIX_CHICKEN_IN_JELLY_ITEMS_IDS = "611723,773220";
    public static final String ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY_ITEMS_IDS = "658206";
    public static final String ORGANIX_SALMON_IN_JELLY_ITEMS_IDS = "773219,611722";

    // соус
    public static final String ORGANIX_BEEF_IN_SAUCE_ITEMS_IDS = "611725";
    public static final String ORGANIX_TURKEY_IN_SAUCE_ITEMS_IDS = "611720";
    public static final String ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE_ITEMS_IDS = "658204";
    public static final String ORGANIX_CHICKEN_IN_SAUCE_ITEMS_IDS = "611721";
    public static final String ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE_ITEMS_IDS = "658203";
    public static final String ORGANIX_SALMON_IN_SAUCE_ITEMS_IDS = "611724";

    // желе
    public static final String ORGANIX_BEEF_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_BEEF_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_TURKEY_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_TURKEY_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_FOR_KITTENS_TURKEY_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_CHICKEN_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_CHICKEN_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_FOR_KITTENS_CHICKEN_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_SALMON_IN_JELLY = PETSHOP_BEGIN_LINK + ORGANIX_SALMON_IN_JELLY_ITEMS_IDS + PETSHOP_END_LINK;

    // соус
    public static final String ORGANIX_BEEF_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_BEEF_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_TURKEY_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_TURKEY_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_FOR_KITTENS_TURKEY_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_CHICKEN_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_CHICKEN_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_FOR_KITTENS_CHICKEN_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;
    public static final String ORGANIX_SALMON_IN_SAUCE = PETSHOP_BEGIN_LINK + ORGANIX_SALMON_IN_SAUCE_ITEMS_IDS + PETSHOP_END_LINK;

}
