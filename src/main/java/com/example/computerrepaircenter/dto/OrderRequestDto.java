package com.example.computerrepaircenter.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
    private String description;

    private String shippingAddress;
}
