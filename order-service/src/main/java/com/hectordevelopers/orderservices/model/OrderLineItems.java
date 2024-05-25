package com.hectordevelopers.orderservices.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_lines")
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;

}
