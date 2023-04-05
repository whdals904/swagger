package com.example.swagger.controller;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.example.swagger.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class TestController{

    @Autowired
    private TestService testService;

    @Autowired
    private EntityManager em;


    @GetMapping("/insert/member")
    @ResponseBody
    @Transactional
    public String insertMember(){
        Member member = new Member();
        member.setName("홍길동");
        member.setAge(40);

/*      School s = new School();
        s.setSeq(1L);
        member.setSchool(s);*/
        member.setSchool(testService.findSchool(1L));
        testService.insertMember(member);
        return "success";
    }

    @GetMapping("/insert/school")
    @ResponseBody
    @Transactional
    public String insertSchool(){
        School school = new School();
        school.setUniv_name("서울사이버대학교");

        testService.insertSchool(school);
        return "success";
    }

    @GetMapping("/select/members")
    @ResponseBody
    @Transactional
    public String selectMembers() {
        List<Member> allMembers = testService.findAllMembers();
        System.out.println("allMembers = " + allMembers);
        return "success";
    }
}
