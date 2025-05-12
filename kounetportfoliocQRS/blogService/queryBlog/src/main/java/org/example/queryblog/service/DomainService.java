package org.example.queryblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.example.polyinformatiquecoreapi.event.DomainCreateEvent;
import org.example.polyinformatiquecoreapi.event.DomainDeletedEvent;
import org.example.polyinformatiquecoreapi.event.ItemDeletedEvent;
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
        log.debug("Handling DomainCreateEvent: {}", event.getId());

        Domain domain = new Domain();
        domain.setId(event.getId());
        domain.setName(event.getDomainDTO().getName());

        domainRepository.save(domain);
    }

    @EventHandler
    public void on(DomainDeletedEvent event) {
        log.debug("Handling DomainDeletedEvent: {}", event.getId());

        domainRepository.deleteById(event.getId());
    }

    @EventHandler
    public void on(ItemDeletedEvent event) {
        log.debug("Handling ItemDeletedEvent: {}", event.getId());

        domainRepository.deleteById(event.getId());
    }
}
