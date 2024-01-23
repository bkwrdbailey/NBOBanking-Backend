using Microsoft.AspNetCore.Mvc;
using NBOBankingAPI.Models;
using NBOBankingAPI.Services;

namespace NBOBankingAPI.Controllers;

[Route("[controller]")]
[ApiController]
public class UserController : ControllerBase {
    private readonly IUserService _service;
    public UserController(IUserService service) {
        _service = service;
    }

    [HttpPost("/user/signup")]
    public async Task<Boolean> PostNewUserAccount([FromBody] User newUserData) {
        return await _service.AddNewUserToDB(newUserData);
    }

    [HttpGet("/login/{username}/{password}")]
    public async Task<User> GetUserData(string username, string password) {
        return await _service.GetUserDataFromDB(username, password);
    }

    [HttpPut("/update/user")]
    public async Task<Boolean> PutModifiedUserData([FromBody] User updatedUserData) {
        return await _service.UpdateUserDataInDB(updatedUserData);
    }
}