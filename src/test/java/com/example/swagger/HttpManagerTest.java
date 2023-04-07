package com.example.swagger;

import com.example.swagger.common.http.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void V3_same(){
        HttpComponent hm = HttpComponentV3.getTestHttpComponent();
        HttpComponent hm1 = HttpComponentV3.getTestHttpComponent();
        Assertions.assertSame(hm, hm1);
    }
    @Test
    public void V3_not_same(){
        HttpComponent hm = HttpComponentV3.getTestHttpComponent();
        HttpComponent hm1 = HttpComponentV3.getHttpComponent();
        Assertions.assertNotEquals(hm, hm1);
    }

    @Test
    public void V4_same(){
        HttpComponentV4 hm = HttpComponentV4.getTestInstance();
        HttpComponentV4 hm1 = HttpComponentV4.getTestInstance();
        Assertions.assertSame(hm, hm1);
    }
    @Test
    public void V4_not_same(){
        HttpComponentV4 hm = HttpComponentV4.getTestInstance();
        HttpComponentV4 hm1 = HttpComponentV4.getInstance();
        System.out.println("hm = " + hm);
        System.out.println("hm1 = " + hm1);
        Assertions.assertNotEquals(hm,hm1);
    }
}

