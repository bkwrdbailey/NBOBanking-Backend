package com.NBOBanking.controllers;

import com.NBOBanking.DTO.BankAccountDTO;
import com.NBOBanking.DTO.TransactionDTO;
import com.NBOBanking.services.IBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/banking/")
public class BankingController {
    private final IBankingService _service;

    @Autowired
    public BankingController(IBankingService service) {
        _service = service;
    }

    /* /BankAccounts?userId={User's Bank Account id} */
    @GetMapping("bankaccounts")
    @ResponseBody
    public List<BankAccountDTO> getBankAccounts(@RequestParam int userId)
    {
        return _service.getUsersAccounts(userId);
    }

    /* /Update/Amount (BankAccount object) */
    @PutMapping("update/amount")
    @ResponseBody
    public boolean updateBankAccountBalance(@RequestBody BankAccountDTO newAccountBalance)
    {
        return _service.attemptToUpdateAccountBalance(newAccountBalance);
    }

    /* /New/BankAccount (BankAccount object) */
    @PostMapping("new/bankaccount")
    @ResponseBody
    public BankAccountDTO createNewBankAccount(@RequestBody BankAccountDTO newBankAccount)
    {
        return _service.attemptToCreateNewBankAccount(newBankAccount);
    }

    /* /New/Transaction (Transaction object) */
    @PostMapping("new/transaction")
    @ResponseBody
    public boolean createTransactionRecord(@RequestBody TransactionDTO newTransaction)
    {
        return _service.attemptToCreateNewTransactionRecord(newTransaction);
    }

    /* /Account/Transactions?bankaccountId={Chosen Bank account's id} */
    @GetMapping("account/transactions")
    @ResponseBody
    public List<TransactionDTO> getBankAccountTransactionHistory(@RequestParam int bankaccountId)
    {
        return _service.getTransactionHistory(bankaccountId);
    }
}
