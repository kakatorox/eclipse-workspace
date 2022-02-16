package cl.desafiolatam.pokemon.service.impl;

import java.util.List;

import cl.desafiolatam.pokemon.dao.PokemonDao;
import cl.desafiolatam.pokemon.dao.impl.PokemonDaoImpl;
import cl.desafiolatam.pokemon.model.Pokemon;
import cl.desafiolatam.pokemon.service.PokemonService;

public class PokemonServiceImpl implements PokemonService{

	PokemonDao pokemonDao = null;

	public PokemonServiceImpl(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = new PokemonDaoImpl();
	}

	@Override
	public List<Pokemon> getPokemones() {
		// TODO Auto-generated method stub
		return pokemonDao.getPokemones();
	}

	@Override
	public void crearPokemon(int pokedexNum, String nombre, String tipo1, String tipo2) {
		// TODO Auto-generated method stub
		pokemonDao.crearPokemon(pokedexNum,nombre,tipo1,tipo2);
	}

	@Override
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2) {
		// TODO Auto-generated method stub
		pokemonDao.updatePokemon(pokedexNum, nombre, tipo1, tipo2);
	}

	@Override
	public void borrarPokemon(int pokedexNum) {
		// TODO Auto-generated method stub
		pokemonDao.borrarPokemon(pokedexNum);
	}
	
}
