package org.example.ecpolycommand.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commandEcommerce.CreateProductCommand;
import org.example.polyinformatiquecoreapi.dtoEcommerce.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/product/command")
@CrossOrigin
public class Product {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public Product(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }


     @PostMapping("/create")
     public CompletableFuture<String> createProduct(@RequestBody ProductDTO product) {
         String productId = UUID.randomUUID().toString();
         ProductDTO productDTO = new ProductDTO(
                 productId,
                 product.getName(),
                 product.getDescription(),
                 product.getPrice(),
                 product.getCreatedAt(),
                 product.getClosedAt(),
                 product.getSubcategoryId(),
                 product.getSocialGroupId(),
                 product.getImageUrl(),
                 product.isActive()
         );
         CreateProductCommand command = new CreateProductCommand(productId, productDTO);
         return commandGateway.send(command);
     }

    @GetMapping("/events/{aggregateId}")
    public Stream<?> eventsStream(@PathVariable String aggregateId) {
        return eventStore.readEvents(aggregateId).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(" Error: " + exception.getMessage());
    }
}
