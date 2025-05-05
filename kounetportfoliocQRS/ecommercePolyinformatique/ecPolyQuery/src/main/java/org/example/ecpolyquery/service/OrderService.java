package org.example.ecpolyquery.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.ecpolyquery.entity.Customer;
import org.example.ecpolyquery.entity.Order;
import org.example.ecpolyquery.entity.OrderLine;
import org.example.ecpolyquery.entity.Product;
import org.example.ecpolyquery.repos.CustomerRepository;
import org.example.ecpolyquery.repos.OrderLineRepository;
import org.example.ecpolyquery.repos.OrderRepository;
import org.example.ecpolyquery.repos.ProductRepository;
import org.example.polyinformatiquecoreapi.dtoEcommerce.OrderDTO;
import org.example.polyinformatiquecoreapi.eventEcommerce.OrderConfirmedEvent;
import org.example.polyinformatiquecoreapi.eventEcommerce.OrderCreatedEvent;
import org.example.polyinformatiquecoreapi.eventEcommerce.OrderDeliveredEvent;
import org.example.polyinformatiquecoreapi.eventEcommerce.ProductAddedToOrderEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        log.debug("Handling OrderCreatedEvent: {}", event.getId());
        OrderDTO orderDTO = event.getOrderDTO();

        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + orderDTO.getCustomerId()));

        Order order = Order.builder()
                .id(orderDTO.getId())
                .createdAt(LocalDateTime.parse(orderDTO.getCreatedAt(), DateTimeFormatter.ISO_DATE_TIME))
                .orderStatus(orderDTO.getOrderStatus())
                .paymentMethod(orderDTO.getPaymentMethod())
                .total(orderDTO.getTotal())
                .customer(customer)
                .lines(new ArrayList<>())
                .build();

        orderRepository.save(order);
    }

    @EventHandler
    public void on(OrderConfirmedEvent event) {
        log.debug("Handling OrderConfirmedEvent: {}", event.getId());

        Order order = orderRepository.findById(event.getId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + event.getId()));

        order.setOrderStatus("CONFIRMED");
        orderRepository.save(order);
    }

    @EventHandler
    public void on(OrderDeliveredEvent event) {
        log.debug("Handling OrderDeliveredEvent: {}", event.getId());

        Order order = orderRepository.findById(event.getId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + event.getId()));

        order.setOrderStatus("DELIVERED");
        orderRepository.save(order);
    }

    @EventHandler
    public void on(ProductAddedToOrderEvent event) {
        // Implementation would depend on the structure of ProductAddedToOrderEvent
        // This is a placeholder implementation
        log.debug("Handling ProductAddedToOrderEvent: {}", event.getId());
        
        // Actual implementation would be added once we examine the ProductAddedToOrderEvent class
    }
}