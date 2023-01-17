package com.NBOBanking.services;

import com.NBOBanking.DTO.BankAccountDTO;
import com.NBOBanking.DTO.TransactionDTO;

import java.util.List;

public interface IBankingService {
    List<BankAccountDTO> getUsersAccounts(int userId);
    boolean attemptToUpdateAccountBalance(BankAccountDTO newAccountBalance);
    BankAccountDTO attemptToCreateNewBankAccount(BankAccountDTO newBankAccount);
    boolean attemptToCreateNewTransactionRecord(TransactionDTO newTransaction);
    List<TransactionDTO> getTransactionHistory(int bankAccountId);
}
