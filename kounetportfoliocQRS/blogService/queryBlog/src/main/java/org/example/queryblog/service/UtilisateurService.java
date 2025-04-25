package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.AuthorCreatedEvent;
import org.example.queryblog.entite.Comment;
import org.example.queryblog.entite.Item;
import org.example.queryblog.entite.Utilisateurs;
import org.example.queryblog.repos.CommentRepository;
import org.example.queryblog.repos.IteamRepository;
import org.example.queryblog.repos.UtilisateurRepos;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepos utilisateurRepos;
     private final IteamRepository teamRepo;
     private final CommentRepository commentRepo;


     @EventHandler
     public void on (AuthorCreatedEvent event){

      List<Item> itemList= teamRepo.findAllById(event.getAuthor().getItemIds());
      List<Comment> commentList= commentRepo.findAllById(event.getAuthor().getCommentIds());
      Utilisateurs utilisateurs = Utilisateurs.builder()
              .username(event.getAuthor().getUsername())
              .phone(event.getAuthor().getPhone())
              .address(event.getAuthor().getAddress())
              .name(event.getAuthor().getName())
              .commentList(commentList)
              .items(itemList)
              .build();

      utilisateurRepos.save(utilisateurs);

     }

}
