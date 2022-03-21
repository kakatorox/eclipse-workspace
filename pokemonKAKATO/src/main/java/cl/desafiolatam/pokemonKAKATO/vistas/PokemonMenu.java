package cl.desafiolatam.pokemonKAKATO.vistas;

import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.pokemonKAKATO.model.Pokedex;
import cl.desafiolatam.pokemonKAKATO.model.Pokemon;
import cl.desafiolatam.pokemonKAKATO.service.PokemonService;
import cl.desafiolatam.pokemonKAKATO.service.impl.PokemonServiceImpl;

public class PokemonMenu {
	public static Scanner sc = new Scanner(System.in);

	public void menuPrincipal() {
		PokemonAccionesVista pokemonAcciones = new PokemonAccionesVista();
		PokedexAccionesVista pokedexAcciones = new PokedexAccionesVista();
		boolean r = true;
		System.out.println("Bienvenidos a Pueblo Paleta ");
		while (r) {
			int op = 0;
			op = primerMenu(op);
			switch (op) {
			case 1:
				pokemonAcciones.listarPokemon();
				break;
			case 2:
				pokemonAcciones.crearPokemon();
				break;
			case 3:
				pokemonAcciones.editarPokemon();
				break;
			case 4:
				pokemonAcciones.borrarPokemon();
				break;
			case 5:
				pokedexAcciones.listarPokedex();
				break;
			case 6:
				System.out.println("Hasta Pronto Gatchm All!!!!!!");
				r = false;
				break;
			default:
				System.out.println("Ingrese una opcion Correcta");
				break;
			}
		}
	}

	private static int primerMenu(int op) {
		while (op == 0 || (op < 1 && op > 5)) {
			System.out.println("Elija una opcion");
			System.out.println("1.- Ver Todos los Pokemon");
			System.out.println("2.- Crear un Pokemon");
			System.out.println("3.- Editar un Pokemon");
			System.out.println("4.- Borrar un Pokemon");
			System.out.println("5.- Listar Pokedex");
			System.out.println("6.- Salir");

			try {
				op = Integer.parseInt(sc.next());
				if (op < 1 && op > 6) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Sólo se aceptan números del 1 al 6");
				sc = new Scanner(System.in);
			}
		}
		return op;
	}
}
