package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.DomainDTO;

public class CreateCategoryCommand extends BaseCommand<String> {
    private final DomainDTO payload;

    public CreateCategoryCommand(String id, DomainDTO payload) {
        super(id);
        this.payload = payload;
    }

    public DomainDTO getPayload() {
        return payload;
    }
}

