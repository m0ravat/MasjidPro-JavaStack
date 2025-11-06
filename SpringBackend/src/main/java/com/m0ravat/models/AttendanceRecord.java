package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- AttendanceRecord ----------
@Entity
@Table(name = "attendance_record")
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceID;
    private Integer studentID;
    private String subjectName;
    private String dateMarked;
    private Boolean isAbsent;
    private Boolean authorisedAbsence;
    private String extraInfo;
}
