package com.hectordevelopers.orderservices.controller;

import com.hectordevelopers.orderservices.dto.OrderDto;
import com.hectordevelopers.orderservices.model.Order;
import com.hectordevelopers.orderservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order/")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);

    }
}
