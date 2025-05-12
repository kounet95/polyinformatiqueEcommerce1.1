package org.example.polyinformatiquecoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

//===============================//
//========== CATEGORY ==========//
//===============================//

@AllArgsConstructor
public class DomainDTO implements Serializable {
    private String id;
    private String name;
    private List<String> articles;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getArticles() {
        return articles;
    }
}

