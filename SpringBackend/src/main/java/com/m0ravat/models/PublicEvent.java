package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- PublicEvent ----------
@Entity
@Table(name = "public_event")
public class PublicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventID;
    private String dateInfo;
    private String timeInfo;
    private String openTo;
    @Column(columnDefinition = "TEXT")
    private String eventDesc;
    private String relevantLinks;
    private String image;
    private String location;
    private String title;
    private String shortDesc;
}
