package com.esempio.Walid_Salvo_Peppe_Juan.model;

import com.ant.utility.model.entities.Entity;

import java.util.Map;

public abstract class EntityFactory {

    public static Entity make(Map<String,String> row) throws NullPointerException {

        Entity e = null;
        String type = row.get("tipo").toLowerCase();
        row.remove("tipo");

        switch (type){

            case "azienda":
                e = new Azienda();
                break;

            case "dipendente":
                e = new Dipendente();
                break;

            case "persona":
                e = new Persona();
                break;

            case "status":
                e = new Status();
                break;
        }

        if(e != null)
            e.fromMap(row);
            return e;
    }
}