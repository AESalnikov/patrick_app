package ru.patrick.application.security.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityConstants {

    public static final int TOKEN_LIFETIME = 30; // Время жизни в днях
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER = "Bearer ";

}
