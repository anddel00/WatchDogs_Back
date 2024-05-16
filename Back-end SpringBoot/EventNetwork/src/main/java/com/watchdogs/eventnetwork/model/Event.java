package com.watchdogs.eventnetwork.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity //facciamo capire a Spring che questa classe vuole essere una rappresentazione di una tabella
public class Event {

    @Id //indica che il campo id, è chiave primaria della tabella event nel DB
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generazione automatica del valore, autoincrementante per ogni aggiunta.
    private Integer id;

    private String macro;
    private String tipologia;

    private String url_image;


    private String eventname;

    private String organizzatore;
    private Boolean sponsor;
    private String luogo;
    private String data;

    private String descrizione;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMacro() {
        return macro;
    }

    public void setMacro(String macro) {
        this.macro = macro;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(String organizzatore) {
        this.organizzatore = organizzatore;
    }

    public Boolean getSponsor() {
        return sponsor;
    }

    public void setSponsor(Boolean sponsor) {
        this.sponsor = sponsor;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Event() {

    }


    public Event(int id, String macro, String tipologia, String url_image, String eventname, String organizzatore, Boolean sponsor, String luogo, String data, String descrizione) {
        this.id = id;
        this.macro = macro;
        this.tipologia = tipologia;
        this.url_image = url_image;
        this.eventname = eventname;
        this.organizzatore = organizzatore;
        this.sponsor = sponsor;
        this.luogo = luogo;
        this.data = data;
        this.descrizione = descrizione;
    }


}
