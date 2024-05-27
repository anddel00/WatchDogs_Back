package com.watchdogs.eventnetwork.controller.api;

import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*Controller REST che gestisce chiamata API quando viene inserita una chiave di ricerca.
La ricerca avviene in base al nome dell'evento, all'organizzatore e al luogo.
 */

@RestController
public class ResponseController {

    @Autowired
    private IEventService eventService; //Il controller lato back-end comunica con i Service

    public ResponseController() {

    }

    //Metodo per gestire le richieste HTTP GET all'endpoint "/search"
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<Event> MakeResponse(@RequestParam String word) {

        Iterable<Event> response = eventService.getByword(word);


        return response; //La ricerca restituisce al front le istanze della tabella event che hanno matchato con word.
    }
}