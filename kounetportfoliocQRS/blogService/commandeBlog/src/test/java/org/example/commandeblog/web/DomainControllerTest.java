package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.example.polyinformatiquecoreapi.commands.CreateCategoryCommand;
import org.example.polyinformatiquecoreapi.dto.DomainDTO;
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
class DomainControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private DomainController domainController;

    private String domainId;
    private DomainDTO domainDTO;

    @BeforeEach
    void setUp() {
        domainId = UUID.randomUUID().toString();
        
        // Using a mock for DomainDTO since we don't know its exact structure
        domainDTO = mock(DomainDTO.class);
    }

    @Test
    void create_ShouldSendCreateCategoryCommand() {
        // Arrange
        when(commandGateway.send(any(CreateCategoryCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(domainId));

        // Act
        CompletableFuture<String> result = domainController.create(domainDTO);

        // Assert
        assertNotNull(result);
        assertEquals(domainId, result.join());
        verify(commandGateway, times(1)).send(any(CreateCategoryCommand.class));
    }

    @Test
    void getEvents_ShouldCallEventStoreReadEvents() {
        // Arrange
        DomainEventStream mockEventStream = mock(DomainEventStream.class);
        when(eventStore.readEvents(domainId)).thenReturn(mockEventStream);
        when(mockEventStream.asStream()).thenReturn(Stream.empty());

        // Act
        Stream<Object> result = domainController.getEvents(domainId);

        // Assert
        assertNotNull(result);
        verify(eventStore, times(1)).readEvents(domainId);
    }

    @Test
    void handle_ShouldReturnErrorResponse() {
        // Arrange
        Exception testException = new RuntimeException("Test exception");

        // Act
        ResponseEntity<String> response = domainController.handle(testException);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(testException.getMessage(), response.getBody());
    }
}