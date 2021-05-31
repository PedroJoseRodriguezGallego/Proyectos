package ComunicacionClienteServidor2;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Curso implements Serializable
{
    String id;
    String descripcion;

    public Curso() { }

    public Curso(String fid, String fdescripcion)
    {
        id = fid;
        descripcion = fdescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId() {
        return id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }
}