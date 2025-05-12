package org.example.commandeblog.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreateCategoryCommand;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.polyinformatiquecoreapi.event.DomainCreateEvent;
import org.springframework.core.annotation.AliasFor;

import java.util.List;

@Aggregate(type = "domainAggregate")
@Slf4j
public class DomainAggregate {
    @AggregateIdentifier
    private String id;

    private String name;
    private List<String> articles;

    public DomainAggregate() {}

    @CommandHandler(payloadType = CreateCategoryCommand.class)
    public DomainAggregate(CreateCategoryCommand command) {
        //log.info("Handling AddCategoryCommand for id: {}", command.getId());
        DomainCreateEvent event = new DomainCreateEvent(command.getId(), command.getPayload());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler(payloadType = DomainCreateEvent.class)
    public void on(DomainCreateEvent event) {
        this.id = event.getId();
        this.name = event.getDomainDTO().getName();
        this.articles = event.getDomainDTO().getArticles();
    }
}