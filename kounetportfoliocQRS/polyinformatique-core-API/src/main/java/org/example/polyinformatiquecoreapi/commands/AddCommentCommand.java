package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.CommentDTO;

public class AddCommentCommand extends BaseCommand<String> {
    private final String commentId;
    private final CommentDTO payload;

    public AddCommentCommand(String id, String commentId, CommentDTO payload) {
        super(id);
        this.commentId = commentId;
        this.payload = payload;
    }

    public String getCommentId() {
        return commentId;
    }

    public CommentDTO getPayload() {
        return payload;
    }
}

