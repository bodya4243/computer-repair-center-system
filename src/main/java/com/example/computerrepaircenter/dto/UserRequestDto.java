package com.example.computerrepaircenter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String email;
    private String password;
    private String repeatPassword;
}
