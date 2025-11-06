package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- Exam ----------
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examID;
    private String examTitle;
    @Column(columnDefinition = "TEXT")
    private String examDesc;
    private String forSubject;
}
