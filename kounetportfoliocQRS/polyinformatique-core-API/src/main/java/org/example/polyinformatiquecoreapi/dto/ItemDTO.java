package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//===============================//
//=========== ITEM =============//
//===============================//
@Getter
@AllArgsConstructor
public class ItemDTO implements Serializable {
    private String id;
    private String content;
    private String urlMedia;
    private String title;
    private LocalDate createdAt;

    private String authorId;


    private List<String> mediaIds;

    private List<String> commentIds;

    private List<String> tagIds;

}

