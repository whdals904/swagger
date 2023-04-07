package com.example.swagger.common.http;

import lombok.Builder;
import lombok.Data;


public class Kakao implements HttpUnit {

    private static Kakao P_KAKAO;
    private static Kakao T_KAKAO;

    private String paramA;
    private String paramB;
    private String paramC;
    private String paramD;

    private HttpModeEnum httpMode;

    public Kakao(HttpModeEnum hm){

        this.httpMode = hm;
        System.out.println("============Kakao HttpMode = " + hm);

        if(HttpModeEnum.TEST.equals(hm)){
            paramA = "TEST_KAKAO_A";
            paramB = "TEST_KAKAO_B";
            paramC = "TEST_KAKAO_C";
            paramD = "TEST_KAKAO_D";
        }else{
            paramA = "KAKAO_A";
            paramB = "KAKAO_B";
            paramC = "KAKAO_C";
            paramD = "KAKAO_D";
        }
    }

    public static Kakao getTestInstance(){
        if(T_KAKAO == null){
            T_KAKAO = new Kakao(HttpModeEnum.TEST);
        }
        return T_KAKAO;
    }

    public static Kakao getInstance(){
        if(P_KAKAO == null){
            P_KAKAO = new Kakao(HttpModeEnum.PRODUCTION);
        }
        return P_KAKAO;
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
