package com.m0ravat.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ExamRecordKey implements Serializable {
    private Integer studentID;
    private Integer examID;

    public Integer getStudentID() { return studentID; }
    public void setStudentID(Integer studentID) { this.studentID = studentID; }

    public Integer getExamID() { return examID; }
    public void setExamID(Integer examID) { this.examID = examID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamRecordKey)) return false;
        ExamRecordKey that = (ExamRecordKey) o;
        return Objects.equals(studentID, that.studentID) &&
                Objects.equals(examID, that.examID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, examID);
    }
}
