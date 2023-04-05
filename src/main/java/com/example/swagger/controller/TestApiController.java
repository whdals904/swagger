package com.example.swagger.controller;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RestController
@Api(value="TestApiController")
public class TestApiController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping(value = "/v1/api/test")
    @ApiOperation(value="v1 test1", notes="테스트 v1")
    @Transactional
    public String Test1(@RequestParam(required =false) String id){
        System.out.println("id = " + id);



        School school = new School();
        school.setId("UNIV002");
        school.setAddress("서울시 마포구 123");
        school.setUniv_name("홍익대학교");

        Member member = new Member();
        member.setName("김종윤");
        member.setPassword("1234");
        member.setEmail("whdals904@iscu.ac.kr");
        member.setSchool(school);
        em.persist(member);

        em.persist(school);


        em.flush();
        em.clear();

        Member me = em.find(Member.class,1L);
        System.out.println("me = " + me);


        return "test1";
    }

    @GetMapping(value = "/v1/api/test2")
    @ApiOperation(value="v1 test2", notes="테스트 v1")
    public String Test11(@RequestParam(required =false) String id){
        System.out.println("idd = " + id);
        return "test2";
    }




    @GetMapping(value = "/v2/api/test2")
    @ApiOperation(value="test1", notes="테스트 v2")
    public String v2Test2(@RequestParam(required =false) String id){
        System.out.println("id = " + id);
        return "test2";
    }
}
