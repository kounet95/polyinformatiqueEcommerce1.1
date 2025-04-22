package org.example.polyinformatiquecoreapi.event;

import java.io.Serializable;
import java.time.Instant;

public class CommentEditedEvent extends BaseEvent<String> implements Serializable {

    private final String newContent;
    private final Instant editedAt;

    public CommentEditedEvent(String id, String newContent) {
        super(id);

        this.newContent = newContent;
        this.editedAt = Instant.now();
    }


    public String getNewContent() {
        return newContent;
    }

    public Instant getEditedAt() {
        return editedAt;
    }
}
