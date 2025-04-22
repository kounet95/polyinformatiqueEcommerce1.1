package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.*;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.polyinformatiquecoreapi.dto.EventDTO;
import org.example.polyinformatiquecoreapi.dto.NewsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        String articleId = UUID.randomUUID().toString();
        ArticleDTO articleDTO = new ArticleDTO(
                articleId,
                article.getContent(),
                article.getUrlMedia(),
                article.getTitle(),
                article.getCreatedAt(),
                article.getAuthorId(),
                article.getDomainId(),
                article.getCommentIds(),
                article.getTagIds()
        );
        CreatePostCommand command = new CreatePostCommand(articleId, articleDTO);
        return commandGateway.send(command);
    }

    @PostMapping("/create-news")
    public CompletableFuture<String> createNews(@RequestBody NewsDTO news) {
        String newsId = UUID.randomUUID().toString();
        NewsDTO newsDTO = new NewsDTO(
                newsId,
                news.getSummary(),
                news.getContent(),
                news.getUrlMedia(),
                news.getTitle(),
                news.getCreatedAt(),
                news.getAuthorId(),
                news.getDomainId(),
                news.getCommentIds(),
                news.getTagIds()
        );
        CreateNewsCommand command = new CreateNewsCommand(newsId, newsDTO);
        return commandGateway.send(command);
    }

    @PostMapping("/create-event")
    public CompletableFuture<String> createEvent(@RequestBody EventDTO event) {
        String eventId = UUID.randomUUID().toString();
        EventDTO eventDTO = new EventDTO(
                eventId,
                event.getLocation(),
                event.getBegin(),
                event.getEnd(),
                event.getContent(),
                event.getUrlMedia(),
                event.getTitle(),
                event.getCreatedAt(),
                event.getAuthorId(),
                event.getDomainId(),
                event.getCommentIds(),
                event.getTagIds()
        );
        CreateEventCommand command = new CreateEventCommand(eventId, eventDTO);
        return commandGateway.send(command);
    }

    @GetMapping("/events/{aggregateId}")
    public Stream<?> eventsStream(@PathVariable String aggregateId) {
        return eventStore.readEvents(aggregateId).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("⚠️ Error: " + exception.getMessage());
    }

    @PutMapping("/update-article/{id}")
    public CompletableFuture<String> updateArticle(@PathVariable String id, @RequestBody ArticleDTO article) {
        ArticleDTO updatedArticle = new ArticleDTO(
                id,
                article.getContent(),
                article.getUrlMedia(),
                article.getTitle(),
                article.getCreatedAt(),
                article.getAuthorId(),
                article.getDomainId(),
                article.getTagIds(),
                article.getCommentIds()





        );
        UpdatePostCommand command = new UpdatePostCommand(id, updatedArticle);
        return commandGateway.send(command);
    }

    @PutMapping("/update-news/{id}")
    public CompletableFuture<String> updateNews(@PathVariable String id, @RequestBody NewsDTO news) {
        NewsDTO updatedNews = new NewsDTO(
                id,
                news.getSummary(),
                news.getContent(),
                news.getUrlMedia(),
                news.getTitle(),
                news.getCreatedAt(),
                news.getAuthorId(),
                news.getDomainId(),
                news.getCommentIds(),
                news.getTagIds()
        );
        UpdateNewsCommand command = new UpdateNewsCommand(id, updatedNews);
        return commandGateway.send(command);
    }

    @PutMapping("/update-event/{id}")
    public CompletableFuture<String> updateEvent(@PathVariable String id, @RequestBody EventDTO event) {
        EventDTO updatedEvent = new EventDTO(
                id,
                event.getLocation(),
                event.getBegin(),
                event.getEnd(),
                event.getContent(),
                event.getUrlMedia(),
                event.getTitle(),
                event.getCreatedAt(),
                event.getAuthorId(),
                event.getDomainId(),
                event.getCommentIds(),
                event.getTagIds()
        );
        UpdateEventCommand command = new UpdateEventCommand(id, updatedEvent);
        return commandGateway.send(command);
    }

    @DeleteMapping("/delete-article/{id}")
    public CompletableFuture<String> deleteArticle(@PathVariable String id) {
        DeleteItemCommand command = new DeleteItemCommand(id);
        return commandGateway.send(command);
    }

    @DeleteMapping("/delete-news/{id}")
    public CompletableFuture<String> deleteNews(@PathVariable String id) {
        DeleteItemCommand command = new DeleteItemCommand(id);

        return commandGateway.send(command);
    }

    @DeleteMapping("/delete-event/{id}")
    public CompletableFuture<String> deleteEvent(@PathVariable String id) {
        DeleteItemCommand command = new DeleteItemCommand(id);
        return commandGateway.send(command);
    }

}
