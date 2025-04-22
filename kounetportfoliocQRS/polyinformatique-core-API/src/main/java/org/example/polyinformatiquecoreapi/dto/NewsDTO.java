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
//=========== NEWS =============//
//===============================//
@Getter
@AllArgsConstructor
public class NewsDTO implements Serializable {
    private String id;
    private String summary;
    private String content;
    private String urlMedia;
    private String title;
    private LocalDate createdAt;
    private String authorId;
    private String domainId;
    private List<String> tagIds;
    private List<String> commentIds;

}

