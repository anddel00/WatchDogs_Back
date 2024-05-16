package com.watchdogs.eventnetwork.service;

import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService implements IEventService{

    @Autowired
    private IEventRepository eventRepository;

    @Override
    public Iterable<Event> getByword(String word) {
        return eventRepository.findByEventnameContainsIgnoreCaseOrOrganizzatoreContainsIgnoreCaseOrLuogoContainsIgnoreCase(word, word, word);
    }

    @Override
    public Iterable<Event> getByType(String macro, String tipo) {
        return eventRepository.findByMacroContainingIgnoreCaseAndTipologiaContainingIgnoreCase(macro, tipo);
    }

    @Override
    public Iterable<Event> getByMacro(String filter) {
        return eventRepository.findByMacroContainingIgnoreCase(filter);
    }
}
