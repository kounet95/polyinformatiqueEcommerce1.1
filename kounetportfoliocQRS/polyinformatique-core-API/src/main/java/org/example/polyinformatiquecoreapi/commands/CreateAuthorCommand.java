package org.example.polyinformatiquecoreapi.commands;

import org.example.polyinformatiquecoreapi.dto.AuthorDTO;

public class CreateAuthorCommand extends BaseCommand<String>{

    private AuthorDTO author;


    public CreateAuthorCommand(String id, AuthorDTO author) {
        super(id);
        this.author = author;
    }

    public AuthorDTO getAuthor() {
        return author;
    }
}
