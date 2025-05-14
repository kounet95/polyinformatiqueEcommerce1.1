package org.example.polyinformatiquecoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomerBlogDTO {
    private String id;
    private String username;
    private String Lastname;
    private String email;
    private String name;
    private String phone;
    private String address;
    private List<String> iteamIds;
    private List<String> commentIds;
}

