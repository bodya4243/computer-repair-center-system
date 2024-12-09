package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.UserRequestDto;
import com.example.computerrepaircenter.dto.UserResponseDto;
import com.example.computerrepaircenter.mapper.UserMapper;
import com.example.computerrepaircenter.model.Role;
import com.example.computerrepaircenter.model.User;
import com.example.computerrepaircenter.repository.RoleRepository;
import com.example.computerrepaircenter.repository.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {
        if ((userRepository.findByEmail(userRequestDto.getEmail())).isPresent()) {
            throw new RuntimeException("user: " + userRequestDto.getEmail() + "is already exists");
        }

        User user = userMapper.toModel(userRequestDto);
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRepeatPassword(passwordEncoder.encode(userRequestDto.getRepeatPassword()));
        Role defaultRole = (roleRepository.findByRole(Role.RoleName.USER));
        user.setRoles(Collections.singleton(defaultRole));
        
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
