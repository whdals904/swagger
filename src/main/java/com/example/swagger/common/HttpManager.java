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

    private static HttpManager testHttpManager;
    private static HttpManager productionHttpManager;

    static{

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
        if(HttpMode.TEST.equals(hm)){
            if(testHttpManager == null){
                testHttpManager = new HttpManager(hm);
            }
            return testHttpManager;
        }else {
            if(productionHttpManager == null){
                productionHttpManager = new HttpManager(hm);
            }
            return productionHttpManager;
        }
    }
}
