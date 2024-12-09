package com.example.computerrepaircenter.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ComponentDto {
    private String componentName;
    private String description;
    private Integer stockQuantity;
    private BigDecimal price;
}
