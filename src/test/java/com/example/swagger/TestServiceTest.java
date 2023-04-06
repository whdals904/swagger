package com.example.swagger;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.example.swagger.service.TestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @BeforeEach
    @Transactional
    public void 사전작업() throws InterruptedException {
        School s = new School();
        s.setUniv_name("한양대");
        s.setAddress("서울");
                    
        testService.insertSchool(s);

        School s1 = new School();
        s1.setUniv_name("고려대");
        s1.setAddress("서울");

        testService.insertSchool(s1);

        School s3 = new School();
        s3.setUniv_name("연세대");
        s3.setAddress("서울");
        testService.insertSchool(s3);
        System.out.println("==============21312312312312==============");
    }
    @Test
    @Transactional
    public void test1() throws InterruptedException {
        Assertions.assertEquals(3, testService.findAllSchool().size());
    }
}
