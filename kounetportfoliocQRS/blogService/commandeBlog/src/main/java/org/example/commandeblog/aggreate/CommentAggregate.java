package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.AddCommentCommand;
import org.example.polyinformatiquecoreapi.event.CommentAddedEvent;

import java.time.LocalDate;

@Aggregate
@Slf4j
public class CommentAggregate {
    @AggregateIdentifier
    private String idComment;
    private String contenu;
    private String urlMedia;
    private String postId;
    private LocalDate createdAt;
    private String authorId;

    public CommentAggregate() {}
@CommandHandler
    public CommentAggregate(AddCommentCommand addCommentCommand) {
        log.info("Handling ajouter un Commentaire for id: {}", addCommentCommand.getId());
    CommentAddedEvent event = new CommentAddedEvent(
            addCommentCommand.getCommentId(),
            addCommentCommand.getPayload().getPostId(),
            addCommentCommand.getPayload()
    );

    AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on (CommentAddedEvent event) {
        log.info("Applying CommentCreatedEvent for roomId: {}", event.getId());
        this.idComment = event.getId();
        this.contenu = event.getPayload().getContenu();
        this.urlMedia = event.getPayload().getUrlMedia();
        this.postId = event.getPayload().getPostId();
        this.createdAt = event.getPayload().getCreatedAt();
        this.authorId = event.getPayload().getAuthorId();

    }
}
