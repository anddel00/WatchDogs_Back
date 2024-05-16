package com.watchdogs.eventnetwork.service;

import com.watchdogs.eventnetwork.model.Event;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IEventService {
    public Iterable<Event> getByword(String word);

    public Iterable<Event> getByType(String macro, String tipo);
    public Iterable<Event> getByMacro(String filter);

}
