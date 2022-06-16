using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class BankAccountController : ControllerBase
{
    private readonly IDBRepo _db;
    public BankAccountController(IDBRepo db) {
        _db = db;
    }

    [HttpGet]
    public async Task GetBankAccount() {
        
    }

    [HttpPost]
    public async Task CreateBankAccount() {
        
    }

}
