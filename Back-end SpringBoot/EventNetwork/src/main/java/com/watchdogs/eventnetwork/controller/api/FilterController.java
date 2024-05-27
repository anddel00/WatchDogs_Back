package com.watchdogs.eventnetwork.controller.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.service.IEventService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Controller REST che gestisce chiamata API quando viene selezionato un filtro

@RestController
public class FilterController {

    @Autowired
    private IEventService eventService; //Il controller lato back-end comunica con i Service

    public FilterController(){

    }

    //Metodo per gestire le richieste HTTP PUT all'endpoint "/filter"
    @RequestMapping(value = "/filter", method = RequestMethod.PUT)
    public Iterable<Event> MakeSuggestions(@RequestBody String categoria) throws ParseException {

        // Estrae il valore della categoria dal JSON ricevuto all'interno del body
        int startIndex = categoria.indexOf(":") + 2; // L'indice di inizio del valore è dopo il :
        int endIndex = categoria.lastIndexOf("\""); // L'indice di fine del valore è prima dell'ultima "

        // Ottiene il valore della categoria dalla stringa JSON
        categoria = categoria.substring(startIndex,endIndex);

        // categoria potrebbe contenere macrocategoria e tipologia, oppure solo macro
        String[] values = categoria.split(" ");

        String macro = values[0]; // Il primo valore è la macro categoria


        if(values.length < 2) //Se tipologia non è specificata
        {
            return eventService.getByMacro(macro); // Restituisce eventi filtrati per macro categoria
        }
        else{
            String tipo = values[1];
            return eventService.getByType(macro, tipo); // Restituisce eventi filtrati per macro categoria e tipologia
        }
    }
}
