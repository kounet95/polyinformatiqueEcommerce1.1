package org.example.queryblog.mapper;

import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.example.queryblog.entite.Utilisateurs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDTO(Utilisateurs utilisateur);
}