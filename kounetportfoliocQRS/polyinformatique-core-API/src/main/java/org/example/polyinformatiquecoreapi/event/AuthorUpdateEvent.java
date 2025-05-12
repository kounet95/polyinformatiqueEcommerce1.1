package org.example.polyinformatiquecoreapi.event;

import org.example.polyinformatiquecoreapi.dto.AuthorDTO;

public class AuthorUpdateEvent {

    private final String id;
    private final AuthorDTO author;

    public AuthorUpdateEvent(String id, AuthorDTO author) {
        this.id = id;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public AuthorDTO getAuthor() {
        return author;
    }
}
