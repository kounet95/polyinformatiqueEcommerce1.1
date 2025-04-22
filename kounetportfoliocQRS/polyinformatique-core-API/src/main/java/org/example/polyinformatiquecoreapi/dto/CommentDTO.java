package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

//===============================//
//========= COMMENT ============//
//===============================//

@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {
    private String id;
   private String contenu;
    private LocalDate createdAt;
    private String authorId;
    private String itemId;

    public String getAuthorId() {
        return authorId;
    }

    public String getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getItemId() {
        return itemId;
    }
}

