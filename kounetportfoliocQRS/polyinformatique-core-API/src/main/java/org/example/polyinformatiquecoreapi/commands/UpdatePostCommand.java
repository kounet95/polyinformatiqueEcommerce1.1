package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.ArticleDTO;

public class UpdatePostCommand extends BaseCommand<String> {
    private final ArticleDTO payload;

    public UpdatePostCommand(String id, ArticleDTO payload) {
        super(id);
        this.payload = payload;
    }

    public ArticleDTO getPayload() {
        return payload;
    }
}
