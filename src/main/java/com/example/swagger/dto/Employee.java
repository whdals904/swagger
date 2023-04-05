package com.example.swagger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@AllArgsConstructor
@Data
public class Employee {

    @Id
    private String id;

    private String name;
}
