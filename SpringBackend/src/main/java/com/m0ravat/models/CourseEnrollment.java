package com.m0ravat.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "course_enrollment")
public class CourseEnrollment {
    @EmbeddedId
    private CourseEnrollmentKey id;
    private String courseName;
    private String startDate;
    private String endDate;
    private String finalOutcome;
    private Boolean currentlyTaking;
}
