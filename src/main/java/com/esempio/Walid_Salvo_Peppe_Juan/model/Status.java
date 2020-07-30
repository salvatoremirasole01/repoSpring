package com.esempio.Walid_Salvo_Peppe_Juan.model;

import com.ant.utility.model.entities.Entity;

public class Status extends Entity {

    private String descrizione;

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return "Status{" +
                "descrizione='" + descrizione + '\'' +
                '}';
    }
}
