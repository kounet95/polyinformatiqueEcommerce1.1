package org.example.ecpolyquery.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.ecpolyquery.entity.Product;
import org.example.ecpolyquery.query.GetAllProductsQuery;
import org.example.ecpolyquery.query.GetProductByIdQuery;
import org.example.ecpolyquery.repos.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<Product> on(GetAllProductsQuery query) {
        log.debug("Handling GetAllProductsQuery");
        return productRepository.findAll();
    }

    @QueryHandler
    public Product on(GetProductByIdQuery query) {
        log.debug("Handling GetProductByIdQuery: {}", query.getId());
        Optional<Product> optionalProduct = productRepository.findById(query.getId());
        return optionalProduct
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + query.getId()));
    }
}