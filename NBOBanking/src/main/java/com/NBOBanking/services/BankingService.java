package com.NBOBanking.services;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;
import com.NBOBanking.repositories.IBankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingService implements IBankingService{
    private final IBankingRepository _repo;

    @Autowired
    public BankingService(IBankingRepository repo) {
        _repo = repo;
    }

    @Override
    public List<BankAccount> getUsersAccounts(int userId) {
        return _repo.getBankAccounts(userId);
    }

    @Override
    public BankAccount attemptToCreateNewBankAccount(BankAccount newBankAccount) {
        return _repo.createBankAccountRecord(newBankAccount);
    }

    @Override
    public List<Transaction> getTransactionHistory(int bankAccountId) {
        return _repo.getBankTransactions(bankAccountId);
    }

    @Override
    public boolean attemptToCreateNewTransactionRecord(Transaction newTransaction) {
        return _repo.createTransactionRecord(newTransaction);
    }

    @Override
    public boolean attemptToUpdateAccountBalance(BankAccount newAccountBalance) {
        return _repo.updateBankAccountBalance(newAccountBalance);
    }
}
