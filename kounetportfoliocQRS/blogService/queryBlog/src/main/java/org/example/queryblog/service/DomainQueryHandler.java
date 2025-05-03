package org.example.queryblog.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.DomainDTO;
import org.example.queryblog.entite.Domain;
import org.example.queryblog.mapper.DomainMapper;
import org.example.queryblog.query.GetAllDomainQuery;
import org.example.queryblog.query.GetDomainByIdQuery;
import org.example.queryblog.repos.DomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DomainQueryHandler {

    private final DomainRepository domainRepository;
    private final DomainMapper domainMapper;

    @QueryHandler
    public List<DomainDTO> on(GetAllDomainQuery query) {
        List<Domain> domains = domainRepository.findAll();
        return domains.stream()
                .map(domainMapper::toDTO)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public DomainDTO on(GetDomainByIdQuery query) {
        Optional<Domain> optionalDomain = domainRepository.findById(query.getId());
        return optionalDomain
                .map(domainMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Domain not found with id: " + query.getId()));
    }
}