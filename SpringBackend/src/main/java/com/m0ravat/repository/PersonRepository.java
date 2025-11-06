package com.m0ravat.repository;

import com.m0ravat.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Person ----------
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {}
