package cl.desafiolatam.pokemonKAKATO.vistas;

import java.util.List;

import cl.desafiolatam.pokemonKAKATO.model.Pokedex;
import cl.desafiolatam.pokemonKAKATO.service.PokemonService;
import cl.desafiolatam.pokemonKAKATO.service.impl.PokemonServiceImpl;

public class PokedexAccionesVista {
	public void listarPokedex() {
		PokemonService pokemonService = new PokemonServiceImpl();
		List<Pokedex> listaPokedex = pokemonService.getPokedex();
		for (Pokedex pokedex : listaPokedex) {
			System.out.println("| ID =" + pokedex.getIdPokedex() + " | " + pokedex.getId_Pokemon() + " | "
					+ pokedex.getDate() + " | " + pokedex.getLugar() + " | " + pokedex.getHuevo() + " | "
					+ pokedex.getPeso() + " | " + pokedex.getEstatura() + " | " + " |");
		}
	}
}
