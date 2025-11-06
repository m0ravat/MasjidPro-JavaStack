package com.m0ravat.repository;

import com.m0ravat.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- ExamRecord ----------
@Repository
public interface ExamRecordRepository extends JpaRepository<ExamRecord, ExamRecordKey> {}

