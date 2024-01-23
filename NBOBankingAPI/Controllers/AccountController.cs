using Microsoft.AspNetCore.Mvc;
using NBOBankingAPI.Models;
using NBOBankingAPI.Services;

namespace NBOBankingAPI.Controllers;

[Route("[controller]")]
[ApiController]
public class AccountController : ControllerBase {
    private readonly IAccountService _service;
    public AccountController(IAccountService service) {
        _service = service;
    }

    [HttpPost("/new/account")]
    public async Task<Boolean> PostNewAccount([FromBody] Account newAccountData) {
        return await _service.AddNewAccountToDB(newAccountData);
    }

    [HttpGet("/{userId}/accounts")]
    public async Task<List<Account>> GetUsersAccounts(int userId) {
        return await _service.GetUsersAccountsFromDB(userId);
    }

    [HttpPut("/update/account")]
    public async Task<Boolean> PutUpdatedAccountData([FromBody] Account updatedAccountData) {
        return await _service.UpdateUserAccountInDB(updatedAccountData);
    }

    [HttpDelete("/remove/account/{userId}/{accountNum}")]
    public async Task<Boolean> DeleteUserAccount(int userId, string accountNum) {
        return await _service.RemoveAccountInDB(userId, accountNum);
    }
}