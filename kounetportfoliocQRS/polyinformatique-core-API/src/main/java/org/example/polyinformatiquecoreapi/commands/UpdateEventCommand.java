package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.EventDTO;

public class UpdateEventCommand extends BaseCommand<String> {
    private final EventDTO payload;

    public UpdateEventCommand(String id, EventDTO payload) {
        super(id);
        this.payload = payload;
    }

    public EventDTO getPayload() {
        return payload;
    }
}
