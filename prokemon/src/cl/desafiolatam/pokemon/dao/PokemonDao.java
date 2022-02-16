package cl.desafiolatam.pokemon.dao;

import java.util.List;

import cl.desafiolatam.pokemon.model.Pokemon;

public interface PokemonDao {
	public List<Pokemon> getPokemones();

	public void crearPokemon(int pokedexNum, String nombre, String tipo1, String tipo2);
	
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2);
	
	public void borrarPokemon(int pokedexNum);
}
