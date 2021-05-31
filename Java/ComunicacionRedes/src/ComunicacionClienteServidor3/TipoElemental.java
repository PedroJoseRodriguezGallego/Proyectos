package ComunicacionClienteServidor3;

import java.io.Serializable;

public class TipoElemental implements Serializable
{
    private String elemento;
    private String debilidad;

    public TipoElemental(String elemento, String debilidad)
    {
        this.elemento = elemento;
        this.debilidad = debilidad;
    }

    public TipoElemental()
    {

    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }
}