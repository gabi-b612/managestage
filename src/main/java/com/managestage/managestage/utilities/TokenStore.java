package com.managestage.managestage.utilities;

public class TokenStore {
    private static String token;

    public static void setToken(String token) {
        TokenStore.token = token;
    }

    public static String getToken() {
        return token;
    }
}
