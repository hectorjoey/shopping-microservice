package com.hectordevelopers.orderservices.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String orderNo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
