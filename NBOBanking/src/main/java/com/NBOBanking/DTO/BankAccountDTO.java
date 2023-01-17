package com.NBOBanking.DTO;

import lombok.Data;

@Data
public class BankAccountDTO {
    public int bankaccount_id;
    public int user_id;
    public String account_num;
    public double total_amount;
    public String account_type;

    public BankAccountDTO() { }

    public BankAccountDTO(int bankaccount_id, int user_id, String account_num, double total_amount, String account_type) {
        this.bankaccount_id = bankaccount_id;
        this.user_id = user_id;
        this.account_num = account_num;
        this.total_amount = total_amount;
        this.account_type = account_type;
    }
}
