package org.example.queryblog.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.CommentAddedEvent;
import org.example.queryblog.entite.Comment;
import org.example.queryblog.entite.Item;
import org.example.queryblog.entite.Utilisateurs;
import org.example.queryblog.repos.CommentRepository;
import org.example.queryblog.repos.IteamRepository;
import org.example.queryblog.repos.UtilisateurRepos;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UtilisateurRepos utilisateurRepos;
    private final IteamRepository teamRepo;
    @EventHandler
    public void on(CommentAddedEvent event) {

        // On récupère l'utilisateur par leur ID
        Utilisateurs utilisateur = utilisateurRepos.findById(event.getCommentDTO().getAuthorId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found")).getUtilisateur();
        // On récupère l'item par leur ID
        Item item = teamRepo.findById(event.getCommentDTO().getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Comment comment = Comment.builder()
                .item(item)
                .content(event.getCommentDTO().getContenu())
                .createdAt(event.getCommentDTO().getCreatedAt())
                .utilisateur(utilisateur)
                .build();
        commentRepository.save(comment);

    }
}
