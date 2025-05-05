package org.example.queryblog.web;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.example.polyinformatiquecoreapi.dto.AuthorDTO;
import org.example.queryblog.query.GetAllAuthorQuery;
import org.example.queryblog.query.GetAuthorByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<AuthorDTO>> getAllUtilisateurs() {
        return queryGateway.query(new GetAllAuthorQuery(),
                org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AuthorDTO.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<AuthorDTO> getUtilisateurById(@PathVariable String id) {
        return queryGateway.query(new GetAuthorByIdQuery(id),
                org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(AuthorDTO.class));
    }
}
