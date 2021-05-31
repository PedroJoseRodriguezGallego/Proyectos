package ComunicacionClienteServidor2;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Alumno implements Serializable
{
    String idAlumno;
    String nombre;
    Curso curso;
    int nota;

    public Alumno(){

    }

    public Alumno(String fidAlumno, String fnombre, Curso fcurso, int fnota)
    {
        idAlumno = fidAlumno;
        nombre = fnombre;
        curso = fcurso;
        nota = fnota;
    }

    public Curso getCurso() {
        return curso;
    }

    public int getNota() {
        return nota;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}