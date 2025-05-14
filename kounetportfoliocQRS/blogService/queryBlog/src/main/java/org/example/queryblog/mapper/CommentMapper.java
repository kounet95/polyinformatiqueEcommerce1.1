package org.example.queryblog.mapper;

import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import com.example.polyinformatiquecommon.blog.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toDTO(Comment comment);
}
