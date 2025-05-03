package org.example.queryblog.mapper;

import org.example.polyinformatiquecoreapi.dto.DomainDTO;
import org.example.queryblog.entite.Domain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DomainMapper {
    DomainDTO toDTO(Domain domain);
}