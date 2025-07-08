package com.EduSync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
}
