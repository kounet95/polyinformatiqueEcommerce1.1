package org.example.ecpolyquery.web;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.ecpolyquery.entity.Product;
import org.example.ecpolyquery.query.GetAllProductsQuery;
import org.example.ecpolyquery.query.GetPagedProductsQuery;
import org.example.ecpolyquery.query.GetProductByIdQuery;
import org.springframework.data.domain.Page;
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

    @GetMapping("/paged")
    public CompletableFuture<Page<Product>> getPagedProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return queryGateway.query(new GetPagedProductsQuery(page, size),
                ResponseTypes.instanceOf(Page.class))
                .thenApply(result -> (Page<Product>) result);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> getProductById(@PathVariable String id) {
        return queryGateway.query(new GetProductByIdQuery(id), 
                ResponseTypes.instanceOf(Product.class));
    }
}
