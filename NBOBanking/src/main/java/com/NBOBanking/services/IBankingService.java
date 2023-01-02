package com.NBOBanking.services;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;

import java.util.ArrayList;

public interface IBankingService {
    ArrayList<BankAccount> getUsersAccounts(int userId);
    boolean attemptToUpdateAccountBalance(BankAccount newAccountBalance);
    BankAccount attemptToCreateNewBankAccount(BankAccount newBankAccount);
    boolean attemptToCreateNewTransactionRecord(Transaction newTransaction);
    ArrayList<Transaction> getTransactionHistory(int bankAccountId);
}
