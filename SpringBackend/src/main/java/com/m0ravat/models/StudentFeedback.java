package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- StudentFeedback ----------
@Entity
@Table(name = "student_feedback")
public class StudentFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackID;
    @Column(columnDefinition = "TEXT")
    private String feedbackGiven;
    private Integer studentID;
    private Integer teacherID;
}
