package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//===============================//
//=========== MEDIA ============//
//===============================//
@Getter
@AllArgsConstructor
public class MediaDTO implements Serializable {
    private String id;
    private String fileName;
    private String fileType;


}
