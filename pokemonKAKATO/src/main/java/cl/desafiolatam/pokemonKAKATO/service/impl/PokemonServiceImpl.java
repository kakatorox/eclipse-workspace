package cl.desafiolatam.pokemonKAKATO.service.impl;

import java.util.List;

import cl.desafiolatam.pokemonKAKATO.dao.PokemonDao;
import cl.desafiolatam.pokemonKAKATO.dao.impl.PokemonDaoImpl;
import cl.desafiolatam.pokemonKAKATO.model.Pokedex;
import cl.desafiolatam.pokemonKAKATO.model.Pokemon;
import cl.desafiolatam.pokemonKAKATO.service.PokemonService;

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
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2,int pokedexNumActualizar) {
		// TODO Auto-generated method stub
		pokemonDao.updatePokemon(pokedexNum, nombre, tipo1, tipo2, pokedexNumActualizar);
	}

	@Override
	public void borrarPokemon(int pokedexNum) {
		// TODO Auto-generated method stub
		pokemonDao.borrarPokemon(pokedexNum);
	}

	@Override
	public List<Pokedex> getPokedex() {
		// TODO Auto-generated method stub
		return pokemonDao.getPokedex();
	}
	
}
