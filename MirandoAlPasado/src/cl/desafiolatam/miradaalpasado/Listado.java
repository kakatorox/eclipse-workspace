package cl.desafiolatam.miradaalpasado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Listado {
	private List<String> marcas;
	
	public List<String> primeraParte(){
		
		marcas = new ArrayList<String>();
		
		marcas.add("Polaroid");
		marcas.add("Kodak");
		marcas.add("Napster");
		marcas.add("Cartoon Network");
		marcas.add("Thundercats");
		marcas.add("CCU");
		marcas.add("Budweiser");
		marcas.add("Free");
		marcas.add("MasterCard");
		marcas.add("Pipeño");
		System.out.println("\n");
		for (String sMarca : marcas) {
			System.out.println(sMarca);
		}
		
		return marcas;
	}
	
	public List<String> segundaParte(List<String> agregar){
		for (String string : agregar) {
			marcas.add(string);
		}
		System.out.println("\nNuevo Listado de Marcas\n");
		for (String sMarca : marcas) {
			System.out.println(sMarca);
		}
		
		return marcas;
	}
	
	public List<String> terceraParte(){
		
		marcas.set(marcas.indexOf("Blokbaster"), "BlockBuster");

		System.out.println("\n\nNuevo Listado de Marcas Corregido BlockBuster\n");
		for (String sMarca : marcas) {
			System.out.println(sMarca);
		}
		return marcas;
	}
	
	public List<String> cuartaParte(String valorABorrar){
		
		if (marcas.remove(valorABorrar)) {
			System.out.println("\nMarca Eliminada");
		}
		System.out.println("\n\nNuevo Listado de Marcas Eliminar Carrefour\n");
		for (String sMarca : marcas) {
			System.out.println(sMarca);
		}
		return marcas;
	}
	
	public List<String> quintaParte(){
		
		List<String> posiblesMarcas = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		boolean resp = true;
		int i = 0;
		String d = "";
		while (resp) {			
			
				System.out.println("Desea Agregar una Marca 1)S 2)N");			
				d = sc.next();
			try {
				if (d.equals("1")) {
					System.out.println("Ingrese Marca :");
					posiblesMarcas.add(sc.next());
				} else if(d.equals("2")) {
					resp = false;
				}else {
					System.out.println("Opcion No Valida Reintente");
				}
			}catch(NumberFormatException ex){
				System.out.println("Opcion No Valida Reintente");
			}catch(InputMismatchException err) {
				System.out.println("Opcion No Valida Reintente");
			}			
		}
		
		sc.close();
		marcas.addAll(posiblesMarcas);
		i = 0;
		System.out.println("\nNuevo Listado de Marcas Posibles Marcas\n");
		for (String sMarca : marcas) {
			System.out.println(sMarca);
			i++;
		}

		System.out.println("La Cantidad de Marcas en la lista es :" + i);
		
		return marcas;
	}
}
