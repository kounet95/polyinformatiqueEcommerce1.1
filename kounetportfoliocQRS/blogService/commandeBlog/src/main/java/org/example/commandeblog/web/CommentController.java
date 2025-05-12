package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.AddCommentCommand;
import org.example.polyinformatiquecoreapi.commands.DeleteCommentCommand;
import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment/command")
@CrossOrigin
public class CommentController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public CommentController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody CommentDTO dto) {
        String commentId = UUID.randomUUID().toString();

        return commandGateway.send(
                new AddCommentCommand(commentId,  dto)
        );
    }

    @DeleteMapping("/delete/{commentId}")
    public CompletableFuture<String> delete(@PathVariable String commentId, @RequestParam String itemId) {
        return commandGateway.send(
                new DeleteCommentCommand(itemId, commentId)
        );
    }

    @GetMapping("/events/{id}")
    public List<Object> getEvents(@PathVariable String id) {
        return eventStore.readEvents(id)
                .asStream()
                .map(evt -> evt.getPayload())
                .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
