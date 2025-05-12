package org.example.ecpolyquery.web;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.ecpolyquery.entity.Supplier;
import org.example.ecpolyquery.query.GetAllSuppliersQuery;
import org.example.ecpolyquery.query.GetSupplierByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SupplierController {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<Supplier>> getAllSuppliers() {
        return queryGateway.query(new GetAllSuppliersQuery(), 
                ResponseTypes.multipleInstancesOf(Supplier.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Supplier> getSupplierById(@PathVariable String id) {
        return queryGateway.query(new GetSupplierByIdQuery(id), 
                ResponseTypes.instanceOf(Supplier.class));
    }
}