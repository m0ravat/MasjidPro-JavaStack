package com.m0ravat.repository;

import com.m0ravat.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Account ----------
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {}
