package com.example.swagger.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne
    @JoinColumn(name="school_id", foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT),  referencedColumnName = "id")
    @ToString.Exclude
    private School school;

    private String name;

    private String password;

    private String email;


    public void setSchool(School school) {
        this.school = school;

        if(!school.getMembers().contains(this)){
            school.getMembers().add(this);
        }
    }
}