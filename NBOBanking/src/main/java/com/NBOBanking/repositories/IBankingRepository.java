package com.NBOBanking.repositories;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;

import java.util.List;

public interface IBankingRepository {
    boolean createTransactionRecord(Transaction newTransaction);
    BankAccount createBankAccountRecord(BankAccount newBankAccount);
    List<Transaction> getBankTransactions(int bankAccountId);
    List<BankAccount> getBankAccounts(int userId);
    boolean updateBankAccountBalance(BankAccount updatedBalance);
}
