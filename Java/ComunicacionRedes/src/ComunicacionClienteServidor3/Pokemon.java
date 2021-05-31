package ComunicacionClienteServidor3;

import java.io.Serializable;

public class Pokemon implements Serializable
{
    private int numeroPokedex;
    private String nombre;
    private TipoElemental elemento;
    private Ataque atq;

    public Pokemon(int numeroPokedex, String nombre, TipoElemental elemento, Ataque atq) {
        this.numeroPokedex = numeroPokedex;
        this.nombre = nombre;
        this.elemento = elemento;
        this.atq = atq;
    }

    public Pokemon() {
    }

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoElemental getElemento() {
        return elemento;
    }

    public void setElemento(TipoElemental elemento) {
        this.elemento = elemento;
    }

    public Ataque getAtq() {
        return atq;
    }

    public void setAtq(Ataque atq) {
        this.atq = atq;
    }
}