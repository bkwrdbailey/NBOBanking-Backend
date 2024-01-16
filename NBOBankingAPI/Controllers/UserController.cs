using Microsoft.AspNetCore.Mvc;
using NBOBankingAPI.Models;

namespace NBOBankingAPI.Controllers;

[Route("[controller]")]
[ApiController]
public class UserController : ControllerBase {

    public UserController() {

    }

    [HttpPost("/new/user")]
    public async Task<Boolean> PostNewUserAccount([FromBody] User newUserData) {
        return await ;
    }

    [HttpGet("/login/{username}/{password}")]
    public async Task<User> GetUserData(string username, string password) {
        return await ;
    }

    [HttpPut("/update/user")]
    public async Task<User> PutUpdatedUserData([FromBody] User updatedUserData) {
        return await ;
    }
}