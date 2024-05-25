package com.hectordevelopers.productservices.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
}
