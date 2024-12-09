package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.UserRequestDto;
import com.example.computerrepaircenter.dto.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto);
}
