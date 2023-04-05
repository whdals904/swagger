package com.example.swagger.common;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class IpGetter {

    public static String getIp(HttpUrl apiUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        System.out.println("request = " + request);

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}