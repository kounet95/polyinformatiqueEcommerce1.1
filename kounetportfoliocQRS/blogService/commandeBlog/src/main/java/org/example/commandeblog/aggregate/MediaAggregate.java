package org.example.commandeblog.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateMediaCommand;
import org.example.polyinformatiquecoreapi.dto.MediaDTO;
import org.example.polyinformatiquecoreapi.event.MediaCreatedEvent;
import org.springframework.core.annotation.AliasFor;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@Aggregate(type = "mediaAggregate")
public class MediaAggregate {

    @AggregateIdentifier
    private String id;
    // We don't need to store these fields in the aggregate
    // since they are already in the event payload

    public MediaAggregate() {
        // Required by Axon
    }

    @CommandHandler(payloadType = CreateMediaCommand.class)
    public MediaAggregate(CreateMediaCommand command) {
        log.info("Handling CreateMediaCommand: {}", command.getId());
        // Just pass the command payload to the event
        apply(new MediaCreatedEvent(command.getId(), command.getPayload()));
    }

    @EventSourcingHandler(payloadType = MediaCreatedEvent.class)
    public void on(MediaCreatedEvent event) {
        log.info("Applying MediaCreatedEvent: {}", event.getId());
        this.id = event.getId();
        // We don't need to extract fields from the payload
        // since they are already in the event
    }
}