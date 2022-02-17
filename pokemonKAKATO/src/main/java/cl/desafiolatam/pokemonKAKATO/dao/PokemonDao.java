package cl.desafiolatam.pokemonKAKATO.dao;

import java.util.List;

import cl.desafiolatam.pokemonKAKATO.model.Pokemon;

public interface PokemonDao {
	public List<Pokemon> getPokemones();

	public void crearPokemon(int pokedexNum, String nombre, String tipo1, String tipo2);
	
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2, int pokedexNumActualizar);
	
	public void borrarPokemon(int pokedexNum);
}
