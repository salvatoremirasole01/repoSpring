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
        //"INSERT INTO Orders (id, userid, timestamp) \n" +
        //"SELECT Orders.id, Orders.userid, Orders.timestamp FROM Users INNER JOIN Orders ON  Orders.id = Users.id"

        String queryInsert = "c";

        return null;
    }

    @Override
    public boolean delete(int i) {
        return false;
    }
}
