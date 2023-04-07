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

    @Test
    public void V5_KAKAO_not_same(){

        Kakao kakao = Kakao.getInstance();
        Kakao testKakao = Kakao.getTestInstance();

        System.out.println("kakao = " + kakao);
        System.out.println("testKakao = " + testKakao);

        HttpComponentV5<Kakao> hm = HttpComponentV5.getInstance(kakao);
        HttpComponentV5<Kakao> hm1 = HttpComponentV5.getInstance(testKakao);

        System.out.println("hm = " + hm);
        System.out.println("hm1 = " + hm1);

        Assertions.assertNotEquals(hm, hm1);
    }

    @Test
    public void V5_NAVER_not_same(){

        Naver naver = Naver.getInstance();
        Naver testNaver = Naver.getTestInstance();

        System.out.println("Naver = " + naver);
        System.out.println("testNaver = " + testNaver);

        HttpComponentV5<Naver> hm = HttpComponentV5.getInstance(naver);
        HttpComponentV5<Naver> hm1 = HttpComponentV5.getInstance(testNaver);

        System.out.println("hm = " + hm);
        System.out.println("hm1 = " + hm1);

        Assertions.assertNotEquals(hm, hm1);
    }


    @Test
    public void V6_KAKAO_not_same(){

        Kakao kakao = Kakao.getInstance();
        Kakao testKakao = Kakao.getTestInstance();

        System.out.println("kakao = " + kakao);
        System.out.println("testKakao = " + testKakao);

        HttpComponentV6<Kakao> HttpComponent = new HttpComponentV6().getInstance(kakao);
        HttpComponentV6<Kakao> testHttpComponent = new HttpComponentV6().getInstance(testKakao);


        System.out.println("hm = " + HttpComponent);
        System.out.println("hm1 = " + testHttpComponent);

        Assertions.assertNotEquals(HttpComponent, testHttpComponent);
    }

    @Test
    public void V6_NAVER_not_same(){

        Naver naver = Naver.getInstance();
        Naver testNaver = Naver.getTestInstance();

        System.out.println("Naver = " + naver);
        System.out.println("testNaver = " + testNaver);

        HttpComponentV6<Naver> HttpComponent = new HttpComponentV6().getInstance(naver);
        HttpComponentV6<Naver> testHttpComponent = new HttpComponentV6().getInstance(testNaver);


        System.out.println("hm = " + HttpComponent);
        System.out.println("hm1 = " + testHttpComponent);

        Assertions.assertNotEquals(HttpComponent, testHttpComponent);
    }


    final HttpComponentV6<Kakao> kakaoHttpComponent = new HttpComponentV6<>();
    final HttpComponentV6<Naver> naverHttpComponent = new HttpComponentV6<>();

    @Test
    public void V6_COMMON_same(){
        Kakao kakao = Kakao.getInstance();
        Kakao testKakao = Kakao.getTestInstance();

        HttpComponentV6<Kakao> HttpComponent = kakaoHttpComponent.getInstance(kakao);
        HttpComponentV6<Kakao> testHttpComponent = kakaoHttpComponent.getInstance(testKakao);

        System.out.println("HttpComponent = " + HttpComponent);
        System.out.println("testHttpComponent = " + testHttpComponent);

        Assertions.assertNotEquals(HttpComponent, testHttpComponent);

        Naver naver = Naver.getInstance();
        Naver testNaver = Naver.getTestInstance();

        HttpComponentV6<Naver> HttpComponent1 = naverHttpComponent.getInstance(naver);
        HttpComponentV6<Naver> testHttpComponent1 = naverHttpComponent.getInstance(testNaver);

        System.out.println("HttpComponent1 = " + HttpComponent1);
        System.out.println("testHttpComponent1 = " + testHttpComponent1);

        Assertions.assertNotEquals(HttpComponent1, testHttpComponent1);
    }
    HttpComponentV6<HttpUnit> commonHttpComponent = new HttpComponentV6<>();

    Kakao kakao = Kakao.getInstance();
    Kakao testKakao = Kakao.getTestInstance();

    Naver naver = Naver.getInstance();
    Naver testNaver = Naver.getTestInstance();
    @Test
    public void V6_COMMON2_same(){



        HttpComponentV6<HttpUnit> kakaoHttpComponent = commonHttpComponent.getInstance(kakao);
        HttpComponentV6<HttpUnit> testKakaoHttpComponent = commonHttpComponent.getInstance(testKakao);

        Assertions.assertNotEquals(kakaoHttpComponent, testKakaoHttpComponent);
        


        HttpComponentV6<HttpUnit> naverHttpComponent1 = commonHttpComponent.getInstance(naver);
        HttpComponentV6<HttpUnit> testNaverHttpComponent1 = commonHttpComponent.getInstance(testNaver);

        Assertions.assertNotEquals(naverHttpComponent1, testNaverHttpComponent1);

        System.out.println("HttpComponent = " + kakaoHttpComponent);
        System.out.println("testHttpComponent = " + testKakaoHttpComponent);
        System.out.println("HttpComponent1 = " + naverHttpComponent1);
        System.out.println("testHttpComponent1 = " + testNaverHttpComponent1);
    }

    @Test
    public void V6_COMMON3_same()
    {
        Assertions.assertEquals(commonHttpComponent.getInstance(kakao), commonHttpComponent.getInstance(kakao));
        Assertions.assertEquals(commonHttpComponent.getInstance(testKakao), commonHttpComponent.getInstance(testKakao));
        Assertions.assertEquals(commonHttpComponent.getInstance(naver), commonHttpComponent.getInstance(naver));
        Assertions.assertEquals(commonHttpComponent.getInstance(testNaver), commonHttpComponent.getInstance(testNaver));

    }
}

