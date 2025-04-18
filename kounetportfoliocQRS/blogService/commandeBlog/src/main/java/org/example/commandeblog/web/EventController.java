package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateEventCommand;
import org.example.polyinformatiquecoreapi.dto.EventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/event/command")
@CrossOrigin
public class EventController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public EventController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody EventDTO dto) {
        return commandGateway.send(new CreateEventCommand(UUID.randomUUID().toString(), dto));
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
