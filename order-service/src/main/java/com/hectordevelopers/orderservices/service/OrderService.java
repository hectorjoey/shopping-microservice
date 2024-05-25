package com.hectordevelopers.orderservices.service;

import com.hectordevelopers.orderservices.dto.OrderDto;
import com.hectordevelopers.orderservices.dto.OrderLineItemsDto;
import com.hectordevelopers.orderservices.model.Order;
import com.hectordevelopers.orderservices.model.OrderLineItems;
import com.hectordevelopers.orderservices.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString());

        order.setOrderLineItemsList(
                orderDto.getOrderLineItemsDtos()
                        .stream()
                        .map(this::mapToDto) // Fixed to use the correct method name
                        .collect(Collectors.toList())
        );

        return orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
