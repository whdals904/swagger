package com.example.swagger.repository;

import com.example.swagger.entity.Member;
import com.example.swagger.entity.School;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.swagger.entity.QMember.member;

@Repository
public class TestRepository {

    @Autowired
    private JPAQueryFactory query;

    @Autowired
    private EntityManager em;

    public void insert(Member m){

        em.persist(m);
        System.out.println("m = " + m);
    }

    public void insertMember(Member m) {
        em.persist(m);
        System.out.println("m = " + m);
    }

    public void insertSchool(School s) {
        em.persist(s);
        System.out.println("s = " + s);
    }

    public School findSchoolBySeq(Long seq) {
        return em.find(School.class,seq);
    }

    public List<Member> findAllMembers() {
        //return em.createQuery("select m from Member m", Member.class).getResultList();
        return query.selectFrom(member).fetch();
    }
}
