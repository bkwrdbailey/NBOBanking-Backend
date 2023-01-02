package com.NBOBanking.services;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;

import java.util.ArrayList;

public class BankingService implements IBankingService{
    public BankingService() {

    }

    @Override
    public ArrayList<BankAccount> getUsersAccounts(int userId) {
        return null;
    }

    @Override
    public BankAccount attemptToCreateNewBankAccount(BankAccount newBankAccount) {
        return null;
    }

    @Override
    public ArrayList<Transaction> getTransactionHistory(int bankAccountId) {
        return null;
    }

    @Override
    public boolean attemptToCreateNewTransactionRecord(Transaction newTransaction) {
        return false;
    }

    @Override
    public boolean attemptToUpdateAccountBalance(BankAccount newAccountBalance) {
        return false;
    }
}
