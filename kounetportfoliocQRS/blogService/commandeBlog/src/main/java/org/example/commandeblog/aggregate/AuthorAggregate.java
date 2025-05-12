package org.example.commandeblog.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateAuthorCommand;
import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.example.polyinformatiquecoreapi.event.AuthorCreatedEvent;
import org.springframework.core.annotation.AliasFor;

import java.util.List;

@Aggregate(type = "authorAggregate")
@Slf4j
public class AuthorAggregate {
    @AggregateIdentifier
    private String authorId;
    private String username;
    private String email;
    private String name;
    private String phone;
    private String address;

    private List<String> commentIds;
    private List<String> itemIds;

    public AuthorAggregate() {}

    @CommandHandler(payloadType = CreateAuthorCommand.class)
    public AuthorAggregate(CreateAuthorCommand command) {
        AuthorDTO authorDTO = command.getAuthor();
        AuthorCreatedEvent authorCreatedEvent = new AuthorCreatedEvent(authorDTO.getId(),authorDTO);
        AggregateLifecycle.apply(authorCreatedEvent);
    }

    @EventSourcingHandler(payloadType = AuthorCreatedEvent.class)
    public void on(AuthorCreatedEvent event) {
        this.authorId = event.getId();
        this.username = event.getAuthor().getUsername();
        this.email = event.getAuthor().getEmail();
        this.name = event.getAuthor().getName();
        this.phone = event.getAuthor().getPhone();
        this.address = event.getAuthor().getAddress();
    }
}
