package com.NBOBanking.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    public int bankaccount_id;
    public String transaction_type;
    public double transaction_amount;
    public Date transaction_date;

    public TransactionDTO() { }

    public TransactionDTO(int bankaccount_id, String transaction_type, double transaction_amount, Date transaction_date) {
        this.bankaccount_id = bankaccount_id;
        this.transaction_type = transaction_type;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }
}
