package com.hectordevelopers.orderservices.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private List<OrderLineItemsDto> orderLineItemsDtos;
}
