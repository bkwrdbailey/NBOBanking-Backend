package com.NBOBanking.controllers;

import com.NBOBanking.models.BankAccount;
import com.NBOBanking.models.Transaction;
import com.NBOBanking.services.IBankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/banking/")
public class BankingController {
    private IBankingService _service;

    public BankingController(IBankingService service) {
        _service = service;
    }

    /* /BankAccounts?userId={User's Bank Account id} */
    @GetMapping("bankaccounts")
    @ResponseBody
    public List<BankAccount> getBankAccounts(@RequestParam int userId)
    {
        return _service.getUsersAccounts(userId);
    }

    /* /Update/Amount (BankAccount object) */
    @PutMapping("update/amount")
    @ResponseBody
    public boolean updateBankAccountBalance(@RequestBody BankAccount newAccountBalance)
    {
        return _service.attemptToUpdateAccountBalance(newAccountBalance);
    }

    /* /New/BankAccount (BankAccount object) */
    @PostMapping("new/bankaccount")
    @ResponseBody
    public BankAccount createNewBankAccount(@RequestBody BankAccount newBankAccount)
    {
        return _service.attemptToCreateNewBankAccount(newBankAccount);
    }

    /* /New/Transaction (Transaction object) */
    @PostMapping("new/transaction")
    @ResponseBody
    public boolean createTransactionRecord(@RequestBody Transaction newTransaction)
    {
        return _service.attemptToCreateNewTransactionRecord(newTransaction);
    }

    /* /Account/Transactions?bankaccountId={Chosen Bank account's id} */
    @GetMapping("account/transactions")
    @ResponseBody
    public List<Transaction> getBankAccountTransactionHistory(@RequestParam int bankaccountId)
    {
        return _service.getTransactionHistory(bankaccountId);
    }
}
