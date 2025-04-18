package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.NewsDTO;

public class CreateNewsCommand extends BaseCommand<String> {
    private final NewsDTO payload;

    public CreateNewsCommand(String id, NewsDTO payload) {
        super(id);
        this.payload = payload;
    }

    public NewsDTO getPayload() {
        return payload;
    }
}

