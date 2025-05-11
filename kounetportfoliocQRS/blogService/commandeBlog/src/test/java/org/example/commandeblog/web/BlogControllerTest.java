package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.*;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.polyinformatiquecoreapi.dto.EventDTO;
import org.example.polyinformatiquecoreapi.dto.NewsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private BlogController blogController;

    private String itemId;
    private ArticleDTO articleDTO;
    private NewsDTO newsDTO;
    private EventDTO eventDTO;

    @BeforeEach
    void setUp() {
        itemId = UUID.randomUUID().toString();

        // Setup ArticleDTO
        articleDTO = new ArticleDTO(
                null, // ID will be generated in the controller
                "Test content",
                "http://example.com/media.jpg",
                "Test Title",
                LocalDate.now(),
                "author-123",
                "domain-123",
                List.of("tag-1", "tag-2"),
                List.of("comment-1", "comment-2")
        );

        // Setup NewsDTO
        newsDTO = new NewsDTO(
                null, // ID will be generated in the controller
                "Test summary",
                "Test content",
                "http://example.com/media.jpg",
                "Test News Title",
                LocalDate.now(),
                "author-123",
                "domain-123",
                List.of("tag-1", "tag-2"),
                List.of("comment-1", "comment-2")
        );

        // Setup EventDTO
        eventDTO = new EventDTO(
                null, // ID will be generated in the controller
                "Test location",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                "Test content",
                "http://example.com/media.jpg",
                "Test Title",
                LocalDate.now(),
                "author-123",
                "domain-123",
                List.of("tag-1", "tag-2"),
                List.of("comment-1", "comment-2")
        );
    }

    @Test
    void createArticle_ShouldSendCreatePostCommand() {
        // Arrange
        when(commandGateway.send(any(CreatePostCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.createArticle(articleDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(CreatePostCommand.class));
    }

    @Test
    void createNews_ShouldSendCreateNewsCommand() {
        // Arrange
        when(commandGateway.send(any(CreateNewsCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.createNews(newsDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(CreateNewsCommand.class));
    }

    @Test
    void createEvent_ShouldSendCreateEventCommand() {
        // Arrange
        when(commandGateway.send(any(CreateEventCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.createEvent(eventDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(CreateEventCommand.class));
    }

    @Test
    void eventsStream_ShouldCallEventStoreReadEvents() {
        // Arrange
        DomainEventStream mockEventStream = mock(DomainEventStream.class);
        when(eventStore.readEvents(itemId)).thenReturn(mockEventStream);

        // Act
        blogController.eventsStream(itemId);

        // Assert
        verify(eventStore, times(1)).readEvents(itemId);
    }

    @Test
    void exceptionHandler_ShouldReturnErrorResponse() {
        // Arrange
        Exception testException = new RuntimeException("Test exception");

        // Act
        ResponseEntity<String> response = blogController.exceptionHandler(testException);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("Test exception"));
    }

    @Test
    void updateArticle_ShouldSendUpdatePostCommand() {
        // Arrange
        when(commandGateway.send(any(UpdatePostCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.updateArticle(itemId, articleDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(UpdatePostCommand.class));
    }

    @Test
    void updateNews_ShouldSendUpdateNewsCommand() {
        // Arrange
        when(commandGateway.send(any(UpdateNewsCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.updateNews(itemId, newsDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(UpdateNewsCommand.class));
    }

    @Test
    void updateEvent_ShouldSendUpdateEventCommand() {
        // Arrange
        when(commandGateway.send(any(UpdateEventCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.updateEvent(itemId, eventDTO);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(UpdateEventCommand.class));
    }

    @Test
    void deleteArticle_ShouldSendDeleteItemCommand() {
        // Arrange
        when(commandGateway.send(any(DeleteItemCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.deleteArticle(itemId);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(DeleteItemCommand.class));
    }

    @Test
    void deleteNews_ShouldSendDeleteItemCommand() {
        // Arrange
        when(commandGateway.send(any(DeleteItemCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.deleteNews(itemId);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(DeleteItemCommand.class));
    }

    @Test
    void deleteEvent_ShouldSendDeleteItemCommand() {
        // Arrange
        when(commandGateway.send(any(DeleteItemCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(itemId));

        // Act
        CompletableFuture<String> result = blogController.deleteEvent(itemId);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.join());
        verify(commandGateway, times(1)).send(any(DeleteItemCommand.class));
    }
}
