package com.example.computerrepaircenter.dto;

import com.example.computerrepaircenter.model.Component;
import com.example.computerrepaircenter.model.OrderStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class ChangedOrderRequestDto {
    private String description;
    private BigDecimal total;
    private List<Component> components;
    private OrderStatus status;
    private String shippingAddress;
}
