package com.NBOBanking.repositories;

import com.NBOBanking.Entities.BankAccount;
import com.NBOBanking.Entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBankingRepository {
    boolean createTransactionRecord(Transaction newTransaction);
    BankAccount createBankAccountRecord(BankAccount newBankAccount);
    List<Transaction> getBankTransactions(int bankAccountId);
    List<BankAccount> getBankAccounts(int userId);
    boolean updateBankAccountBalance(BankAccount updatedBalance);
}
