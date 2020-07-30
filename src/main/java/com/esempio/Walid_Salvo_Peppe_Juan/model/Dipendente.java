package com.esempio.Walid_Salvo_Peppe_Juan.model;

public class Dipendente extends Persona{
    private String mansione;
    private int stipendio;


    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "mansione='" + mansione + '\'' +
                ", stipendio=" + stipendio +
                '}';
    }
}
