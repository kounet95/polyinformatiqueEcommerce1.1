package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateMediaCommand;
import org.example.polyinformatiquecoreapi.dto.MediaDTO;
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
class MediaControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private MediaController mediaController;

    private String mediaId;
    private MediaDTO mediaDTO;

    @BeforeEach
    void setUp() {
        mediaId = UUID.randomUUID().toString();
        
        // Using a mock for MediaDTO since we don't know its exact structure
        mediaDTO = mock(MediaDTO.class);
    }

    @Test
    void create_ShouldSendCreateMediaCommand() {
        // Arrange
        when(commandGateway.send(any(CreateMediaCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(mediaId));

        // Act
        CompletableFuture<String> result = mediaController.create(mediaDTO);

        // Assert
        assertNotNull(result);
        assertEquals(mediaId, result.join());
        verify(commandGateway, times(1)).send(any(CreateMediaCommand.class));
    }

    @Test
    void getEvents_ShouldCallEventStoreReadEvents() {
        // Arrange
        DomainEventStream mockEventStream = mock(DomainEventStream.class);
        when(eventStore.readEvents(mediaId)).thenReturn(mockEventStream);
        when(mockEventStream.asStream()).thenReturn(Stream.empty());

        // Act
        Stream<Object> result = mediaController.getEvents(mediaId);

        // Assert
        assertNotNull(result);
        verify(eventStore, times(1)).readEvents(mediaId);
    }

    @Test
    void handle_ShouldReturnErrorResponse() {
        // Arrange
        Exception testException = new RuntimeException("Test exception");

        // Act
        ResponseEntity<String> response = mediaController.handle(testException);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(testException.getMessage(), response.getBody());
    }
}