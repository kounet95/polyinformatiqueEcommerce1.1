package org.example.ecpolyquery.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.ecpolyquery.entity.Order;
import org.example.ecpolyquery.query.GetAllOrdersQuery;
import org.example.ecpolyquery.query.GetOrderByIdQuery;
import org.example.ecpolyquery.repos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class OrderQueryHandler {

    private final OrderRepository orderRepository;

    @QueryHandler
    public List<Order> on(GetAllOrdersQuery query) {
        log.debug("Handling GetAllOrdersQuery");
        return orderRepository.findAll();
    }

    @QueryHandler
    public Order on(GetOrderByIdQuery query) {
        log.debug("Handling GetOrderByIdQuery: {}", query.getId());
        Optional<Order> optionalOrder = orderRepository.findById(query.getId());
        return optionalOrder
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + query.getId()));
    }
}