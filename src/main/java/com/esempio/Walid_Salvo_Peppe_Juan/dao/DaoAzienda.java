package com.esempio.Walid_Salvo_Peppe_Juan.dao;

import com.ant.utility.model.dao.DaoDBMS;
import com.ant.utility.model.db.IDatabase;
import com.ant.utility.model.entities.Entity;
import com.ant.utility.model.entities.EntityException;
import com.esempio.Walid_Salvo_Peppe_Juan.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoAzienda extends DaoDBMS {

    private String table = "azienda";

    @Autowired
    IDatabase db;


    @Override
    public List<Entity> list() {
        List lista = new ArrayList<Entity>();
        String query = "select * from azienda";

        for(Map<String,String> mappa : db.rows(query)){
            Entity e = new Persona();
            e.fromMap(mappa);
            lista.add(e);

        }
        return lista ;
    }

    @Override
    public Entity search(int i) {
        for(Entity w : list()){
            if(w.getId() == i)
                return w;
        }
        return null;
    }

    @Override
    public Entity load(Entity e) {
        if (e.getId() != 0 && search(e.getId()) != null)
        {
            String modifiche = caricaMappa(e.toMap());
            String query = UPDATE.replace("table", table).replace("[id]", e.getId() + "").replace("?", modifiche);


            return search(db.execute(query));
        } else {
            String chiavi = caricaString(e.toMap().keySet()).replace("'", "");
            String valori = caricaString(e.toMap().values());
            String query = CREATE.replace("table", table).replace("chiavi", chiavi).replace("valori", valori);

            int id = db.execute(query);
            if (id > 0) // id valido
            {
                try {
                    e.setId(id);
                } catch (EntityException e1) {
                    e1.printStackTrace();
                } // riaggiorno l'oggetto con l'id nuovo

                return search(e.getId());
            }
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        return db.execute(DELETE.replace("table", table).replace("[id]", id + "")) == -200;
    }
}
