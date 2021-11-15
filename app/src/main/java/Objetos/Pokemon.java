package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Pokemon {

    private int id;
    private String[] pokemon = {"Pikachu","Rapidash","Lucario","Tauros","Togepi","Gengar"};
    private int[] kilometros = {3000, 5000, 2000, 1500, 500, 1000};
    private int cantidad;

    public Pokemon()
    {}

    public Pokemon(int id, String[] pokemon, int[] kilometros, int cantidad) {
        this.id = id;
        this.pokemon = pokemon;
        this.kilometros = kilometros;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getPokemon() {
        return pokemon;
    }

    public void setPokemon(String[] pokemon) {
        this.pokemon = pokemon;
    }

    public int[] getKilometros() {
        return kilometros;
    }

    public void setKilometros(int[] kilometros) {
        this.kilometros = kilometros;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon1 = (Pokemon) o;
        return id == pokemon1.id && cantidad == pokemon1.cantidad && Arrays.equals(pokemon, pokemon1.pokemon) && Arrays.equals(kilometros, pokemon1.kilometros);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, cantidad);
        result = 31 * result + Arrays.hashCode(pokemon);
        result = 31 * result + Arrays.hashCode(kilometros);
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", pokemon=" + Arrays.toString(pokemon) +
                ", kilometros=" + Arrays.toString(kilometros) +
                ", cantidad=" + cantidad +
                '}';
    }

    public int anadirAdicional(int valor, int adicional)
    {
        return valor + adicional;
    }
}
