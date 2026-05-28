package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "pou")
public class Pou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int hambre;     // 0 = lleno, 100 = famélico (o al revés, como prefieras manejarlo)
    private int felicidad;  // 0 a 100
    private int suciedad;   // 0 a 100
    private int energia;    // 0 a 100 (la pide el menú para dormir/jugar)

    // Constructor vacío obligatorio para Hibernate
    public Pou() {}

    // Constructor para iniciar un Pou nuevo
    public Pou(String nombre) {
        this.nombre = nombre;
        this.hambre = 50;      // Inicia a mitad de camino
        this.felicidad = 50;
        this.suciedad = 0;      // Inicia limpio
        this.energia = 100;     // Inicia bien despierto
    }

    // Métodos lógicos para limitar los estados entre 0 y 100
    public void verificarLimites() {
        if (this.hambre < 0) this.hambre = 0;
        if (this.hambre > 100) this.hambre = 100;
        if (this.felicidad < 0) this.felicidad = 0;
        if (this.felicidad > 100) this.felicidad = 100;
        if (this.suciedad < 0) this.suciedad = 0;
        if (this.suciedad > 100) this.suciedad = 100;
        if (this.energia < 0) this.energia = 0;
        if (this.energia > 100) this.energia = 100;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getHambre() { return hambre; }
    public void setHambre(int hambre) { this.hambre = hambre; }

    public int getFelicidad() { return felicidad; }
    public void setFelicidad(int felicidad) { this.felicidad = felicidad; }

    public int getSuciedad() { return suciedad; }
    public void setSuciedad(int suciedad) { this.suciedad = suciedad; }

    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
}
