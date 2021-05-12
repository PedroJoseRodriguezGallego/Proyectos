package vo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Trabajo 
{
    private int id_trabajo;
    private String descripcion;
    private int horas;
    private double precio;
    private double coste;
    private int reparacionesMecanicas;
    private int reparacionesChapistas;
    private int reparacionesRevisiones;
    private String fechaInicio;
    private String fechaFin;
    private int id_operario;

    public Trabajo(int id_trabajo, String descripcion, int horas, double precio, double coste, int reparacionesMecanicas, int reparacionesChapistas, int reparacionesRevisiones, String fechaInicio, String fechaFin, int id_operario) {
        this.id_trabajo = id_trabajo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.precio = precio;
        this.coste = coste;
        this.reparacionesMecanicas = reparacionesMecanicas;
        this.reparacionesChapistas = reparacionesChapistas;
        this.reparacionesRevisiones = reparacionesRevisiones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id_operario = id_operario;
    }

    public Trabajo() { }

    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getReparacionesMecanicas() {
        return reparacionesMecanicas;
    }

    public void setReparacionesMecanicas(int reparacionesMecanicas) {
        this.reparacionesMecanicas = reparacionesMecanicas;
    }

    public int getReparacionesChapistas() {
        return reparacionesChapistas;
    }

    public void setReparacionesChapistas(int reparacionesChapistas) {
        this.reparacionesChapistas = reparacionesChapistas;
    }

    public int getReparacionesRevisiones() {
        return reparacionesRevisiones;
    }

    public void setReparacionesRevisiones(int reparacionesRevisiones) {
        this.reparacionesRevisiones = reparacionesRevisiones;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId_operario() {
        return id_operario;
    }

    public void setId_operario(int id_operario) {
        this.id_operario = id_operario;
    }
    
    
}