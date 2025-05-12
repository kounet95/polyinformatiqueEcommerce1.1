package org.example.queryblog.repos;

import org.example.queryblog.entite.Article;
import org.example.queryblog.entite.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepos extends JpaRepository<Utilisateurs,String> {

}
