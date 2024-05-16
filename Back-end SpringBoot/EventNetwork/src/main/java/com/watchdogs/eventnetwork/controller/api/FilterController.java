package com.watchdogs.eventnetwork.controller.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.watchdogs.eventnetwork.model.Event;
import com.watchdogs.eventnetwork.service.IEventService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilterController {

    @Autowired
    private IEventService eventService;

    public FilterController(){

    }

    @RequestMapping(value = "/filter", method = RequestMethod.PUT)
    public Iterable<Event> MakeSuggestions(@RequestBody String categoria) throws ParseException {

        int startIndex = categoria.indexOf(":") + 2; // L'indice di inizio del valore è dopo il :
        int endIndex = categoria.lastIndexOf("\""); // L'indice di fine del valore è prima dell'ultima "

        categoria = categoria.substring(startIndex,endIndex);

        String[] values = categoria.split(" ");
        System.out.println(values.length);
        String macro = values[0];

        if(values.length < 2)
        {
            return eventService.getByMacro(macro);
        }
        else{
            String tipo = values[1];
            return eventService.getByType(macro, tipo);
        }
    }
}
