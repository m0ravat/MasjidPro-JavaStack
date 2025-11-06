package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- ComplaintRecord ----------
@Entity
@Table(name = "complaint_record")
public class ComplaintRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintID;
    private Integer studentID;
    private Integer teacherID;
    private String complaintTitle;
    @Column(columnDefinition = "TEXT")
    private String complaintDesc;
    private String meetingSet;
    private String outcome;
}
