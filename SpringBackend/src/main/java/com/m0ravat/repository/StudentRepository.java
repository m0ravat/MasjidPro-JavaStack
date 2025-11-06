package com.m0ravat.repository;

import com.m0ravat.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Student ----------
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {}
