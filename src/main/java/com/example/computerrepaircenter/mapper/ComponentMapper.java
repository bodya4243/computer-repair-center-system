package com.example.computerrepaircenter.mapper;

import com.example.computerrepaircenter.config.MapperConfig;
import com.example.computerrepaircenter.dto.ComponentDto;
import com.example.computerrepaircenter.dto.ComponentResponseDto;
import com.example.computerrepaircenter.model.Component;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ComponentMapper {
    Component toModel(ComponentDto componentDto);

    ComponentResponseDto toDto(Component component);
}
