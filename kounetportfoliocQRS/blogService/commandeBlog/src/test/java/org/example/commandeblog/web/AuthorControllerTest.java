package org.example.commandeblog.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.example.polyinformatiquecoreapi.commands.CreateAuthorCommand;
import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    private CommandGateway commandGateway;

    @Mock
    private EventStore eventStore;

    @InjectMocks
    private AuthorController authorController;

    private AuthorDTO authorDTO;
    private String authorId;

    @BeforeEach
    void setUp() {
        authorId = UUID.randomUUID().toString();
        authorDTO = new AuthorDTO(
                null, // ID will be generated in the controller
                "testUsername",
                "test@example.com",
                "Test Author",
                "123456789",
                "Test Address",
                List.of(),
                List.of()
        );
    }

    @Test
    void createAuthor_ShouldSendCreateAuthorCommand() {
        // Arrange
        when(commandGateway.send(any(CreateAuthorCommand.class)))
                .thenReturn(CompletableFuture.completedFuture(authorId));

        // Act
        CompletableFuture<String> result = authorController.createAuthor(authorDTO);

        // Assert
        assertNotNull(result);
        assertEquals(authorId, result.join());
        verify(commandGateway, times(1)).send(any(CreateAuthorCommand.class));
    }

    @Test
    void eventsStream_ShouldCallEventStoreReadEvents() {
        // Arrange
        org.axonframework.eventsourcing.eventstore.DomainEventStream mockEventStream = 
            mock(org.axonframework.eventsourcing.eventstore.DomainEventStream.class);
        when(eventStore.readEvents(authorId)).thenReturn(mockEventStream);

        // Act
        authorController.eventsStream(authorId);

        // Assert
        verify(eventStore, times(1)).readEvents(authorId);
    }
}
