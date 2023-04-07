package com.example.swagger.controller;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.example.swagger.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class TestController{

    @Autowired
    private TestService testService;


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
        return "success!!";
    }

    @GetMapping("/insert/school")
    @ResponseBody
    @Transactional
    public String insertSchool(){
        School school = new School();
        school.setUniv_name("서울사이버대학교");

        testService.insertSchool(school);
        return "success11";
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
