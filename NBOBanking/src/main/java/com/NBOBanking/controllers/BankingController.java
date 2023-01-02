package com.NBOBanking.controllers;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;
import com.NBOBanking.services.IBankingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BankingController {
    private IBankingService _service;

    public BankingController(IBankingService service) {
        _service = service;
    }

    /* /BankAccounts?userId={User's Bank Account id} */
    @GetMapping("BankAccounts")
    @ResponseBody
    public ArrayList<BankAccount> getBankAccounts(@RequestParam int userId)
    {
        return _service.getUsersAccounts(userId);
    }

    /* /Update/Amount (BankAccount object) */
    @PutMapping("Update/Amount")
    @ResponseBody
    public boolean updateBankAccountBalance(@RequestBody BankAccount newAccountBalance)
    {
        return _service.attemptToUpdateAccountBalance(newAccountBalance);
    }

    /* /New/Bankaccount (BankAccount object) */
    @PostMapping("New/Bankaccount")
    @ResponseBody
    public BankAccount createNewBankAccount(@RequestBody BankAccount newBankAccount)
    {
        return _service.attemptToCreateNewBankAccount(newBankAccount);
    }

    /* /New/Transaction (Transaction object) */
    @PostMapping("New/Transaction")
    @ResponseBody
    public boolean createTransactionRecord(@RequestBody Transaction newTransaction)
    {
        return _service.attemptToCreateNewTransactionRecord(newTransaction);
    }

    /* /Account/Transactions?bankaccountId={Chosen Bank account's id} */
    @GetMapping("Account/Transactions")
    @ResponseBody
    public ArrayList<Transaction> getBankAccountTransactionHistory(@RequestParam int bankaccountId)
    {
        return _service.getTransactionHistory(bankaccountId);
    }
}
