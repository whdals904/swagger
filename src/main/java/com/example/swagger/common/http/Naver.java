package com.example.swagger.common.http;

import lombok.Builder;
import lombok.Data;


public class Naver implements HttpUnit {

    private static Naver P_NAVER;
    private static Naver T_NAVER;

    private String paramA;
    private String paramB;
    private String paramC;
    private String paramD;

    private HttpModeEnum httpMode;

    public Naver(HttpModeEnum hm){

        this.httpMode = hm;
        System.out.println("============Naver HttpMode = " + hm);

        if(HttpModeEnum.TEST.equals(hm)){
            paramA = "TEST_NAVER_A";
            paramB = "TEST_NAVER_B";
            paramC = "TEST_NAVER_C";
            paramD = "TEST_NAVER_D";
        }else{
            paramA = "NAVER_A";
            paramB = "NAVER_B";
            paramC = "NAVER_C";
            paramD = "NAVER_D";
        }
    }

    public static Naver getTestInstance(){
        if(T_NAVER == null){
            T_NAVER = new Naver(HttpModeEnum.TEST);
        }
        return T_NAVER;
    }

    public static Naver getInstance(){
        if(P_NAVER == null){
            P_NAVER = new Naver(HttpModeEnum.PRODUCTION);
        }
        return P_NAVER;
    }

    @Override
    public HttpModeEnum getHttpMode() {
        return this.httpMode;
    }


    @Override
    public String getParamA() {
        return paramA;
    }

    @Override
    public String getParamB() {
        return paramB;
    }

    @Override
    public String getParamC() {
        return paramC;
    }

    @Override
    public String getParamD() {
        return paramD;
    }
}
