package com.example.swagger;

import com.example.swagger.controller.TestController;
import com.example.swagger.dto.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;


@SpringBootTest
public class BeanTest {
    @Autowired
    DefaultListableBeanFactory bf;

    @Autowired
    private EntityManager em;
    @Test
    public void beans(){
        for(String n : bf.getBeanDefinitionNames()){
            System.out.println(bf.getBeanDefinition(n).isSingleton() + " \t" + n + " \t" + bf.getBean(n).getClass().getName() );
//            System.out.println( bf.getBeanDefinition(n).getScope() + "-" + n);
        }
    }
}