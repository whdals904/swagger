package com.example.swagger.common.http;


import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class HttpManagerV2 implements Serializable {

    public String common_aaa;
    public String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private static HttpManagerV2 T_HTTP_MANAGER;
    private static HttpManagerV2 P_HTTP_MANAGER;

    private static  enum HttpMode {
        TEST, PRODUCTION
    }

    private HttpManagerV2(HttpMode hm){
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
    public static HttpManagerV2 getTestHttpComponent(){
        if(T_HTTP_MANAGER == null){
            T_HTTP_MANAGER = new HttpManagerV2(HttpMode.TEST);
        }
        return T_HTTP_MANAGER;
    }

    public static HttpManagerV2 getHttpComponent(){
        if(P_HTTP_MANAGER == null){
            P_HTTP_MANAGER = new HttpManagerV2(HttpMode.PRODUCTION);
        }
        return P_HTTP_MANAGER;
    }
}
