package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "alimentos")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int aportaEnergia;
    private int aportaFelicidad;
    private int aportaSuciedad; // Comer puede ensuciar al Pou
    private int restaHambre;    // Cuántos puntos de hambre quita

    public Alimento(){}
    public Alimento(String nombre, int aportaEnergia, int aportaFelicidad, int aportaSuciedad, int restaHambre) {
        this.id = id;
        this.nombre = nombre;
        this.aportaEnergia = aportaEnergia;
        this.aportaFelicidad = aportaFelicidad;
        this.aportaSuciedad = aportaSuciedad;
        this.restaHambre = restaHambre;
    }
    // Getters y Setters obligatorios para el ORM
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAportaEnergia() { return aportaEnergia; }
    public void setAportaEnergia(int aportaEnergia) { this.aportaEnergia = aportaEnergia; }

    public int getAportaFelicidad() { return aportaFelicidad; }
    public void setAportaFelicidad(int aportaFelicidad) { this.aportaFelicidad = aportaFelicidad; }

    public int getAportaSuciedad() { return aportaSuciedad; }
    public void setAportaSuciedad(int aportaSuciedad) { this.aportaSuciedad = aportaSuciedad; }

    public int getRestaHambre() { return restaHambre; }
    public void setRestaHambre(int restaHambre) { this.restaHambre = restaHambre; }
}
