package com.NBOBanking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Bank_Accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bankaccount_id", nullable = false)
    public Integer bankaccount_id;

    @Column(name = "user_id")
    public int user_id;

    @Column(name = "total_amount")
    public int total_amount;

    @Column(name = "account_type")
    public String account_type;
}
