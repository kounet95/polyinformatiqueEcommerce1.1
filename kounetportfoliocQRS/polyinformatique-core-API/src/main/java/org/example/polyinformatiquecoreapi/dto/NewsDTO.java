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
//=========== NEWS =============//
//===============================//
@Getter
@AllArgsConstructor
public class NewsDTO implements Serializable {
    private String id;
    private String title;
    private String summary;
    private String contenu;
    private String urlMedia;

    private LocalDate createdAt;

    private String authorId;

}
