package org.example.polyinformatiquecoreapi.event;



import org.example.polyinformatiquecoreapi.dto.ArticleDTO;

import java.io.Serializable;
import java.time.Instant;

public class PostCreatedEvent extends BaseEvent<String> implements Serializable {
    private  ArticleDTO payload;

    public PostCreatedEvent(String id, ArticleDTO payload) {
        super(id);
        this.payload = payload;
    }

    public ArticleDTO getPayload() {
        return payload;
    }
}

class PostUpdatedEvent extends BaseEvent<String> implements Serializable {
    private final ArticleDTO payload;

    public PostUpdatedEvent(String id, ArticleDTO payload) {
        super(id);
        this.payload = payload;
    }

    public ArticleDTO getPayload() {
        return payload;
    }
}

class PostPublishedEvent extends BaseEvent<String> implements Serializable {
    private final Instant publishedAt;

    public PostPublishedEvent(String id) {
        super(id);
        this.publishedAt = Instant.now();
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }
}

class PostDeletedEvent extends BaseEvent<String> implements Serializable {
    public PostDeletedEvent(String id) {
        super(id);
    }
}
