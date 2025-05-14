package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateCustomerCommand;
import org.example.polyinformatiquecoreapi.commands.DeleteAuthorCommand;
import org.example.polyinformatiquecoreapi.dto.CustomerBlogDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/blog/author")
@CrossOrigin
public class CustomerController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public CustomerController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }


    @PostMapping("/create")
    public CompletableFuture<String> createAuthor(@RequestBody CustomerBlogDTO author) {

        String authorId = UUID.randomUUID().toString();
        CustomerBlogDTO authorDTO = new CustomerBlogDTO(
                authorId,
                author.getUsername(),
                author.getLastname(),
                author.getEmail(),
                author.getName(),
                author.getPhone(),
                author.getAddress(),
                author.getIteamIds(),
                author.getCommentIds()
        );
        CreateCustomerCommand command = new CreateCustomerCommand(authorId, authorDTO);
        return commandGateway.send(command);
    }

    @GetMapping("/events/{aggregateId}")
    public Stream<?> eventsStream(@PathVariable String aggregateId) {
        return eventStore.readEvents(aggregateId).asStream();
    }

    @DeleteMapping("/delete/{authorId}")
    public CompletableFuture<String> deleteAuthor(@PathVariable String authorId) {
        return commandGateway.send(new DeleteAuthorCommand(authorId));
    }
}
