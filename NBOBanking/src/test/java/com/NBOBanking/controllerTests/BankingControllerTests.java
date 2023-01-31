package com.NBOBanking.controllerTests;

import com.NBOBanking.DTO.BankAccountDTO;
import com.NBOBanking.DTO.TransactionDTO;
import com.NBOBanking.controllers.BankingController;
import com.NBOBanking.services.IBankingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankingControllerTests {

    private IBankingService mockService = mock(IBankingService.class);

    @Test
    public void getBankAccounts_Return_List_Of_BankAccounts() {
        List<BankAccountDTO> bankAccounts = Arrays.asList(
                new BankAccountDTO(1, 1, "5421", 100.00, "checking"),
                new BankAccountDTO(2, 1, "5551", 500.00, "saving")
        );

        when(mockService.getUsersAccounts(1)).thenReturn(bankAccounts);

        BankingController controller = new BankingController(mockService);
        List<BankAccountDTO> result = controller.getBankAccounts(1);

        Assertions.assertEquals(bankAccounts, result);
    }

    @Test
    public void updateBankAccountBalance_Return_True_If_Account_Successfully_Updated() {
        BankAccountDTO newAccountBalance = new BankAccountDTO(1, 1, "6721", 123.45, "checking");

        when(mockService.attemptToUpdateAccountBalance(newAccountBalance)).thenReturn(true);

        BankingController controller = new BankingController(mockService);

        Assertions.assertTrue(controller.updateBankAccountBalance(newAccountBalance));
    }

    @Test
    public void createNewBankAccount_Return_Newly_Created_Account() {
        BankAccountDTO newBankAccount = new BankAccountDTO(1, 1, "6243", 444.00, "saving");

        when(mockService.attemptToCreateNewBankAccount(newBankAccount)).thenReturn(newBankAccount);

        BankingController controller = new BankingController(mockService);
        BankAccountDTO result = controller.createNewBankAccount(newBankAccount);

        Assertions.assertEquals(newBankAccount, result);
    }

    @Test
    public void createTransactionRecord_Return_True_If_Transaction_Record_Successfully_Created() {
        Date currDate = new Date(1022);
        TransactionDTO newTransaction = new TransactionDTO(1, "deposit", 20.00, currDate);

        when(mockService.attemptToCreateNewTransactionRecord(newTransaction)).thenReturn(true);

        BankingController controller = new BankingController(mockService);

        Assertions.assertTrue(controller.createTransactionRecord(newTransaction));
    }

    @Test
    public void getBankAccountTransactionHistory_Return_List_Of_Transactions_Tied_To_One_Account() {
        Date currDate = new Date(5123);
        List<TransactionDTO> transactions = Arrays.asList(
                new TransactionDTO(1, "deposit", 50.00, currDate),
                new TransactionDTO(1, "withdraw", 20.00, currDate)
        );

        when(mockService.getTransactionHistory(1)).thenReturn(transactions);

        BankingController controller = new BankingController(mockService);
        List<TransactionDTO> result = controller.getBankAccountTransactionHistory(1);

        Assertions.assertEquals(transactions, result);
    }

}
