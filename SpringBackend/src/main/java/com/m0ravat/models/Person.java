package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- Person ----------
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personID;
    private String firstName;
    private String lastName;
    private String doB;
    private String gender;
    private String homeAddress;
    private String email;
    private String phoneNo;
    @Column(columnDefinition = "TEXT")
    private String applicationInfo;
    private String typeOfPerson;
    private String medicalInfo;
    private Boolean userFlag;
    private Integer relationshipWith;
}
