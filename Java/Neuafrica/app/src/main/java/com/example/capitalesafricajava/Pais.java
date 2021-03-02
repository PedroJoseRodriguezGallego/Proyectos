package com.example.capitalesafricajava;

public class Pais
{
    private int id;
    private String pais;
    private String capital;

    public Pais(int id, String pais, String capital) {
        this.id = id;
        this.pais = pais;
        this.capital = capital;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
