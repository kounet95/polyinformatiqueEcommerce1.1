package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//===============================//
//=========== EVENT ============//
//===============================//
@Getter
@AllArgsConstructor
public class EventDTO implements Serializable {
    private String id;
    private String location;
    private LocalDateTime   begin;
    private LocalDateTime  end;
    private String content;
    private String urlMedia;
    private String title;
    private LocalDate createdAt;
    private String authorId;
    private String domainId;
    private List<String> tagIds;
    private List<String> commentIds;
}

