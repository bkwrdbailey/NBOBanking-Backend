using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class TransactionController : ControllerBase
{
    private readonly IDBRepo _db;
    public TransactionController(IDBRepo db) {
        _db = db;
    }

    [HttpGet("GetAllTransactions/{accountId}")]
    public async Task<List<Transaction>> GetAllAccountTransactions(int accountId) {
        return await _db.GetAllTransactions(accountId);
    }

    [HttpPost("AddTransaction")]
    public async Task PostTransaction(Transaction newTransaction) {
        await _db.CreateTransaction(newTransaction);
    }
}
