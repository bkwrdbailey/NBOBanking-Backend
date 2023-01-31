package com.NBOBanking.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bankaccount_id", nullable = false)
    public Integer bankaccount_id;

    @Column(name = "user_id")
    public int user_id;

    @Column(name = "account_num")
    public long account_num;

    @Column(name = "total_amount")
    public double total_amount;

    @Column(name = "account_type")
    public String account_type;

    public  BankAccount() {

    }

    public BankAccount(Integer bankaccount_id, int user_id, long account_num, double total_amount, String account_type) {
        this.bankaccount_id = bankaccount_id;
        this.user_id = user_id;
        this.account_num = account_num;
        this.total_amount = total_amount;
        this.account_type = account_type;
    }

    public BankAccount(int user_id, long account_num, double total_amount, String account_type) {
        this.user_id = user_id;
        this.account_num = account_num;
        this.total_amount = total_amount;
        this.account_type = account_type;
    }
}
