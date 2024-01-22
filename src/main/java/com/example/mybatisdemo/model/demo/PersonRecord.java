package com.example.mybatisdemo.model.demo;

import lombok.Data;

import java.util.Date;

@Data
public class PersonRecord {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String employed;
    private String occupation;
    private Integer addressId;
}