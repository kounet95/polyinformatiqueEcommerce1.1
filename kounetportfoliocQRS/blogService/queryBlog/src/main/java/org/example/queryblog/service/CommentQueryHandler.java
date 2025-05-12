package org.example.queryblog.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import org.example.queryblog.entite.Comment;
import org.example.queryblog.mapper.CommentMapper;
import org.example.queryblog.query.GetAllCommentQuery;
import org.example.queryblog.query.GetCommentByIdQuery;
import org.example.queryblog.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CommentQueryHandler {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @QueryHandler
    public List<CommentDTO> on(GetAllCommentQuery query) {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public CommentDTO on(GetCommentByIdQuery query) {
        Optional<Comment> optionalComment = commentRepository.findById(query.getId());
        return optionalComment
                .map(commentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + query.getId()));
    }
}