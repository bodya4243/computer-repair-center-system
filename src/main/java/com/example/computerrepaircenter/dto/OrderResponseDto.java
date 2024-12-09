package com.example.computerrepaircenter.dto;

import com.example.computerrepaircenter.model.Component;
import com.example.computerrepaircenter.model.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private String description;
    private LocalDate orderDate;
    private OrderStatus status;
    private BigDecimal total;
    private String shippingAddress;
    private List<Component> components;
}
