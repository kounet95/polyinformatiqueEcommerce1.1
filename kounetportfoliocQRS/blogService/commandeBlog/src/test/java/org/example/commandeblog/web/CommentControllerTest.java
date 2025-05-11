package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.AddCommentCommand;
import org.example.polyinformatiquecoreapi.commands.DeleteCommentCommand;
import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private CommentController commentController;

    private String commentId;
    private String itemId;
    private CommentDTO commentDTO;

    @BeforeEach
    void setUp() {
        commentId = UUID.randomUUID().toString();
        itemId = UUID.randomUUID().toString();

        // We need to check the actual structure of CommentDTO
        // For now, using a mock
        commentDTO = mock(CommentDTO.class);
    }

    @Test
    void create_ShouldSendAddCommentCommand() {
        // Arrange
        when(commandGateway.send(any(AddCommentCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(commentId));

        // Act
        CompletableFuture<String> result = commentController.create(commentDTO);

        // Assert
        assertNotNull(result);
        assertEquals(commentId, result.join());
        verify(commandGateway, times(1)).send(any(AddCommentCommand.class));
    }

    @Test
    void delete_ShouldSendDeleteCommentCommand() {
        // Arrange
        when(commandGateway.send(any(DeleteCommentCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(commentId));

        // Act
        CompletableFuture<String> result = commentController.delete(commentId, itemId);

        // Assert
        assertNotNull(result);
        assertEquals(commentId, result.join());
        verify(commandGateway, times(1)).send(any(DeleteCommentCommand.class));
    }

    @Test
    void getEvents_ShouldCallEventStoreReadEvents() {
        // Arrange
        DomainEventStream mockEventStream = mock(DomainEventStream.class);
        when(eventStore.readEvents(commentId)).thenReturn(mockEventStream);

        // Mock a simple stream that can be collected
        when(mockEventStream.asStream()).thenReturn(Stream.empty());

        // Act
        commentController.getEvents(commentId);

        // Assert
        verify(eventStore, times(1)).readEvents(commentId);
    }

    @Test
    void exceptionHandler_ShouldReturnErrorResponse() {
        // Arrange
        Exception testException = new RuntimeException("Test exception");

        // Act
        ResponseEntity<String> response = commentController.exceptionHandler(testException);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(testException.getMessage(), response.getBody());
    }
}
