package org.example.commandeblog.aggreate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commands.CreatePostCommand;
import org.example.polyinformatiquecoreapi.dto.TagDTO;
import org.example.polyinformatiquecoreapi.event.PostCreatedEvent;

import java.util.List;
import java.util.stream.Collectors;

@Aggregate
@Slf4j
public class ArticleAggregate {
    @AggregateIdentifier
    private String idArticle;
    private String titleArticle;
    private String contentArticle;
    private String authorId;
    private String dateArticle;
    private String urlArticle;
    private String commentId;
    private List<TagDTO> tagsId;

    public ArticleAggregate() {}

    @CommandHandler
    public ArticleAggregate(CreatePostCommand command) {
        log.info("Handling CreatePostCommand for id: {}", command.getId());

        if (command.getPayload() == null) {
            throw new RuntimeException("Un article ne peut pas être vide");
        }

        PostCreatedEvent event = new PostCreatedEvent(
                command.getId(), // id de l'article
                command.getPayload() // ArticleDTO
        );

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
public void on(PostCreatedEvent event) {
    log.info("Applying RoomCreatedEvent for roomId: {}", event.getId());
    this.idArticle = event.getPayload().getId();
    this.titleArticle = event.getPayload().getTitle();
    this.contentArticle = event.getPayload().getContenu();
    this.authorId = event.getPayload().getAuthorId();
    this.dateArticle = event.getPayload().getCreatedAt().toString(); // Instant → String
    this.urlArticle = event.getPayload().getUrlMedia();
    this.commentId = null; // a null comme il ya aucun commentaire pour l’instant
    this.tagsId = event.getPayload().getTagIds()
            .stream()
            .map(tagId -> new TagDTO(tagId, "",
                    null, List.of(this.idArticle)))
            .collect(Collectors.toList());
}


}
