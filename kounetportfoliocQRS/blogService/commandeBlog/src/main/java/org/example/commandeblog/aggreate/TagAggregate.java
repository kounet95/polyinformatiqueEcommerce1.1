package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateTagCommand;
import org.example.polyinformatiquecoreapi.event.TagCreatedEvent;

import java.util.List;

@Aggregate
@Slf4j
public class TagAggregate {
    @AggregateIdentifier
    private String id;

    private String title;
    private String eventId;
    private List<String> articleIds;

    public TagAggregate() {}

    @CommandHandler
    public TagAggregate(CreateTagCommand command) {
        log.info("Handling AddTagCommand for id: {}", command.getId());
        TagCreatedEvent event = new TagCreatedEvent(command.getId(), command.getPayload());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(TagCreatedEvent event) {
        this.id = event.getId();
        this.title = event.getPayload().getTitle();
        this.eventId = event.getPayload().getEventId();
        this.articleIds = event.getPayload().getArticleIds();
    }
}