package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.PostCreatedEvent;
import org.example.queryblog.entite.*;
import org.example.queryblog.repos.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final DomainRepository domainRepository;
    private final UtilisateurRepos utilisateurRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;

    @EventHandler
    public void on(PostCreatedEvent event) {
        // On récupère le domain par leur ID
        log.debug("Trying to find domain with ID: {}", event.getArticleDTO().getDomainId());
        Domain domain = domainRepository.findById(event.getArticleDTO().getDomainId())
                .orElseThrow(() -> new RuntimeException("Domain not found"));

        // On récupère l'utilisateur par leur ID
        Utilisateurs utilisateur = utilisateurRepository.findById(event.getArticleDTO().getAuthorId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        // Recuperer les IDs de commentaires envoyes dans la commande
        List<String> idsCommentaires = event.getArticleDTO().getCommentIds();

     // Recuperer les commentaires qui correspondent à ces IDs dans la base
        List<Comment> commentaires = commentRepository.findAllById(idsCommentaires);

        // Recuperer les IDs de commentaires envoyes dans la commande
        List<String> idsTags = event.getArticleDTO().getTagIds();

     // Recuperer les commentaires qui correspondent à ces IDs dans la base
        List<Tag> tags = tagRepository.findAllById(idsTags);




        // creation d’un nouvel article à partir des données de l’événement
        Article article = Article.builder()
                .title(event.getArticleDTO().getTitle())
                .content(event.getArticleDTO().getContent())
                .urlMedia(event.getArticleDTO().getUrlMedia())
                .createdAt(LocalDate.now())
                .utilisateur(utilisateur)
                .comments(commentaires)
                .tags(tags)
                .domain(domain)
                .build();

        articleRepository.save(article);
    }
}
