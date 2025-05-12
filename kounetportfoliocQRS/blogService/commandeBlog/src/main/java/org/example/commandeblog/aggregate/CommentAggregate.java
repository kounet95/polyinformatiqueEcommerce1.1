package org.example.commandeblog.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.AddCommentCommand;
import org.example.polyinformatiquecoreapi.commands.EditCommentCommand;
import org.example.polyinformatiquecoreapi.commands.DeleteCommentCommand;
import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import org.example.polyinformatiquecoreapi.event.CommentAddedEvent;
import org.example.polyinformatiquecoreapi.event.CommentEditedEvent;
import org.example.polyinformatiquecoreapi.event.CommentDeletedEvent;
import org.springframework.core.annotation.AliasFor;

import java.time.LocalDate;

@Aggregate(type = "commentAggregate")
@Slf4j
public class CommentAggregate {

    @AggregateIdentifier
    private String idComment;
    private String contenu;
    private String postId;
    private LocalDate createdAt;
    private String authorId;

    public CommentAggregate() {}

    @CommandHandler(payloadType = AddCommentCommand.class)
    public CommentAggregate(AddCommentCommand command) {
        CommentDTO dto = command.getCommentDTO();
        CommentAddedEvent event = new CommentAddedEvent(command.getId(), dto);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler(payloadType = CommentAddedEvent.class)
    public void on(CommentAddedEvent event) {
        //log.info("Applying CommentAddedEvent for id: {}", event.getId());
        this.idComment = event.getId();
        this.contenu = event.getCommentDTO().getContenu();
        this.postId = event.getCommentDTO().getItemId();
        this.createdAt = event.getCommentDTO().getCreatedAt();
        this.authorId = event.getCommentDTO().getAuthorId();
    }

    @CommandHandler(payloadType = EditCommentCommand.class)
    public void handle(EditCommentCommand command) {
        if (!command.getCommentId().equals(this.idComment)) {
            throw new IllegalArgumentException("Comment ID mismatch");
        }
        AggregateLifecycle.apply(new CommentEditedEvent(command.getId(), command.getNewContent()));
    }

    @EventSourcingHandler(payloadType = CommentEditedEvent.class)
    public void on(CommentEditedEvent event) {
        //log.info("Applying CommentEditedEvent for id: {}", event.getId());
        this.contenu = event.getNewContent();
    }

    @CommandHandler(payloadType = DeleteCommentCommand.class)
    public void handle(DeleteCommentCommand command) {
        if (!command.getCommentId().equals(this.idComment)) {
            throw new IllegalArgumentException("Comment ID mismatch");
        }
        AggregateLifecycle.apply(new CommentDeletedEvent(command.getId(), command.getCommentId()));
    }

    @EventSourcingHandler(payloadType = CommentDeletedEvent.class)
    public void on(CommentDeletedEvent event) {
        //log.info("Applying CommentDeletedEvent for id: {}", event.getCommentId());
        this.contenu = "[deleted]";
        this.authorId = null;
    }
}