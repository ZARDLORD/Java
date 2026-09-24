package org.prueba.miapi;

public class Personaje {
    private Integer ID;
    private String nombre,especie,estado,origen;

    public Personaje(){}

    public Personaje(Integer id, String nombre, String especie, String estado,String origen){
        this.ID=id;
        this.nombre=nombre;
        this.especie=especie;
        this.estado=estado;
        this.origen=origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}