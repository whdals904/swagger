package com.example.swagger.service;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.example.swagger.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    public void insertMember(Member member){
        testRepository.insertMember(member);
    }
    public void insertSchool(School school){
        testRepository.insertSchool(school);
    }
    public School findSchool(Long seq){
        return testRepository.findSchoolBySeq(seq);
    }
    public List<School> findAllSchool(){
        return testRepository.findAllSchool();
    }

    public List<Member> findAllMembers(){
        return testRepository.findAllMembers();
    }
}
