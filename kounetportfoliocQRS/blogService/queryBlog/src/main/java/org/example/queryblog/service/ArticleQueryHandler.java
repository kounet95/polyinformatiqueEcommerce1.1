package org.example.queryblog.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.queryblog.entite.Article;
import org.example.queryblog.mapper.ArticleMapper;
import org.example.queryblog.query.GetAllArticlesQuery;
import org.example.queryblog.repos.ArticleRepository;
import org.example.queryblog.repos.DomainRepository;
import org.example.queryblog.repos.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ArticleQueryHandler {

    private final ArticleRepository articleRepository;
    private final DomainRepository categoryRepository;
    private final TagRepository tagRepository;
    private final ArticleMapper articleMapper;

    @QueryHandler
    public List<ArticleDTO> on(GetAllArticlesQuery query) {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(articleMapper::toDTO) // ton mapper MapStruct
                .collect(Collectors.toList());
    }





}
