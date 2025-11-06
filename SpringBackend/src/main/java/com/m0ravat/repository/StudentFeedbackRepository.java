package com.m0ravat.repository;

import com.m0ravat.models.StudentFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- StudentFeedback ----------
@Repository
public interface StudentFeedbackRepository extends JpaRepository<StudentFeedback, Integer> {}
