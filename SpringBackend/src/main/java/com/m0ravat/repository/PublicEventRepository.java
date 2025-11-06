package com.m0ravat.repository;

import com.m0ravat.models.PublicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- PublicEvent ----------
@Repository
public interface PublicEventRepository extends JpaRepository<PublicEvent, Integer> {}
