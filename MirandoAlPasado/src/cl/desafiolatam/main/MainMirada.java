package cl.desafiolatam.main;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.miradaalpasado.Cola;
import cl.desafiolatam.miradaalpasado.Listado;
import cl.desafiolatam.miradaalpasado.Mapa;
import cl.desafiolatam.miradaalpasado.Seteo;

public class MainMirada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//////////////////////////////////////////////////
		// Comienzo Ejercicio 1
		//////////////////////////////////////////////////
		System.out.println("/////////////////////////////");
		System.out.println("/////     Bienvenido    /////");
		System.out.println("/////////////////////////////");
		System.out.println("Ejercicio 1");
		Listado listado = new Listado();
		listado.primeraParte();
		List<String> agregar = new ArrayList<String>();
		agregar.add("Blokbaster");
		agregar.add("Carrefour");
		agregar.add("Jetix");
		listado.segundaParte(agregar);
		listado.terceraParte();
		listado.cuartaParte("Carrefour");
		listado.quintaParte();
		//////////////////////////////////////////////////
		// Comienzo Ejercicio 2
		//////////////////////////////////////////////////
		Seteo seteo = new Seteo();
		seteo.primeraParte();
		seteo.segundaParte("Jorge", "Francisco", "Marcos");
		seteo.terceraParte("Jorge");
		//////////////////////////////////////////////////
		// Comienzo Ejercicio 3
		//////////////////////////////////////////////////
		
		Mapa mapa = new Mapa();
		mapa.primeraParte();
		mapa.segundaParte();
		//////////////////////////////////////////////////
		// Comienzo Ejercicio 4
		//////////////////////////////////////////////////
		
		Cola cola = new Cola();
		cola.primareParte();
		cola.segundaParte();
	}

}
