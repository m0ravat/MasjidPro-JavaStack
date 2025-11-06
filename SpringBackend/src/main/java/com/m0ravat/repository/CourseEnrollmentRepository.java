package com.m0ravat.repository;

import com.m0ravat.models.CourseEnrollment;
import com.m0ravat.models.CourseEnrollmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- CourseEnrollment ----------
@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, CourseEnrollmentKey> {}
