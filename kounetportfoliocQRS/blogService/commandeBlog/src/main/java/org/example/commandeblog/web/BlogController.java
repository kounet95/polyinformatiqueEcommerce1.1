package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreatePostCommand;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/blog/command")
@CrossOrigin
public class BlogController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;
    public BlogController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createArticle(@RequestBody ArticleDTO article) {
        ArticleDTO postDTO = new ArticleDTO(
                UUID.randomUUID().toString(),
                article.getTitle(),
                article.getContenu(),
                article.getUrlMedia(),
                article.getCreatedAt(),
                article.getAuthorId(),
                article.getCategoryId(),
                article.getTagIds()
        );

        CreatePostCommand command = new CreatePostCommand(
                UUID.randomUUID().toString(),
                postDTO
        );

        return commandGateway.send(command);
    }

    @GetMapping("/events/{roomId}")
    public Stream eventsStream(@PathVariable String roomId) {
        return eventStore.readEvents(roomId).asStream();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> entity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
