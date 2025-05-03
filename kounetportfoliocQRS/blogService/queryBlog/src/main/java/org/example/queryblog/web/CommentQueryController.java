package org.example.queryblog.web;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.example.polyinformatiquecoreapi.dto.CommentDTO;
import org.example.queryblog.query.GetAllCommentQuery;
import org.example.queryblog.query.GetCommentByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<CommentDTO>> getAllComments() {
        return queryGateway.query(new GetAllCommentQuery(),
                org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CommentDTO.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<CommentDTO> getCommentById(@PathVariable String id) {
        return queryGateway.query(new GetCommentByIdQuery(id),
                org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CommentDTO.class));
    }
}
