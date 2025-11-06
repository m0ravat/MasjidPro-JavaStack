package com.m0ravat.repository;

import com.m0ravat.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ---------- Book ----------
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {}
