package com.m0ravat.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookAssignmentKey implements Serializable {
    private Integer uniqueAssignID;
    private Integer bookID;
    private String subjectName;

    // Getters and Setters
    public Integer getUniqueAssignID() { return uniqueAssignID; }
    public void setUniqueAssignID(Integer uniqueAssignID) { this.uniqueAssignID = uniqueAssignID; }

    public Integer getBookID() { return bookID; }
    public void setBookID(Integer bookID) { this.bookID = bookID; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookAssignmentKey)) return false;
        BookAssignmentKey that = (BookAssignmentKey) o;
        return Objects.equals(uniqueAssignID, that.uniqueAssignID) &&
                Objects.equals(bookID, that.bookID) &&
                Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueAssignID, bookID, subjectName);
    }
}

