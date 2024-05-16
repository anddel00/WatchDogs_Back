package com.watchdogs.eventnetwork.repository;

import com.watchdogs.eventnetwork.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer> {


    public Iterable<Event> findByEventnameContainsIgnoreCaseOrOrganizzatoreContainsIgnoreCaseOrLuogoContainsIgnoreCase(String eventname, String organizzatore, String luogo);

    public Iterable<Event> findByMacroContainingIgnoreCaseAndTipologiaContainingIgnoreCase(String macro, String tipologia);

    public Iterable<Event> findByMacroContainingIgnoreCase(String macro);


}
