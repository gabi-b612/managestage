package com.managestage.managestage.services;

import com.managestage.managestage.utilities.HttpClientUtilies;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    public String login(String email, String password) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        JSONObject jsonResponse = HttpClientUtilies.sendPostRequest("/admin-login", params);

        if (jsonResponse.has("message")) {
            return jsonResponse.getString("message");
        }
        return email;
    }
}
