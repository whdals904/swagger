package com.example.swagger.common;


import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@ToString
public class HttpManager implements Serializable {

    public String common_aaa;
    public String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private static HttpManager T_HTTP_MANAGE;
    private static HttpManager P_HTTP_MANAGER;

    public static enum HttpMode {
        TEST, PRODUCTON
    }


    private HttpManager(HttpMode hm){
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
    public static HttpManager getHttpComponent(HttpMode hm){

        if(hm == null){
            hm = HttpMode.PRODUCTON;
        }

        if(HttpMode.TEST.equals(hm)){
            if(T_HTTP_MANAGE == null){
                T_HTTP_MANAGE = new HttpManager(hm);
            }
            return T_HTTP_MANAGE;
        }else {
            if(P_HTTP_MANAGER == null){
                P_HTTP_MANAGER = new HttpManager(hm);
            }
            return P_HTTP_MANAGER;
        }
    }
}
