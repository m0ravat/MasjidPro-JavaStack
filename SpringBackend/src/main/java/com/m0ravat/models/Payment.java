package com.m0ravat.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

// ---------- Payment ----------
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentID;
    private String paymentType;
    private Boolean paymentReceived;
    private Boolean madeOnline;
    private BigDecimal amount;
    private String dateMade;
    private Integer paymentFor;
}
