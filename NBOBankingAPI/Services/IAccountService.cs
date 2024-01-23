namespace NBOBankingAPI.Services;
using NBOBankingAPI.Models;

public interface IAccountService {
    Task<Boolean> AddNewAccountToDB(Account newAccount);
    Task<List<Account>> GetUsersAccountsFromDB(int userId);
    Task<Boolean> UpdateUserAccountInDB(Account updatedAccountData);
    Task<Boolean> RemoveAccountInDB(int userId, string accountNum);
}