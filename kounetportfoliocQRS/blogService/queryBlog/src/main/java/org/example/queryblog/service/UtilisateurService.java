package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.queryblog.repos.CommentRepository;
import org.example.queryblog.repos.IteamRepository;
import org.example.queryblog.repos.UtilisateurRepos;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepos utilisateurRepos;
     private final IteamRepository teamRepo;
     private final CommentRepository commentRepo;


     @EventHandler
     public void on (){


     }

}
