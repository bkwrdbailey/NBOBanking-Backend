using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class UserController : ControllerBase
{
    private readonly IDBRepo _db;
    public UserController(IDBRepo db) {
        _db = db;
    }

    [HttpGet]
    public async Task GetUser() {
        
    }

    [HttpPost]
    public async Task CreateUser() {
        
    }
}
