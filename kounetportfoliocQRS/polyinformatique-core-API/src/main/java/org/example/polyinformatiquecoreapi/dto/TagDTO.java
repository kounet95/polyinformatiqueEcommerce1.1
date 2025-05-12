package org.example.polyinformatiquecoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

//===============================//
//============= TAG ============//
//===============================//
@Getter
@AllArgsConstructor
public class TagDTO implements Serializable {
    private String id;
    private String name;
    private List<String> itemIds;
}
