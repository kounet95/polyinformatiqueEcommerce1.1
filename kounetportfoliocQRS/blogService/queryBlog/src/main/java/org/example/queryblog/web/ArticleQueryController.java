package org.example.queryblog.web;


import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.polyinformatiquecoreapi.dto.ArticleDTO;
import org.example.queryblog.entite.Article;
import org.example.queryblog.query.GetAllArticlesQuery;
import org.example.queryblog.query.GetArticleByIdQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("query/article")
@AllArgsConstructor
public class ArticleQueryController {
    private final QueryGateway queryGateway;

    @GetMapping("/articles")
    public CompletableFuture<List<ArticleDTO>> getAllArticle() {
        System.out.println(">>> Sending GetAllArticlesQuery");
        return queryGateway.query(new GetAllArticlesQuery(),
                ResponseTypes.multipleInstancesOf(ArticleDTO.class));
    }
    @GetMapping("/articles/{id}")
    public CompletableFuture<ArticleDTO> getArticleById(@PathVariable String id) {
        System.out.println(">>> Sending GetArticleByIdQuery for id: " + id);
        return queryGateway.query(new GetArticleByIdQuery(id),
                ResponseTypes.instanceOf(ArticleDTO.class));
    }


}
