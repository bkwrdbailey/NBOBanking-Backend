using NBOBankingAPI.Database;
using NBOBankingAPI.Models;

namespace NBOBankingAPI.Services;

public class UserService : IUserService {
    private readonly IDatabaseCalls _dbService;
    public UserService(IDatabaseCalls dbService) {
        _dbService = dbService;
    }

    public async Task<Boolean> AddNewUserToDB(User newUser) {
        await ;
        return true;
    }

    public async Task<User> GetUserDataFromDB(string username, string password) {
        // Call database method to retrieve UserDB data
        await ;
        // Convert UserDB object into a User frontend object
        // Return User object for frontend use
        return ;
    }

    public async Task<Boolean> UpdateUserDataInDB(User updatedUserData) {
        await ;
        return true;
    }
}