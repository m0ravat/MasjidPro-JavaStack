package com.m0ravat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

// ---------- Course ----------
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(length = 100)
    private String courseName;
    @Column(columnDefinition = "TEXT")
    private String courseDesc;
    private BigDecimal price;
    private String duration;
    private String summary;
    @Column(columnDefinition = "TEXT")
    private String image;
    private String targetAge;
}
