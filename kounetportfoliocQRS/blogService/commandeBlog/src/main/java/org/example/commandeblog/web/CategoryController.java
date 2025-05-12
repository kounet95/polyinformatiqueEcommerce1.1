package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateCategoryCommand;
import org.example.polyinformatiquecoreapi.dto.DomainDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/category/command")
@CrossOrigin
public class CategoryController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public CategoryController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody DomainDTO dto) {
        return commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(), dto));
    }

    @GetMapping("/events/{id}")
    public Stream<Object> getEvents(@PathVariable String id) {
        return eventStore.readEvents(id).asStream().map(e -> e.getPayload());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
