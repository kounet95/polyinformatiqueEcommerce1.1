package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.CategoryDTO;

public class CreateCategoryCommand extends BaseCommand<String> {
    private final CategoryDTO payload;

    public CreateCategoryCommand(String id, CategoryDTO payload) {
        super(id);
        this.payload = payload;
    }

    public CategoryDTO getPayload() {
        return payload;
    }
}

