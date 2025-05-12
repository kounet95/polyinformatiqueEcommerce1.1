package org.example.polyinformatiquecoreapi.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

//===============================//
//========= Author ============//
//===============================//
@Getter
@AllArgsConstructor
public class AuthorDTO implements Serializable {

    private String id;
    private String username;
    private String email;
    private String name;
    private String phone;
    private String address;

    private List<String> commentIds;
    private List<String> itemIds;
}
