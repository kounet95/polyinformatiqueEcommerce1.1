package org.example.queryblog.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.queryblog.entite.Article;
import org.example.queryblog.query.GetAllAArticle;
import org.example.queryblog.repos.ArticleRepository;
import org.example.queryblog.repos.CategoryRepository;
import org.example.queryblog.repos.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ArticleQueryHendler {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    @QueryHandler
    public List<Article> on(GetAllAArticle query){
        return articleRepository.findAll();
    }
}
