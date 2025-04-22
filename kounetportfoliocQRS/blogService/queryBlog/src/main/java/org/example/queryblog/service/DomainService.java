package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.DomainCreateEvent;
import org.example.queryblog.entite.Article;
import org.example.queryblog.entite.Domain;
import org.example.queryblog.repos.ArticleRepository;
import org.example.queryblog.repos.DomainRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DomainService {

    private final DomainRepository domainRepository;
    private final ArticleRepository articleRepository;
    @EventHandler
    public void on(DomainCreateEvent event) {
   //recuperer mes articles du domain venant de levenement
        List<String> articles = event.getDomainDTO().getArticles();
        // Recuperer les articles qui correspondent à ces IDs dans la base
        List<Article> articleslist = articleRepository.findAllById(articles);

        Domain domain = Domain.builder()
                .name(event.getDomainDTO().getName())
                .articles(articleslist)
                .build();

        domainRepository.save(domain);

    }
}
