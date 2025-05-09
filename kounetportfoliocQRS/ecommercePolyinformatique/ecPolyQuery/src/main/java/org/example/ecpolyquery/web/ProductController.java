package org.example.ecpolyquery.web;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.ecpolyquery.entity.Product;
import org.example.ecpolyquery.query.GetAllProductsQuery;
import org.example.ecpolyquery.query.GetProductByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<Product>> getAllProducts() {
        return queryGateway.query(new GetAllProductsQuery(), 
                ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> getProductById(@PathVariable String id) {
        return queryGateway.query(new GetProductByIdQuery(id), 
                ResponseTypes.instanceOf(Product.class));
    }
}