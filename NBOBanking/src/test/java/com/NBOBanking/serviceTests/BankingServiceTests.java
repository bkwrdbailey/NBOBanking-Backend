package com.NBOBanking.serviceTests;

import com.NBOBanking.DTO.BankAccountDTO;
import com.NBOBanking.DTO.TransactionDTO;
import com.NBOBanking.Entities.BankAccount;
import com.NBOBanking.Entities.Transaction;
import com.NBOBanking.repositories.IBankingRepository;
import com.NBOBanking.services.BankingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BankingServiceTests {

    private IBankingRepository mockRepo = mock(IBankingRepository.class);

    @Test
    public void getUsersAccounts_Return_List_Of_Users_BankAccounts() {
        List<BankAccountDTO> bankAccountDTOs = Arrays.asList(
          new BankAccountDTO(1, 1, "9245", 1000.00, "checking"),
          new BankAccountDTO(2, 1, "8774", 200.00, "saving")
        );

        List<BankAccount> bankAccounts = Arrays.asList(
          new BankAccount(1, 1, 1342569245, 1000.00, "checking"),
          new BankAccount(2, 1, 512128774, 200.00, "saving")
        );

        when(mockRepo.getBankAccounts(1)).thenReturn(bankAccounts);

        BankingService service = new BankingService(mockRepo);
        List<BankAccountDTO> result = service.getUsersAccounts(1);

        Assertions.assertEquals(bankAccountDTOs.size(), result.size());
    }

    @Test
    public void attemptToCreateNewBankAccount_Return_Newly_Created_BankAccount() {
        BankAccountDTO newBankAccount = new BankAccountDTO(1, 1, "6543", 0, "checking");
        BankAccount newBankAccountRecord = new BankAccount(1, 311236543, 0, "checking");

        when(mockRepo.createBankAccountRecord(newBankAccountRecord)).thenReturn(newBankAccountRecord);


        BankingService service = new BankingService(mockRepo);
        BankAccountDTO result = service.attemptToCreateNewBankAccount(newBankAccount);

        Assertions.assertEquals(newBankAccount, result);
    }

    @Test
    public void getTransactionHistory_Return_List_Of_TransactionDTOs() {
        Date currDate = new Date(6729);
        List<TransactionDTO> transactions = Arrays.asList(
          new TransactionDTO(1, "deposit", 100.00, currDate),
          new TransactionDTO(1, "witdraw", 50.00, currDate)
        );

        List<Transaction> transactionRecords = Arrays.asList(
          new Transaction(1, 1, "deposit", 100.00, currDate),
          new Transaction(2, 1, "withdraw", 50.00, currDate)
        );

        when(mockRepo.getBankTransactions(1)).thenReturn(transactionRecords);

        BankingService service = new BankingService(mockRepo);
        List<TransactionDTO> result = service.getTransactionHistory(1);

        Assertions.assertEquals(transactions.size(), result.size());
    }

    @Test
    public void attemptToCreateNewTransactionRecord_Return_True_If_Record_Was_Successfully_Created() {
        Date currDate = new Date(1152);
        TransactionDTO newTransaction = new TransactionDTO(1, "deposit", 200.00, currDate);
        Transaction newTransactionRecord = new Transaction(1, 1, "deposit", 200.00, currDate);

        when(mockRepo.createTransactionRecord(newTransactionRecord)).thenReturn(true);

        BankingService service = new BankingService(mockRepo);

        Assertions.assertTrue(service.attemptToCreateNewTransactionRecord(newTransaction));
    }

    @Test
    public void attemptToUpdateAccountBalance_Return_True_If_Account_Balance_Successfully_Updated() {
        BankAccountDTO updatedBankAccount = new BankAccountDTO(1, 1, "6532", 1000.00, "checking");
        BankAccount updatedBankAccountRecord = new BankAccount(1, 1, 0, 1000.00, "checking");

        when(mockRepo.updateBankAccountBalance(updatedBankAccountRecord)).thenReturn(true);

        BankingService service = new BankingService(mockRepo);

        Assertions.assertTrue(service.attemptToUpdateAccountBalance(updatedBankAccount));
    }
}
