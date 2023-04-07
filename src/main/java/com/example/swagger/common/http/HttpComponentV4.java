package com.example.swagger.common.http;


import lombok.ToString;

@ToString
public class HttpComponentV4 {
    private String common_aaa;
    private String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private static HttpComponentV4 T_HTTP_COMPONENT;
    private static HttpComponentV4 P_HTTP_COMPONENT;

    private static enum HttpMode {
        TEST, PRODUCTION
    }

    private HttpComponentV4(HttpMode hm){
        common_aaa="COMMON_AAA";
        common_bbb="COMMON_BBB";

        if(HttpMode.TEST.equals(hm)){
            this.aa = "TEST AA";
            this.bb = "TEST BB";
            this.cc = "TEST CC";
        }else{
            this.aa = "PRODUCTION AA";
            this.bb = "PRODUCTION BB";
            this.cc = "PRODUCTION CC";
        }
    }
    public static HttpComponentV4 getTestInstance(){
        if(T_HTTP_COMPONENT == null){
            T_HTTP_COMPONENT = new HttpComponentV4(HttpMode.TEST);
        }
        return T_HTTP_COMPONENT;
    }

    public static HttpComponentV4 getInstance(){
        if(P_HTTP_COMPONENT == null){
            P_HTTP_COMPONENT = new HttpComponentV4(HttpMode.PRODUCTION);
        }
        return P_HTTP_COMPONENT;
    }

}
