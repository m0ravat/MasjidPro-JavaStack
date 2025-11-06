package com.m0ravat.repository;

import com.m0ravat.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Exam ----------
@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {}
