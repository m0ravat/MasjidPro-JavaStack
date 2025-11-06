package com.m0ravat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

// ---------- Subject ----------
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(length = 100)
    private String subjectName;
    @Column(columnDefinition = "TEXT")
    private String subjectDesc;
    private String timeInfo;
    private String dateInfo;
    private Integer teacherID;
    private BigDecimal salary;
    private String hireDate;
    private String courseName;
}
