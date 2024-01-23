using NBOBankingAPI.Models;
using NBOBankingAPI.Database;

namespace NBOBankingAPI.Services;

public class AccountService : IAccountService {
    private readonly IDatabaseCalls _dbService;
    public AccountService(IDatabaseCalls dbService) {
        _dbService = dbService;
    }

    public async Task<Boolean> AddNewAccountToDB(Account newAccount) {
        AccountDB newAccountDB = new AccountDB() { accountType = newAccount.accountType, accountBalance = newAccount.balance, accountNum = newAccount.accountNum };
        return await _dbService.AddAccountRecord(newAccountDB);
    }

    public async Task<List<Account>> GetUsersAccountsFromDB(int userId) {
        List<AccountDB> bankAccountsBE = await _dbService.GetAllUserAccountRecords(userId);
        List<Account> bankAccountsFE = new List<Account>();

        foreach (AccountDB bankAccountBE in bankAccountsBE) {
            Account bankAccountFE = new Account() { accountType = bankAccountBE.accountType, accountNum = bankAccountBE.accountNum, balance = bankAccountBE.accountBalance, transactionHistory = new List<Transaction>() };
            List<TransactionDB> accountTransactions = await _dbService.GetAllAccountTransactionRecords(bankAccountBE.accountId);

            foreach (TransactionDB transactionBE in accountTransactions) {
                bankAccountFE.transactionHistory.Add(new Transaction() { amount = transactionBE.transactionAmount, description = transactionBE.description, receiving = transactionBE.receiving, sending = transactionBE.sending });
            }
        }

        return bankAccountsFE;
    }

    public async Task<Boolean> UpdateUserAccountInDB(Account updatedAccountData) {
        AccountDB updatedAccountDataDB = new AccountDB() {accountNum = updatedAccountData.accountNum, accountBalance = updatedAccountData.balance, accountType = updatedAccountData.accountType};
        return await _dbService.UpdateAccountRecord(updatedAccountDataDB);
    }

    public async Task<Boolean> RemoveAccountInDB(int userId, string accountNum) {
        return await _dbService.RemoveAccountRecord(userId, accountNum);
    }
}