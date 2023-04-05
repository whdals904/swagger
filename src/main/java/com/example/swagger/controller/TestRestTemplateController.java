package com.example.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestRestTemplateController {

    @Autowired
    private RestTemplate restTempate;

    @GetMapping("test")
    public void test(){

    }
}
