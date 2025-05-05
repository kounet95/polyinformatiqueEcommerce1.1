package org.example.ecpolyquery.web;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.ecpolyquery.entity.Order;
import org.example.ecpolyquery.query.GetAllOrdersQuery;
import org.example.ecpolyquery.query.GetOrderByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<Order>> getAllOrders() {
        return queryGateway.query(new GetAllOrdersQuery(), 
                ResponseTypes.multipleInstancesOf(Order.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Order> getOrderById(@PathVariable String id) {
        return queryGateway.query(new GetOrderByIdQuery(id), 
                ResponseTypes.instanceOf(Order.class));
    }
}