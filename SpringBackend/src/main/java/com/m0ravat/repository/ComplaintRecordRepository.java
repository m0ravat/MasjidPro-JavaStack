package com.m0ravat.repository;

import com.m0ravat.models.ComplaintRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- ComplaintRecord ----------
@Repository
public interface ComplaintRecordRepository extends JpaRepository<ComplaintRecord, Integer> {}
