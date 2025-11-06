package com.m0ravat.repository;

import com.m0ravat.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Payment ----------
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {}
