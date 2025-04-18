package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateEventCommand;
import org.example.polyinformatiquecoreapi.event.EventCreatedEvent;

import java.time.LocalDate;

@Aggregate
@Slf4j
public class EventAggregate {
    @AggregateIdentifier
    private String id;

    private String title;
    private String location;
    private String contenu;
    private String urlMedia;
    private LocalDate createdAt;
    private String authorId;

    public EventAggregate() {}

    @CommandHandler
    public EventAggregate(CreateEventCommand command) {
        log.info("Handling AddEventCommand for id: {}", command.getId());
        EventCreatedEvent event = new EventCreatedEvent(command.getId(), command.getPayload());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EventCreatedEvent event) {
        this.id = event.getId();
        this.title = event.getPayload().getTitle();
        this.location = event.getPayload().getLocation();
        this.contenu = event.getPayload().getContenu();
        this.urlMedia = event.getPayload().getUrlMedia();
        this.createdAt = event.getPayload().getCreatedAt();
        this.authorId = event.getPayload().getAuthorId();
    }
}

