package com.watchdogs.eventnetwork.controller.api;

import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ResponseController {

    @Autowired
    private IEventService eventService;

    public ResponseController() {

    }

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET)
    public Iterable<Event> MakeResponse(@RequestParam String word) {

        Iterable<Event> response = eventService.getByword(word); //avvio la ricerca della parola nel database, la ricerca si basa sui campi nome dell'evento, organizzatore oppure luogo

        //La ricerca restituisce oggetti JSON corrispondenti alle descrizioni delle istanze della tabella event che hanno matchato con word.

        return response;
    }
}