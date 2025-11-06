package com.m0ravat.repository;

import com.m0ravat.models.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- AttendanceRecord ----------
@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Integer> {}
