import java.util.List;

public class Usuario {
    private String nombre;
    private List<Pokemon> pokemons;

    public Usuario(String nombre, List<Pokemon> pokemons) {
        this.nombre = nombre;
        this.pokemons = pokemons;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
