package com.NBOBanking.controllerTests;

import com.NBOBanking.DTO.UserDTO;
import com.NBOBanking.controllers.UserController;
import com.NBOBanking.services.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTests {

    private IUserService mockService = mock(IUserService.class);

    @Test
    public void attemptToLogin_Return_User_Data() {
        UserDTO signedInUser = new UserDTO(1, "test", "man", "testman123", "", "testman123@email.com");

        when(mockService.verifyUserLogin("testman123", "password")).thenReturn(signedInUser);

        UserController controller = new UserController(mockService);
        UserDTO result = controller.attemptToLogin("testman123", "password");

        Assertions.assertEquals(signedInUser, result);
    }

    @Test
    public void attemptToSignup_Return_User_Data() {
        UserDTO newUser = new UserDTO(1, "test", "man", "testman123", "", "testman123@email.com");

        when(mockService.attemptNewUserRecord(newUser)).thenReturn(newUser);

        UserController controller = new UserController(mockService);
        UserDTO result = controller.attemptToSignUp(newUser);

        Assertions.assertEquals(newUser, result);
    }
}
