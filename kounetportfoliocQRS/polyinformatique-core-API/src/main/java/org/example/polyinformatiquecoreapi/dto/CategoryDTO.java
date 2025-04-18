package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//===============================//
//========== CATEGORY ==========//
//===============================//
@Getter
@AllArgsConstructor
public class CategoryDTO implements Serializable {
    private String id;
    private String title;
    private String description;

}
