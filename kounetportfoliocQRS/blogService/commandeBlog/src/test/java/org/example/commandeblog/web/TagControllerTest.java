package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateTagCommand;
import org.example.polyinformatiquecoreapi.dto.TagDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private TagController tagController;

    private String tagId;
    private TagDTO tagDTO;

    @BeforeEach
    void setUp() {
        tagId = UUID.randomUUID().toString();
        
        // Using a mock for TagDTO since we don't know its exact structure
        tagDTO = mock(TagDTO.class);
    }

    @Test
    void create_ShouldSendCreateTagCommand() {
        // Arrange
        when(commandGateway.send(any(CreateTagCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(tagId));

        // Act
        CompletableFuture<String> result = tagController.create(tagDTO);

        // Assert
        assertNotNull(result);
        assertEquals(tagId, result.join());
        verify(commandGateway, times(1)).send(any(CreateTagCommand.class));
    }

    @Test
    void getEvents_ShouldCallEventStoreReadEvents() {
        // Arrange
        DomainEventStream mockEventStream = mock(DomainEventStream.class);
        when(eventStore.readEvents(tagId)).thenReturn(mockEventStream);
        when(mockEventStream.asStream()).thenReturn(Stream.empty());

        // Act
        Stream<Object> result = tagController.getEvents(tagId);

        // Assert
        assertNotNull(result);
        verify(eventStore, times(1)).readEvents(tagId);
    }

    @Test
    void handle_ShouldReturnErrorResponse() {
        // Arrange
        Exception testException = new RuntimeException("Test exception");

        // Act
        ResponseEntity<String> response = tagController.handle(testException);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(testException.getMessage(), response.getBody());
    }
}