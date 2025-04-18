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
@Getter
@AllArgsConstructor
public class CommentDTO implements Serializable {
    private String id;
    private String contenu;
    private String urlMedia;
    private String postId;
    private LocalDate createdAt;

    private String authorId;


}
