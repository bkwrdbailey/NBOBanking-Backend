package com.NBOBanking.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    public Integer transaction_id;

    @Column(name = "bankaccount_id")
    public int bankaccount_id;

    @Column(name = "transaction_type")
    public String transaction_type;

    @Column(name = "transaction_amount")
    public int transaction_amount;

    @Column(name = "transaction_date")
    public Date transaction_date;
}
