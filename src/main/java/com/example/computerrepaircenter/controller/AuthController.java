package com.example.computerrepaircenter.controller;

import com.example.computerrepaircenter.dto.UserLoginRequestDto;
import com.example.computerrepaircenter.dto.UserLoginResponseDto;
import com.example.computerrepaircenter.dto.UserRequestDto;
import com.example.computerrepaircenter.dto.UserResponseDto;
import com.example.computerrepaircenter.security.AuthenticationService;
import com.example.computerrepaircenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@RestController
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping("/registration")
    UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userService.register(userRequestDto);
    }
}
