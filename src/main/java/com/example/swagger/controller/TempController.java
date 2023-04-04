package com.example.swagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TempController {

    @GetMapping(value = "/test")
    @ApiOperation(value="test1", notes="테스트 v2")
    public String v2Test1(@RequestParam(required =false) String id, Model model){
        System.out.println("id = " + id);
        model.addAttribute("id",id);
        return "test";
    }
}
