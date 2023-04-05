package com.example.swagger.controller;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.example.swagger.entity.QMember.member;
import static com.example.swagger.entity.QSchool.school;

@Controller
@RestController
@Api(value="TestApiController")
public class TestApiController {

    @Autowired
    private EntityManager em;

    @Autowired
    private JPAQueryFactory query;

    @GetMapping(value = "/v1/api/test")
    @ApiOperation(value="v1 test1", notes="테스트 v1")
    @Transactional
    public String Test1(@RequestParam(required =false) String id){
        System.out.println("id = " + id);

        School school = new School();
        school.setId("UNIV002");
        school.setAddress("서울시 마포구 123");
        school.setUniv_name("샤넬대학교");

        Member member = new Member();
        member.setName("홍길순");
        member.setPassword("1234");
        member.setEmail("test@test.com");
        member.setSchool(school);
        em.persist(member);

        em.persist(school);


        em.flush();
        em.clear();

        Member me = em.find(Member.class,1L);

        return "test1";
    }

    @GetMapping(value = "/v1/api/test2")
    @ApiOperation(value="v1 test2", notes="테스트 v1")
    public String Test11(@RequestParam(required =false) String id){

        List<Member> temp = query.selectFrom(member).where(member.name.eq("김종민").and(member.age.lt(100))).fetch();
        System.out.println("temp = " + temp);
        return "test2";
    }




    @GetMapping(value = "/v2/api/test2")
    @ApiOperation(value="test1", notes="테스트 v2")
    public String v2Test2(@RequestParam(required =false) String id){
        System.out.println("id = " + id);
        return "test2";
    }
}
