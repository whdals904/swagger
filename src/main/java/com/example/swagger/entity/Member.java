package com.example.swagger.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne
    @JoinColumn(name="school_seq")
    private School school;

    private String name;

    private int age;

    private String password;

    private String email;


    public void setSchool(School school) {
        this.school = school;

        if(!school.getMembers().contains(this)){
            school.getMembers().add(this);
        }
    }
}