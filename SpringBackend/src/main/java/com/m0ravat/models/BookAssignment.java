package com.m0ravat.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "book_assigment")
public class BookAssignment {
    @EmbeddedId
    private BookAssignmentKey id;
}
