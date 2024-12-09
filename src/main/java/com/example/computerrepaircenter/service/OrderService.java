package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.ChangedOrderRequestDto;
import com.example.computerrepaircenter.dto.OrderRequestDto;
import com.example.computerrepaircenter.dto.OrderResponseDto;
import com.example.computerrepaircenter.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    OrderResponseDto save(OrderRequestDto orderRequestDto, User user);

    List<OrderResponseDto> getAll(User user);

    Page<OrderResponseDto> getAllForAdmin(Pageable pageable);

    OrderResponseDto getById(Long id);

    OrderResponseDto updateById(Long id, ChangedOrderRequestDto orderRequestDto, User user);

    void deleteOrderById(Long id);
}
