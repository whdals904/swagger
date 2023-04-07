package com.example.swagger.common.http;


import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class HttpComponentV5<T extends HttpUnit> {
    private String common_aaa;
    private String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private static HttpComponentV5 T_HTTP_COMPONENT;
    private static HttpComponentV5 P_HTTP_COMPONENT;

    private HttpComponentV5(T a) {
        common_aaa = "COMMON_AAA";
        common_bbb = "COMMON_BBB";

        this.aa = a.getParamA();
        this.bb = a.getParamB();
        this.cc = a.getParamC();
    }

    public static <K extends HttpUnit> HttpComponentV5<K> getInstance(K a){

        if(a.getHttpMode().equals(HttpUnit.HttpModeEnum.TEST)){
            if(T_HTTP_COMPONENT == null){
                T_HTTP_COMPONENT = new HttpComponentV5<K>(a);
            }
            return T_HTTP_COMPONENT;
        }else {
            if (P_HTTP_COMPONENT == null) {
                P_HTTP_COMPONENT = new HttpComponentV5<K>(a);
            }
            return P_HTTP_COMPONENT;
        }

//        if(a.getHttpMode().equals(HttpUnit.HttpModeEnum.TEST)){
//            if(T_HTTP_COMPONENT == null){
//                T_HTTP_COMPONENT = new HttpComponentV5<K>(a);
//            }
//            return T_HTTP_COMPONENT;
//        }else {
//            if (P_HTTP_COMPONENT == null) {
//                P_HTTP_COMPONENT = new HttpComponentV5<K>(a);
//            }
//            return P_HTTP_COMPONENT;
//        }
    }
}
