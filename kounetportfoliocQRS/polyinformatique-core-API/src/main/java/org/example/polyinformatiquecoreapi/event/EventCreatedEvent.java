package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.EventDTO;

import java.io.Serializable;

public class EventCreatedEvent extends BaseEvent<String> implements Serializable {
    private final EventDTO payload;

    public EventCreatedEvent(String id, EventDTO payload) {
        super(id);
        this.payload = payload;
    }

    public EventDTO getPayload() {
        return payload;
    }
}

class EventUpdatedEvent extends BaseEvent<String> implements Serializable {
    private final EventDTO payload;

    public EventUpdatedEvent(String id, EventDTO payload) {
        super(id);
        this.payload = payload;
    }

    public EventDTO getPayload() {
        return payload;
    }
}

class EventDeletedEvent extends BaseEvent<String> implements Serializable {
    public EventDeletedEvent(String id) {
        super(id);
    }
}
