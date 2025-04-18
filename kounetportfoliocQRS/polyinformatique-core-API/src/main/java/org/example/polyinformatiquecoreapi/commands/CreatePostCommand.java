package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.ArticleDTO;

public class CreatePostCommand extends BaseCommand<String> {
    private final ArticleDTO payload;

    public CreatePostCommand(String id, ArticleDTO payload) {
        super(id);
        this.payload = payload;
    }

    public ArticleDTO getPayload() {
        return payload;
    }
}

