package cl.desafiolatam.pokemon;

import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.pokemon.model.Pokemon;
import cl.desafiolatam.pokemon.service.PokemonService;
import cl.desafiolatam.pokemon.service.impl.PokemonServiceImpl;

public class PokemonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokemonService pokemonService = new PokemonServiceImpl(null);
		Scanner sc = new Scanner(System.in);
		int op;

		System.out.println("Bienvenidos a Pueblo Paleta ");
		System.out.println("Elija una opcion");
		System.out.println("1.- Ver Todos los Pokemon");
		System.out.println("2.- Crear un Pokemon");
		System.out.println("3.- Editar un Pokemon");
		System.out.println("4.- Borrar un Pokemon");
		op = sc.nextInt();
		switch (op) {
		case 1:
			List<Pokemon> listaPokemon = pokemonService.getPokemones();
			for (Pokemon pokemon : listaPokemon) {
				System.out.println("| " + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
						+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
			}
			break;
		case 2:
			System.out.println("Cree un Pokemon");
			System.out.println("Ingrese numero en Pokedex");
			int pokedexNum = sc.nextInt();
			System.out.println("Ingrese Nombre Pokemon:");
			String nombre = sc.next();
			System.out.println("Ingrese tipo 1");
			String tipo1 = sc.next();
			System.out.println("Ingrese tipo 2");
			String tipo2 = sc.next();
			pokemonService.crearPokemon(pokedexNum, nombre, tipo1, tipo2);
			pokedexNum = 0;
			nombre = null;
			tipo1 = null;
			tipo2 = null;
			break;
		case 3:
			System.out.println("Elija un Pokemon por ID de pokemon para editarlo");
			listaPokemon = pokemonService.getPokemones();
			for (Pokemon pokemon : listaPokemon) {
				System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
						+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
			}
			System.out.println("Si no desea alterar los campos favor de dejar en blanco");
			System.out.println("Ingrese el ID del Pokemon");
			pokedexNum = sc.nextInt();
			System.out.println("Nombre:");
			nombre = sc.next();
			System.out.println("Tipo1:");
			tipo1 = sc.next();
			System.out.println("Tipo2:");
			tipo2 = sc.next();
			pokemonService.updatePokemon(pokedexNum, nombre, tipo1, tipo2);
			listaPokemon = pokemonService.getPokemones();
			for (Pokemon pokemon : listaPokemon) {
				System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
						+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
			}
			pokedexNum = 0;
			nombre = null;
			tipo1 = null;
			tipo2 = null;
			break;
		case 4:
			System.out.println("Elija un Pokemon por ID de pokemon para Borrar");
			listaPokemon = pokemonService.getPokemones();
			for (Pokemon pokemon : listaPokemon) {
				System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
						+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
			}
			System.out.println("Ingrese el ID del Pokemon");
			pokedexNum = sc.nextInt();
			pokemonService.borrarPokemon(pokedexNum);
			System.out.println(
					"\n\n========================================================================================");
			System.out.println(" Asi quedo la tabla \n \n");

			listaPokemon = pokemonService.getPokemones();
			for (Pokemon pokemon : listaPokemon) {
				System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
						+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
			}
			pokedexNum = 0;
			break;

		default:

			break;
		}
	}
}
