package com.EduSync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private Date DOB;
    private Enum gender;
    private String phone;
    @OneToOne
    private Address address;
}
