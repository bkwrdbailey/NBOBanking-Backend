using Microsoft.AspNetCore.Mvc;
using NBOBankingAPI.Models;
using NBOBankingAPI.Services;

namespace NBOBankingAPI.Controllers;

[Route("[controller]")]
[ApiController]
public class LoanController : ControllerBase {
    private readonly ILoanService _service;
    public LoanController(ILoanService service) {
        _service = service;
    }

    [HttpPost("/new/loan")]
    public async Task<Boolean> PostNewLoan([FromBody] Loan newLoanData) {
        return await _service.AddNewLoanToDB(newLoanData);
    }

    [HttpPut("/update/loan")]
    public async Task<Boolean> PutUpdatedLoan([FromBody] Loan updatedLoanData) {
        return await _service.UpdateLoanInfoInDB(updatedLoanData);
    }

    [HttpGet("/{userId}/loans")]
    public async Task<List<Loan>> GetUsersLoans(int userId) {
        return await _service.GetLoansFromDB(userId);
    }
}