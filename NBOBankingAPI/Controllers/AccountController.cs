using Microsoft.AspNetCore.Mvc;
using NBOBankingAPI.Models;

namespace NBOBankingAPI.Controllers;

[Route("[controller]")]
[ApiController]
public class AccountController : ControllerBase {
    public AccountController() {

    }

    [HttpPost("/new/bank/account")]
    public async Task<Boolean> PostNewBankAccount([FromBody] Account newBankAccountData) {
        return await ;
    }

    [HttpPost("/new/loan")]
    public async Task<Boolean> PostNewLoan([FromBody] Loan newLoanData) {
        return await ;
    }
}