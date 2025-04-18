package org.example.queryblog.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.polyinformatiquecoreapi.event.PostCreatedEvent;
import org.example.queryblog.entite.Article;
import org.example.queryblog.entite.Category;
import org.example.queryblog.entite.Tag;
import org.example.queryblog.repos.ArticleRepository;
import org.example.queryblog.repos.CategoryRepository;
import org.example.queryblog.repos.TagRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Transactional
@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    @EventHandler
    public void on(PostCreatedEvent event) {
        log.info("**********************************");
        log.info("un post created event");

        ArticleDTO dto = event.getPayload();

        Article article = Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .contenu(dto.getContenu())
                .urlMedia(dto.getUrlMedia())
                .createdAt(dto.getCreatedAt())
                .authorId(dto.getAuthorId())
                .build();

        // Ensuite récupère la catégorie et les tags à partir de leur ID
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        article.setCategory(category);

        List<Tag> tags = tagRepository.findAllById(dto.getTagIds());
        article.setTags(tags);

        articleRepository.save(article);
    }

}
