package com.example.swagger.common.http;


import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class HttpComponentV3 implements Serializable {

    private static HttpComponent T_HTTP_MANAGER;
    private static HttpComponent P_HTTP_MANAGER;

    public static HttpComponent getTestHttpComponent(){
        if(T_HTTP_MANAGER == null){
            T_HTTP_MANAGER = new HttpComponent(HttpComponent.HttpMode.TEST);
        }
        return T_HTTP_MANAGER;
    }

    public static HttpComponent getHttpComponent(){
        if(P_HTTP_MANAGER == null){
            P_HTTP_MANAGER = new HttpComponent(HttpComponent.HttpMode.PRODUCTION);
        }
        return P_HTTP_MANAGER;
    }
}
