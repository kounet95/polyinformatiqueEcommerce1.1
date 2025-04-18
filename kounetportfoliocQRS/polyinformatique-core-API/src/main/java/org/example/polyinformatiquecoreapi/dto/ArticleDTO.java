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
import java.util.List;

//===============================//
//========== ARTICLE ===========//
//===============================//
@Getter
@AllArgsConstructor
public class ArticleDTO implements Serializable {
    private String id;
    private String title;
    private String contenu;
    private String urlMedia;

    private LocalDate createdAt;

    private String authorId;
    private String categoryId;
    private List<String> tagIds;

}
