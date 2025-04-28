package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateAuthorCommand;
import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/blog/author")
@CrossOrigin
public class AuthorController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public AuthorController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }


    @PostMapping("/create")
    public CompletableFuture<String> createAuthor(@RequestBody AuthorDTO author) {

        String authorId = UUID.randomUUID().toString();
        AuthorDTO authorDTO = new AuthorDTO(
                authorId,
                author.getUsername(),
                author.getEmail(),
                author.getName(),
                author.getPhone(),
                author.getAddress(),
                author.getCommentIds(),
                author.getItemIds()
        );
      CreateAuthorCommand command = new CreateAuthorCommand(authorId, authorDTO);
        return commandGateway.send(command);
    }

    @GetMapping("/events/{aggregateId}")
    public Stream<?> eventsStream(@PathVariable String aggregateId) {
        return eventStore.readEvents(aggregateId).asStream();
    }
}
