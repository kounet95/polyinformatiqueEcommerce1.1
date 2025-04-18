package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateNewsCommand;
import org.example.polyinformatiquecoreapi.event.NewsCreatedEvent;

import java.time.LocalDate;

@Aggregate
@Slf4j
public class NewsAggregate {
    @AggregateIdentifier
    private String id;

    private String title;
    private String summary;
    private String contenu;
    private String urlMedia;
    private LocalDate createdAt;
    private String authorId;

    public NewsAggregate() {}

    @CommandHandler
    public NewsAggregate(CreateNewsCommand command) {
        log.info("Handling AddNewsCommand for id: {}", command.getId());
        NewsCreatedEvent event = new NewsCreatedEvent(command.getId(), command.getPayload());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(NewsCreatedEvent event) {
        this.id = event.getId();
        this.title = event.getPayload().getTitle();
        this.summary = event.getPayload().getSummary();
        this.contenu = event.getPayload().getContenu();
        this.urlMedia = event.getPayload().getUrlMedia();
        this.createdAt = event.getPayload().getCreatedAt();
        this.authorId = event.getPayload().getAuthorId();
    }
}

