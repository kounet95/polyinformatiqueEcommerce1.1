package org.example.queryblog.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.example.queryblog.entite.Utilisateurs;
import org.example.queryblog.mapper.AuthorMapper;
import org.example.queryblog.query.GetAllAuthorQuery;
import org.example.queryblog.query.GetAuthorByIdQuery;
import org.example.queryblog.repos.UtilisateurRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorQueryHandler {

    private final UtilisateurRepos utilisateurRepos;
    private final AuthorMapper authorMapper;

    @QueryHandler
    public List<AuthorDTO> on(GetAllAuthorQuery query) {
        List<Utilisateurs> authors = utilisateurRepos.findAll();
        return authors.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public AuthorDTO on(GetAuthorByIdQuery query) {
        Optional<Utilisateurs> optionalAuthor = utilisateurRepos.findById(query.getId());
        return optionalAuthor
                .map(authorMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + query.getId()));
    }
}