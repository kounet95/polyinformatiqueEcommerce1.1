package org.example.polyinformatiquecoreapi.commands;

public class EditCommentCommand extends BaseCommand<String> {
    private final String commentId;
    private final String newContent;

    public EditCommentCommand(String id, String commentId, String newContent) {
        super(id);
        this.commentId = commentId;
        this.newContent = newContent;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getNewContent() {
        return newContent;
    }
}
