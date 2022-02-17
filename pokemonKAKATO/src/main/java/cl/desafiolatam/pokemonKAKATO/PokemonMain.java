package cl.desafiolatam.pokemonKAKATO;

import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.pokemonKAKATO.model.Pokedex;
import cl.desafiolatam.pokemonKAKATO.model.Pokemon;
import cl.desafiolatam.pokemonKAKATO.service.PokemonService;
import cl.desafiolatam.pokemonKAKATO.service.impl.PokemonServiceImpl;

public class PokemonMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean r = true;
		System.out.println("Bienvenidos a Pueblo Paleta ");
		while (r) {
			int op = 0;
			op = primerMenu(op);
			switch (op) {
			case 1:
				listarPokemon();
				break;
			case 2:
				crearPokemon();
				break;
			case 3:
				editarPokemon();
				break;
			case 4:
				borrarPokemon();
				break;
			case 5:
				listarPokedex();
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

	private static void listarPokedex() {
		PokemonService pokemonService = new PokemonServiceImpl(null);
		List<Pokedex> listaPokedex = pokemonService.getPokedex();
		for (Pokedex pokedex : listaPokedex) {
			System.out.println("| ID =" + pokedex.getIdPokedex() + " | " 
									 	+ pokedex.getId_Pokemon() + " | "
									 	+ pokedex.getDate() + " | " 
									 	+ pokedex.getLugar() + " | "
									 	+ pokedex.getHuevo() + " | "
									 	+ pokedex.getPeso() + " | "
									 	+ pokedex.getEstatura() + " | "
									 	+ " |");
		}
	}

	private static void borrarPokemon() {
		PokemonService pokemonService = new PokemonServiceImpl(null);
		System.out.println("Elija un Pokemon por ID de pokemon para Borrar");
		List<Pokemon> listaPokemon = pokemonService.getPokemones();
		for (Pokemon pokemon : listaPokemon) {
			System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
					+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
		}
		System.out.println("Ingrese el ID del Pokemon");
		int pokedexNum = sc.nextInt();
		pokemonService.borrarPokemon(pokedexNum);
		System.out.println(
				"\n\n========================================================================================");
		System.out.println(" Asi quedo la tabla \n \n");

		listaPokemon = pokemonService.getPokemones();
		for (Pokemon pokemon : listaPokemon) {
			System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | "
					+ pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
		}
	}

	private static void editarPokemon() {
		PokemonService pokemonService = new PokemonServiceImpl(null);
		String tipo1 = null;
		String tipo2 = null;
		String nombre = null;
		int pokedexNum = 0, pokedexNumActualizar=0;
		System.out.println("Elija un Pokemon por ID de pokemon para editarlo");
		List<Pokemon> listaPokemon = pokemonService.getPokemones();
		for (Pokemon pokemon : listaPokemon) {
			System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre());
		}
		
		int p1= 0;
		while (p1 == 0 || (p1 < 1 && p1 > 2)) {
			System.out.println("Tiene el ID del Pokemon 1)Si 2)No");
			try {
				p1 = Integer.parseInt(sc.next());
				if (p1 == 1) {
					System.out.println("Ingrese el ID del Pokemon a actualizar");
					pokedexNum = sc.nextInt();
					int p5= 0;
					while (p5 == 0 || (p5 < 1 && p5 > 2)) {
						System.out.println("Desea Actualizar el ID  \n1)Si \n2)No");
						try {
							p5 = Integer.parseInt(sc.next());
							if (p5== 1) {
								System.out.println("Ingrese Nuevo ID");
								pokedexNumActualizar = sc.nextInt();
							}
						} catch (NumberFormatException e) {
							System.out.println("\nPara Editar el ID Ingrese 1 o 2");
							sc = new Scanner(System.in);
						} 
					}
					int p2= 0;
					while (p2 == 0 || (p2 < 1 && p2 > 2)) {
						System.out.println("Desea Editar el Nombre  \n1)Si \n2)No");
						try {
							p2 = Integer.parseInt(sc.next());
							if (p2 == 1) {
								System.out.println("Ingrese Nuevo Nombre");
								nombre = sc.next();
							}
						} catch (NumberFormatException e) {
							System.out.println("\nPara Editar el Nombre Ingrese 1 o 2");
							sc = new Scanner(System.in);
						} 
					}
					int p3= 0;
					while (p3 == 0 || (p3 < 1 && p3 > 2)) {
						System.out.println("Desea Editar el Tipo1  \n1)Si \n2)No");
						try {
							p3 = Integer.parseInt(sc.next());
							if (p3 == 1) {
								System.out.println("Ingrese Nuevo Tipo1");
								tipo1 = sc.next();
							}
						} catch (NumberFormatException e) {
							System.out.println("\nPara Editar el Tipo1 Ingrese 1 o 2");
							sc = new Scanner(System.in);
						}
					}
					int p4= 0;
					while (p4 == 0 || (p4 < 1 && p4 > 2)) {
						System.out.println("Desea Editar el Tipo2  \n1)Si \n2)No");
						try {
							p4 = Integer.parseInt(sc.next());
							if (p4 == 1) {
								System.out.println("Ingrese Nuevo Tipo2");
								tipo2 = sc.next();
							}
						} catch (NumberFormatException e) {
							System.out.println("\nPara Editar el Tipo2 Ingrese 1 o 2");
							sc = new Scanner(System.in);
						}
					}
					
					pokemonService.updatePokemon(pokedexNum, nombre, tipo1, tipo2,pokedexNumActualizar);
					
				}if(p1==2) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Para el ID del Pokemon Ingrese 1 o 2");
				sc = new Scanner(System.in);
			} 
		}
		
		
		
		
		
		
		listaPokemon = pokemonService.getPokemones();
		for (Pokemon pokemon : listaPokemon) {
			System.out.println("| ID =" + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | " + pokemon.getTipo1() + " | " + pokemon.getTipo2() + " |");
		}
	}

	private static void crearPokemon() {
		PokemonService pokemonService = new PokemonServiceImpl(null);
		String tipo1 = null;
		String tipo2 = null;
		System.out.println("Cree un Pokemon");

		System.out.println("Ingrese numero en Pokedex");
		int pokedexNum = sc.nextInt();
		System.out.println("Ingrese Nombre Pokemon:");
		String nombre = sc.next();
		int po = 0;
		while (po == 0 || (po < 1 && po > 2)) {
			System.out.println("Tiene Tipo 1 \n1)Si \n2)No");
			try {
				po = Integer.parseInt(sc.next());
				if (po == 1) {
					System.out.println("Ingrese tipo 1");
					tipo1 = sc.next();
				}
			} catch (NumberFormatException e) {
				System.out.println("Para TIPO 1 Ingrese 1 o 2");
				sc = new Scanner(System.in);
			} 
		}
		int pe = 0;
		while (pe == 0 || (pe < 1 && pe > 2)) {
			System.out.println("Tiene Tipo 2 \n1)Si \n2)No");
			try {
				pe = Integer.parseInt(sc.next());
				if (pe == 1) {
					System.out.println("Ingrese tipo 2");
					tipo2 = sc.next();
				}
			} catch (NumberFormatException e) {
				System.out.println("Para TIPO 2 Ingrese 1 o 2");
				sc = new Scanner(System.in);
			} 
		}
		pokemonService.crearPokemon(pokedexNum, nombre, tipo1, tipo2);
	}

	private static void listarPokemon() {
		PokemonService pokemonService = new PokemonServiceImpl(null);
		List<Pokemon> listaPokemon = pokemonService.getPokemones();
		for (Pokemon pokemon : listaPokemon) {
			System.out.println("| " + pokemon.getPokedex() + " | " + pokemon.getNombre() + " | " + pokemon.getTipo1()
					+ " | " + pokemon.getTipo2() + " |");
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
