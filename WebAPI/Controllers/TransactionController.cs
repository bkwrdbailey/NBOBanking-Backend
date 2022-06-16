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

    [HttpGet]
    public async Task GetTransaction() {
        
    }

    [HttpPost]
    public async Task CreateTransaction() {
        
    }
}
