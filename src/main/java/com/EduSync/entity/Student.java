package com.EduSync.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.spi.CascadeStyles;

import java.util.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String firstName;
    private String lastName;
    private Date DOB;
    //private Enum gender;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
