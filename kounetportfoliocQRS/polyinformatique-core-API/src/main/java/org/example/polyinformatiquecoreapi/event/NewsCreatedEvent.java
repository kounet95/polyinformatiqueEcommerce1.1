package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.NewsDTO;

import java.io.Serializable;

public class NewsCreatedEvent extends BaseEvent<String> implements Serializable {
    private final NewsDTO payload;

    public NewsCreatedEvent(String id, NewsDTO payload) {
        super(id);
        this.payload = payload;
    }

    public NewsDTO getPayload() {
        return payload;
    }
}

class NewsUpdatedEvent extends BaseEvent<String> implements Serializable {
    private final NewsDTO payload;

    public NewsUpdatedEvent(String id, NewsDTO payload) {
        super(id);
        this.payload = payload;
    }

    public NewsDTO getPayload() {
        return payload;
    }
}

class NewsDeletedEvent extends BaseEvent<String> implements Serializable {
    public NewsDeletedEvent(String id) {
        super(id);
    }
}
