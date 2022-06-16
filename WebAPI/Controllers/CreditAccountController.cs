using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class CreditAccountController : ControllerBase
{
    private readonly IDBRepo _db;
    public CreditAccountController(IDBRepo db) {
        _db = db;
    }

    [HttpGet]
    public async Task GetCreditAccount() {
        
    }

    [HttpPost]
    public async Task CreateCreditAccount() {
        
    }
}
