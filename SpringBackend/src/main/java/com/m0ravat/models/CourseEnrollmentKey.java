package com.m0ravat.models;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.io.Serializable;

@Embeddable
public class CourseEnrollmentKey implements Serializable {
    private Integer enrolID;
    private Integer studentID;

    public Integer getEnrolID() { return enrolID; }
    public void setEnrolID(Integer enrolID) { this.enrolID = enrolID; }

    public Integer getStudentID() { return studentID; }
    public void setStudentID(Integer studentID) { this.studentID = studentID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseEnrollmentKey)) return false;
        CourseEnrollmentKey that = (CourseEnrollmentKey) o;
        return Objects.equals(enrolID, that.enrolID) &&
                Objects.equals(studentID, that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrolID, studentID);
    }
}
