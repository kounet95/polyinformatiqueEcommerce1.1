package org.example.queryblog.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.example.polyinformatiquecoreapi.dto.EventDTO;
import org.example.queryblog.entite.Event;
import org.example.queryblog.mapper.EventMapper;
import org.example.queryblog.query.GetAllEventQuery;
import org.example.queryblog.query.GetEventByIdQuery;
import org.example.queryblog.repos.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class EventQueryHandler {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @QueryHandler
    public List<EventDTO> on(GetAllEventQuery query) {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public EventDTO on(GetEventByIdQuery query) {
        Optional<Event> optionalEvent = eventRepository.findById(query.getId());
        return optionalEvent
                .map(eventMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + query.getId()));
    }
}