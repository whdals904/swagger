package com.example.swagger.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@EqualsAndHashCode(callSuper = true)
@Data()
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne
    @JoinColumn(name="school_seq")
    @ToString.Exclude
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