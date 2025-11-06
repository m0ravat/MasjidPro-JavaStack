package com.m0ravat.repository;

import com.m0ravat.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Subject ----------
@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {}
