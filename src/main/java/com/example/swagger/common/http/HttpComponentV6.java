package com.example.swagger.common.http;


import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class HttpComponentV6<T extends HttpUnit> {
    private String common_aaa;
    private String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private final Map<T, HttpComponentV6<T>> httpComponentMap = new HashMap<>();

    public HttpComponentV6() {

    }
    private HttpComponentV6(T a) {
        common_aaa = "COMMON_AAA";
        common_bbb = "COMMON_BBB";

        this.aa = a.getParamA();
        this.bb = a.getParamB();
        this.cc = a.getParamC();
    }


    public HttpComponentV6<T> getInstance(T a){

        HttpComponentV6<T> hcv6 = httpComponentMap.get(a);
        System.out.println("hcv6 = " + hcv6);
        if(hcv6 == null){
            HttpComponentV6<T> temp = new HttpComponentV6<T>(a);
            httpComponentMap.put(a, temp);
            return temp;
        }
        return hcv6;

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
