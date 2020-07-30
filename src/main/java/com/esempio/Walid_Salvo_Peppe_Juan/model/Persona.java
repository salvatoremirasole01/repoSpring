package com.esempio.Walid_Salvo_Peppe_Juan.model;

import com.ant.utility.model.entities.Entity;

public class Persona extends Entity {


    private String nome;
    private String cognome;
    private String date;
    private Status stato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStato() {
        return stato;
    }

    public void setStato(Status stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", date='" + date + '\'' +
                ", stato=" + stato +
                '}';
    }
}
