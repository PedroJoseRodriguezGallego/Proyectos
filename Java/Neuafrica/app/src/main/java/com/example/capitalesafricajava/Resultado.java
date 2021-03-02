package com.example.capitalesafricajava;

import java.io.Serializable;

public class Resultado implements Serializable
{
    private int intentos;
    private int aciertos;
    private int fallos;

    public Resultado(int intentos, int aciertos, int fallos) {
        this.intentos = intentos;
        this.aciertos = aciertos;
        this.fallos = fallos;
    }

    public Resultado() {
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
}