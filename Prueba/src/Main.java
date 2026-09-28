import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Pokemon> pokemons = new ArrayList<>();
    static List<Pokemon> pokemons2 = new ArrayList<>();

    public static void main(String[] args) {
        pokemons.add(new Pokemon(100,"char",1,"fuego"));
        pokemons2.add(new Pokemon(100,"elazul",1,"agua"));

    }
}