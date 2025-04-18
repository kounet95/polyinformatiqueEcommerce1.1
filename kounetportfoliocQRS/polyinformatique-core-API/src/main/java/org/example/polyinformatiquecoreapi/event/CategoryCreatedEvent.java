package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.CategoryDTO;

import java.io.Serializable;

public class CategoryCreatedEvent extends BaseEvent<String> implements Serializable {
    private final CategoryDTO payload;

    public CategoryCreatedEvent(String id, CategoryDTO payload) {
        super(id);
        this.payload = payload;
    }

    public CategoryDTO getPayload() {
        return payload;
    }
}

class CategoryDeletedEvent extends BaseEvent<String> implements Serializable {
    public CategoryDeletedEvent(String id) {
        super(id);
    }
}
