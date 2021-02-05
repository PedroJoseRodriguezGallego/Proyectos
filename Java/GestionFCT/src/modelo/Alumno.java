package modelo;

/* Creamos una clase Alumno serializable para poder ir introduciendo como Objetos cada uno de
los alumnos que estén en el archivo .dat para pasarlos posteriormente a tablas.*/

public class Alumno implements java.io.Serializable{
    public int codigoAlumno;
    public String DNI;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;

}