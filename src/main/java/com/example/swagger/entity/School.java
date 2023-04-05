package com.example.swagger.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class School implements Serializable {

    @Id
    @GeneratedValue
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
