package com.m0ravat.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

// ---------- Student ----------
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;
    private BigDecimal debtOwes;
}
