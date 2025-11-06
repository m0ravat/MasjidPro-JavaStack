package com.m0ravat.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

// ---------- Book ----------
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;
    private String bookName;
    @Column(columnDefinition = "TEXT")
    private String bookDesc;
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String bookLinks;
}
