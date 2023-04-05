package com.example.swagger;

import com.example.swagger.common.IpGetter;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IpGetterTest {
    @Test
    public void test() throws Exception {
        MockWebServer server = new MockWebServer();
        MockResponse response = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody("{\"ip\": \"127.0.0.1\"}");

        server.enqueue(response);

        server.start();

        HttpUrl baseUrl = server.url("/getIp");

        IpGetter ipGetter = new IpGetter();
        assertEquals("{\"ip\": \"127.0.0.1\"}", IpGetter.getIp(baseUrl));

        server.shutdown();
    }
}