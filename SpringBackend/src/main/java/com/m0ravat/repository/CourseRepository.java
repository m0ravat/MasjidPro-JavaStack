package com.m0ravat.repository;

import com.m0ravat.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Course ----------
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {}
