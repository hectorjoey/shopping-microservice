package com.hectordevelopers.orderservices.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineItemsDto {
    private long id;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;
}
