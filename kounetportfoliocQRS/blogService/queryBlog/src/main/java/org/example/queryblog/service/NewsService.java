package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.NewsCreatedEvent;
import org.example.queryblog.entite.*;
import org.example.queryblog.repos.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NewsService {


    private final DomainRepository domainRepository;
    private final UtilisateurRepos utilisateurRepository;
    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;

    @EventHandler
    public void on(NewsCreatedEvent event) {
        // On récupère le domain et l'utilisateur par leur ID
        Domain domain = domainRepository.findById(event.getNewsDTO().getDomainId())
                .orElseThrow(() -> new RuntimeException("Domain not found"));

        Utilisateurs utilisateur = utilisateurRepository.findById(event.getNewsDTO().getAuthorId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found")).getUtilisateur();

        // Recuperer les IDs de commentaires envoyes dans la commande
        List<String> idsCommentaires = event.getNewsDTO().getCommentIds();

        // Recuperer les commentaires qui correspondent à ces IDs dans la base
        List<Comment> commentaires = commentRepository.findAllById(idsCommentaires);

        // Recuperer les IDs de commentaires envoyes dans la commande
        List<String> idsTags = event.getNewsDTO().getTagIds();

        // Recuperer les commentaires qui correspondent à ces IDs dans la base
        List<Tag> tags = tagRepository.findAllById(idsTags);



    News newsEtite = News.builder()
            .summary(event.getNewsDTO().getSummary())
            .commentList(commentaires)
            .title(event.getNewsDTO().getTitle())
            .content(event.getNewsDTO().getContent())
            .tags(tags)
            .urlMedia(event.getNewsDTO().getUrlMedia())
            .utilisateur(utilisateur)
            .build();
      newsRepository.save(newsEtite);

    }


    }
