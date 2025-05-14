package org.example.queryblog.mapper;

import com.example.polyinformatiquecommon.Customer;

import org.example.polyinformatiquecoreapi.dto.CustomerBlogDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerBlogDTO toDTO(Customer utilisateur);
}
