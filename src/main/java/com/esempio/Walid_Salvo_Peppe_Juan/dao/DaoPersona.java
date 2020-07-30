package com.esempio.Walid_Salvo_Peppe_Juan.dao;

import com.ant.utility.model.dao.DaoDBMS;
import com.ant.utility.model.db.IDatabase;
import com.ant.utility.model.entities.Entity;
import com.esempio.Walid_Salvo_Peppe_Juan.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoPersona extends DaoDBMS {

    @Autowired
    IDatabase db;

    String table = "persone";


    @Override
    public List<Entity> list() {
        List lista = new ArrayList<Entity>();
        String query = "select * from persone inner join status on persone.status_id = status.id";

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
    public Entity load(Entity entity) {

        if(entity.getId()>0 && search(entity.getId())==null){
            String modifiche = caricaMappa(entity.toMap());
            String query = UPDATE.replace("table",table).replace("[id]",entity.getId()+"").replace("?",modifiche);
            if(db.execute(query) == -200)
                return search(entity.getId());
            else return null;
        }
        else
        {
            String chiavi = caricaString(entity.toMap().keySet()).replace("'", "");
            String valori = caricaString(entity.toMap().values());
            String query = CREATE.replace("table", table).replace("chiavi", chiavi).replace("valori",valori);
            return search(db.execute(query));
        }
    }

    @Override
    public boolean delete(int id) {
        String query = DELETE.replace("table", table).replace("[id]",id+"");
        return db.execute(query) == -200;
    }
}
