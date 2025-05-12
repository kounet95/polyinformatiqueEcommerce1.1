package org.example.queryblog.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.TagDTO;
import org.example.queryblog.entite.Tag;
import org.example.queryblog.mapper.TagMapper;
import org.example.queryblog.query.GetAllTagQuery;
import org.example.queryblog.query.GetTagByIdQuery;
import org.example.queryblog.repos.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class TagQueryHandler {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @QueryHandler
    public List<TagDTO> on(GetAllTagQuery query) {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream()
                .map(tagMapper::toDTO)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public TagDTO on(GetTagByIdQuery query) {
        Optional<Tag> optionalTag = tagRepository.findById(query.getId());
        return optionalTag
                .map(tagMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + query.getId()));
    }
}