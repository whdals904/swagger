package com.example.swagger.common.http;

public class HttpComponent{
    public String common_aaa;
    public String common_bbb;

    private String aa;
    private String bb;
    private String cc;

    public static enum HttpMode {
        TEST, PRODUCTION
    }

    public HttpComponent(HttpMode hm){
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
}
