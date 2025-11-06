package com.m0ravat.repository;

import com.m0ravat.models.BookAssignment;
import com.m0ravat.models.BookAssignmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- BookAssignment ----------
@Repository
public interface BookAssignmentRepository extends JpaRepository<BookAssignment, BookAssignmentKey> {}
