package com.example.computerrepaircenter.mapper;

import com.example.computerrepaircenter.config.MapperConfig;
import com.example.computerrepaircenter.dto.UserRequestDto;
import com.example.computerrepaircenter.dto.UserResponseDto;
import com.example.computerrepaircenter.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRequestDto userRequestDto);

    UserResponseDto toDto(User user);
}
