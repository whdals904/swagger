package com.example.swagger.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class School extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String id;

    @OneToMany(mappedBy = "school")
    private List<Member> members = new ArrayList<Member>();

    private String univ_name;
    private String address;


    private void addMembers(Member member){
        members.add(member);
        if(member.getSchool() != this){
            member.setSchool(this);
        }
    }
}
