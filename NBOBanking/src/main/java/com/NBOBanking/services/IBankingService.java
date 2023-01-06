package com.NBOBanking.services;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;

import java.util.List;

public interface IBankingService {
    List<BankAccount> getUsersAccounts(int userId);
    boolean attemptToUpdateAccountBalance(BankAccount newAccountBalance);
    BankAccount attemptToCreateNewBankAccount(BankAccount newBankAccount);
    boolean attemptToCreateNewTransactionRecord(Transaction newTransaction);
    List<Transaction> getTransactionHistory(int bankAccountId);
}
