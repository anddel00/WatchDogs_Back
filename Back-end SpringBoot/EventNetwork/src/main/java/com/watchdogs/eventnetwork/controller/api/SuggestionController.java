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
import java.util.stream.StreamSupport;

@RestController
public class SuggestionController {

    @Autowired
    private IEventService eventService;

    public SuggestionController(){

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<String> MakeSuggestions(@RequestParam String word) {

        Iterable<Event> response = eventService.getByword(word); //avvio la ricerca della parola nel database, la ricerca si basa sui campi nome dell'evento, organizzatore oppure luogo

        //La ricerca restituisce oggetti JSON corrispondenti alle descrizioni delle istanze della tabella event che hanno matchato con word.
        //Voglio suggerire il nome, l'organizzatore o il luogo che l'utente stava cercando con la digitazione

        Iterable<String> suggestion_eventname = StreamSupport.stream(response.spliterator(), false).map(Event::getEventname).collect(Collectors.toList()); //Lista dei nomi che hanno matchato
        Iterable<String> suggestion_organizer = StreamSupport.stream(response.spliterator(), false).map(Event::getOrganizzatore).collect(Collectors.toList()); //Lista degli organizzatori
        Iterable<String> suggestion_place = StreamSupport.stream(response.spliterator(), false).map(Event::getLuogo).collect(Collectors.toList()); //Lista dei luoghi

        //Se restituissi una concatenazione delle 3 liste, per ogni ricerca, sarebbe suggerito il campo che si stava cercando, e in più gli altri due campi corrispondenti, che non si stavano cercando.
        //Realizzo quindi delle ricerche negli Iterable e mostro solo i suggerimenti che effettivamente contengono la parola cercata, non gli altri campi associati ad essa

        List<String> matchingSuggestions = new ArrayList<>();

        for (String suggestion : suggestion_eventname) {
            if (suggestion.toLowerCase().contains(word.toLowerCase())) {
                matchingSuggestions.add(suggestion);
            }
        }

        for (String suggestion : suggestion_organizer) {
            if (suggestion.toLowerCase().contains(word.toLowerCase())) {
                matchingSuggestions.add(suggestion);
            }
        }

        for (String suggestion : suggestion_place) {
            if (suggestion.toLowerCase().contains(word.toLowerCase())) {
                matchingSuggestions.add(suggestion);
            }
        }

        List<String> uniqueMatchingSuggestions = new ArrayList<>(new HashSet<>(matchingSuggestions));

        return uniqueMatchingSuggestions;
    }
}
