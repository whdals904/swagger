package com.example.swagger.common;

import lombok.ToString;
import org.apache.http.protocol.HTTP;


public class HttpComponent {

    private static final String common_aaa;
    private static final String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    private static HttpComponent testHttpComponent = null;
    private static HttpComponent productionHttpComponent = null;

    static{
        common_aaa="COMMON_AAA";
        common_bbb="COMMON_BBB";
    }
    private HttpComponent(HttpMode hm){
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
    public static HttpComponent getHttpComponent(HttpMode hm){
        if(HttpMode.TEST.equals(hm)){
            if(testHttpComponent == null){
                testHttpComponent = new HttpComponent(hm);
            }
            return testHttpComponent;
        }else {
            if(productionHttpComponent == null){
                productionHttpComponent = new HttpComponent(hm);
            }
            return productionHttpComponent;
        }
    }

    @Override
    public String toString() {
        return "HttpComponent{" +
                "aa='" + aa + '\'' +
                ", bb='" + bb + '\'' +
                ", cc='" + cc + '\'' +
                ", common_aaa='" + common_aaa + '\'' +
                ", common_bbb='" + common_bbb + '\'' +
                '}';
    }
}
