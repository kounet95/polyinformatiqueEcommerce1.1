package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.EventDTO;

public class CreateEventCommand extends BaseCommand<String> {
    private final EventDTO payload;

    public CreateEventCommand(String id, EventDTO payload) {
        super(id);
        this.payload = payload;
    }

    public EventDTO getPayload() {
        return payload;
    }
}

