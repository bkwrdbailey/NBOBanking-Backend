package com.NBOBanking.Entities;

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
    public double transaction_amount;

    @Column(name = "transaction_date")
    public Date transaction_date;

    public Transaction() {

    }

    public Transaction(Integer transaction_id, int bankaccount_id, String transaction_type, double transaction_amount, Date transaction_date) {
        this.transaction_id = transaction_id;
        this.bankaccount_id = bankaccount_id;
        this.transaction_type = transaction_type;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }
}
