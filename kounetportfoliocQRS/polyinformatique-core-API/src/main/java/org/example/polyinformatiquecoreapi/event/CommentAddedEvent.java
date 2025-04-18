package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.CommentDTO;

import java.io.Serializable;
import java.time.Instant;

public class CommentAddedEvent extends BaseEvent<String> implements Serializable {
    private final String commentId;
    private final CommentDTO payload;

    public CommentAddedEvent(String id, String commentId, CommentDTO payload) {
        super(id);
        this.commentId = commentId;
        this.payload = payload;
    }

    public String getCommentId() {
        return commentId;
    }

    public CommentDTO getPayload() {
        return payload;
    }
}

class CommentEditedEvent extends BaseEvent<String> implements Serializable {
    private final String commentId;
    private final String newContent;
    private final Instant editedAt;

    public CommentEditedEvent(String id, String commentId, String newContent) {
        super(id);
        this.commentId = commentId;
        this.newContent = newContent;
        this.editedAt = Instant.now();
    }

    public String getCommentId() {
        return commentId;
    }

    public String getNewContent() {
        return newContent;
    }

    public Instant getEditedAt() {
        return editedAt;
    }
}

class CommentDeletedEvent extends BaseEvent<String> implements Serializable {
    private final String commentId;

    public CommentDeletedEvent(String id, String commentId) {
        super(id);
        this.commentId = commentId;
    }

    public String getCommentId() {
        return commentId;
    }
}
