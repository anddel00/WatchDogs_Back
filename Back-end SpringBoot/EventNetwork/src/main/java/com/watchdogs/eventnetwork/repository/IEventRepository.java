package com.watchdogs.eventnetwork.repository;

import com.watchdogs.eventnetwork.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//IEventRepository estende JpaRepository, la quale fornisce implementazione delle operazioni CRUD.
//Vengono definite funzioni generate tramite convenzioni di denominazione.
//Funzionalità offerta da Query Methods, parte di Spring Data JPA.

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer> {


    //Ricerca nel database delle istanze tramite campi nome, organizzatore e luogo. Usata sia per fornire le risposta che i suggerimenti.
    // Per i suggerimenti, vengono prese e passate al service le istanze i cui campi sopra contengono le lettere che vengono passate come parametro per ogni ricerca.
    public Iterable<Event> findByEventnameContainsIgnoreCaseOrOrganizzatoreContainsIgnoreCaseOrLuogoContainsIgnoreCaseOrderBySponsorDesc(String eventname, String organizzatore, String luogo);

    //Ricerca invocata dal controller FilterController per restituire eventi in base alla macro-area e la tipologia
    public Iterable<Event> findByMacroContainingIgnoreCaseAndTipologiaContainingIgnoreCaseOrderBySponsorDesc(String macro, String tipologia);

    //Ricerca invocata dal controller FilterController per restituire eventi in base alla macro-area
    public Iterable<Event> findByMacroContainingIgnoreCaseOrderBySponsorDesc(String macro);


}
