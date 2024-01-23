using NBOBankingAPI.Models;

namespace NBOBankingAPI.Services;

public interface IUserService {
    Task<Boolean> AddNewUserToDB(User newUser);
    Task<User> GetUserDataFromDB(string username, string password);
    Task<Boolean> UpdateUserDataInDB(User updatedUserData);
}