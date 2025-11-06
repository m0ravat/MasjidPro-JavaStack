package com.m0ravat.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "exam_record")
public class ExamRecord {
    @EmbeddedId
    private ExamRecordKey id;
    private String takenAt;
}
