package com.example.swagger;

import com.example.swagger.common.HttpManager;
import com.example.swagger.common.HttpManagerV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class HttpManagerTest {


    @Test
    public void V1_same(){
        HttpManager hm = HttpManager.getHttpComponent(HttpManager.HttpMode.TEST);
        HttpManager hm1 = HttpManager.getHttpComponent(HttpManager.HttpMode.TEST);
         Assertions.assertSame(hm, hm1);
    }
    @Test
    public void V1_not_same(){
        HttpManager hm = HttpManager.getHttpComponent(HttpManager.HttpMode.TEST);
        HttpManager hm1 = HttpManager.getHttpComponent(HttpManager.HttpMode.PRODUCTON);
        Assertions.assertNotEquals(hm, hm1);
    }

    @Test
    public void V2_same(){
        HttpManagerV2 hm = HttpManagerV2.getTestHttpComponent();
        HttpManagerV2 hm1 = HttpManagerV2.getTestHttpComponent();
        Assertions.assertSame(hm, hm1);
    }
    @Test
    public void V2_not_same(){
        HttpManagerV2 hm = HttpManagerV2.getTestHttpComponent();
        HttpManagerV2 hm1 = HttpManagerV2.getHttpComponent();
        Assertions.assertNotEquals(hm, hm1);
    }
}

