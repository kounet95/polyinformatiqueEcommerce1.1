package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import org.example.polyinformatiquecoreapi.commands.CreateCategoryCommand;
import org.example.polyinformatiquecoreapi.dto.CategoryDTO;
import org.example.polyinformatiquecoreapi.event.CategoryCreatedEvent;

@Aggregate
@Slf4j
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;

    private String title;
    private String description;

    public CategoryAggregate() {}

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        log.info("Handling AddCategoryCommand for id: {}", command.getId());
        CategoryCreatedEvent event = new CategoryCreatedEvent(command.getId(), command.getPayload());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event) {
        this.id = event.getId();
        this.title = event.getPayload().getTitle();
        this.description = event.getPayload().getDescription();
    }
}
