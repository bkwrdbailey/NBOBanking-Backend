package com.NBOBanking.services;

import com.NBOBanking.DTO.BankAccountDTO;
import com.NBOBanking.DTO.TransactionDTO;
import com.NBOBanking.Entities.BankAccount;
import com.NBOBanking.Entities.Transaction;
import com.NBOBanking.repositories.IBankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BankingService implements IBankingService{
    private final IBankingRepository _repo;

    @Autowired
    public BankingService(IBankingRepository repo) {
        _repo = repo;
    }

    @Override
    public List<BankAccountDTO> getUsersAccounts(int userId) {
        List<BankAccount> bankAccountsDB = _repo.getBankAccounts(userId);

        List<BankAccountDTO> bankAccounts = new ArrayList<>();

        // Lambda expression for turning a list of BankAccount entity objects into a list of BankAccount DTO objects
        bankAccountsDB.forEach(account -> { BankAccountDTO accountDTO = new BankAccountDTO(account.bankaccount_id, account.user_id, stringifyAccountNum(account.account_num), account.total_amount, account.account_type); bankAccounts.add(accountDTO); });

        /*
        for(BankAccount account : bankAccountsDB) {
            BankAccountDTO accountDTO = new BankAccountDTO(account.bankaccount_id, account.user_id, stringifyAccountNum(account.account_num), account.total_amount, account.account_type);
            bankAccounts.add(accountDTO);
        }
        */

        return bankAccounts;
    }

    @Override
    public BankAccountDTO attemptToCreateNewBankAccount(BankAccountDTO newBankAccount) {
        BankAccount newBankAccountRecord = new BankAccount(newBankAccount.user_id, accountNumGenerator(), newBankAccount.total_amount, newBankAccount.account_type);
        newBankAccountRecord = _repo.createBankAccountRecord(newBankAccountRecord);

        return new BankAccountDTO(newBankAccountRecord.bankaccount_id, newBankAccountRecord.user_id, stringifyAccountNum(newBankAccountRecord.account_num), newBankAccountRecord.total_amount, newBankAccountRecord.account_type);
    }

    @Override
    public List<TransactionDTO> getTransactionHistory(int bankAccountId) {
        List<TransactionDTO> transactions = new ArrayList<>();
        List<Transaction> transactionsDB = _repo.getBankTransactions(bankAccountId);

        // Lambda Expression for iterating through transactionDB list to convert entity models to DTO models for passing back to the frontend
        transactionsDB.forEach((record) -> { TransactionDTO transaction = new TransactionDTO(record.bankaccount_id, record.transaction_type, record.transaction_amount, record.transaction_date); transactions.add(transaction); });

        /*
        for(Transaction record : transactionsDB) {
            TransactionDTO transaction = new TransactionDTO(record.bankaccount_id, record.transaction_type, record.transaction_amount, record.transaction_date);
            transactions.add(transaction);
        }
        */

        return transactions;
    }

    @Override
    public boolean attemptToCreateNewTransactionRecord(TransactionDTO newTransaction) {
        Transaction newTransactionDB = new Transaction(newTransaction.bankaccount_id, newTransaction.transaction_type, newTransaction.transaction_amount, newTransaction.transaction_date);
        return _repo.createTransactionRecord(newTransactionDB);
    }

    @Override
    public boolean attemptToUpdateAccountBalance(BankAccountDTO newAccountBalance) {
        BankAccount newAccountBalanceDB = new BankAccount(newAccountBalance.bankaccount_id, newAccountBalance.user_id, 0, newAccountBalance.total_amount, newAccountBalance.account_type);
        return _repo.updateBankAccountBalance(newAccountBalanceDB);
    }

    private long accountNumGenerator() {
        Random randLong = new Random();
        return randLong.nextLong(11111111, 999999999);
    }

    private String stringifyAccountNum(long accountNum) {
        String longString = Long.toString(accountNum);
        return longString.substring(longString.length() - 4);
    }
}
