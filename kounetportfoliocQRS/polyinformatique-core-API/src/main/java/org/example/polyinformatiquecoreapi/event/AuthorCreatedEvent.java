package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.AuthorDTO;

import java.io.Serializable;

public class AuthorCreatedEvent  extends BaseEvent<String> implements Serializable {

    private AuthorDTO author;
    public AuthorCreatedEvent(String id,AuthorDTO author) {
        super(id);
        this.author = author;
    }

    public AuthorDTO getAuthor() {
        return author;
    }
}
