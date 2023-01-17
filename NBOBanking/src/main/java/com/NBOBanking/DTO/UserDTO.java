package com.NBOBanking.DTO;

import lombok.Data;

@Data
public class UserDTO {
    public int user_id;
    public String firstname;
    public String lastname;
    public String username;
    public String password;
    public String email;

    public UserDTO() { }

    public UserDTO(int user_id, String firstname, String lastname, String username, String password, String email) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}