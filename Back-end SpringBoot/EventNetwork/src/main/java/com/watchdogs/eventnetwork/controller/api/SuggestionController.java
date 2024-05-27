package com.watchdogs.eventnetwork.controller.api;

import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*
    Controller REST che legge gli input dell'utente ad ogni digitazione.
    Effettua ricerche nel DB sui campi nome evento, organizzatore e luogo
    e restituisce le singole parole che matchano con la digitazione effettuata.
*/

@RestController
public class SuggestionController {

    @Autowired
    private IEventService eventService; //Il controller lato back-end comunica con i Service

    public SuggestionController(){

    }

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET)
    public Iterable<String> MakeSuggestions(@RequestParam String word) {

        Iterable<Event> response = eventService.getByword(word); //avvio la ricerca in base alle lettere che arrivano dal front

        // Combina i suggerimenti in un unico stream applicando i filtri
        List<String> matchingSuggestions = StreamSupport.stream(response.spliterator(), false) //conversione di response in uno Stream<Event>
                .flatMap(event -> Stream.of(event.getEventname(), event.getOrganizzatore(), event.getLuogo())) //per ogni Event nello stream, si crea 1 stream con 3 attributi: nome evento, organizzatore e luogo.
                .filter(Objects::nonNull) // Filtra i campi null
                .filter(suggestion -> suggestion.toLowerCase().contains(word.toLowerCase())) // Filtra i suggerimenti che contengono la parola cercata
                .distinct() // Elimina i duplicati
                .collect(Collectors.toList()); //gli stream uniti da flatMap vengono raccolti in un'unica lista.

        return matchingSuggestions;
    }
}
