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

    [HttpPost("AddUser")]
    public async Task<User> PostUser(User newUser) {
        return await _db.CreateUser(newUser);
    }
}
