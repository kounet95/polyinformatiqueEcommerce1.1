package org.example.queryblog.web;


import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.example.queryblog.entite.Article;
import org.example.queryblog.query.GetAllAArticle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("query/article")
@AllArgsConstructor
public class ArticleQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Article>> getAllArticle(){
        CompletableFuture<List<Article>> result = queryGateway.query(
                new GetAllAArticle(), ResponseTypes.multipleInstancesOf(Article.class));
        return result;
    }

}
