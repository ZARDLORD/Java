import java.util.Random;

public class Pokemon {
    private int vida;
    private String nombre;
    private int nivel;
    private String tipo;

    public Pokemon(int vida, String nombre, int nivel, String tipo) {
        this.vida = vida;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
    }
    public void RecibirDaño(int daño, int vida, int nombre){
        if (vida>daño){
            vida-=daño;
        }
        else {
            vida=0;
            System.out.println("Se papearon a "+ nombre);
        }
    }
    public int HacerDaño(String tipoA, String tipoD){
        int ataque =0;
        if (tipoA.toLowerCase().equals("fuego")){
            if (tipoD.toLowerCase().equals("agua")){
                ataque = 12;
            }else {
                ataque = 50;
            }
        }
        if (tipoA.toLowerCase().equals("agua")){
            if (tipoD.toLowerCase().equals("planta")){
                ataque = 12;
            }else {
                ataque = 50;
            }
        }
        if (tipoA.toLowerCase().equals("planta")){
            if (tipoD.toLowerCase().equals("fuego")){
                ataque = 12;
            }else {
                ataque = 50;
            }
        }
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
