package com.example.traveloka.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String account;
    private String password;
    private String name;
    private String age;
    private String email;
    private String address;
    private String sex;
    private String birthday;

    public UserDTO(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
