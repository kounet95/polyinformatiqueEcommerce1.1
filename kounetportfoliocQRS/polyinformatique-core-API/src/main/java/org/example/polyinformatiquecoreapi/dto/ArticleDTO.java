package org.example.polyinformatiquecoreapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


//===============================//
//========== ARTICLE ===========//
//===============================//
@Getter
@AllArgsConstructor
public class ArticleDTO implements Serializable {
    private String id;
    private String content;
    private String urlMedia;
    private String title;
    private LocalDate createdAt;
    private String authorId;
    private String domainId;
    private List<String> tagIds;
    private List<String> commentIds;

}
