package org.example.queryblog.mapper;

import org.example.polyinformatiquecoreapi.dto.TagDTO;
import com.example.polyinformatiquecommon.blog.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDTO toDTO(Tag tag);
}
