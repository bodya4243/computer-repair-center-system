package com.example.computerrepaircenter.mapper;

import com.example.computerrepaircenter.config.MapperConfig;
import com.example.computerrepaircenter.dto.OrderRequestDto;
import com.example.computerrepaircenter.dto.OrderResponseDto;
import com.example.computerrepaircenter.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    @Mapping(target = "userId", source = "user.id")
    OrderResponseDto toDto(Order order);

    Order toModel(OrderRequestDto orderRequestDto);
}
