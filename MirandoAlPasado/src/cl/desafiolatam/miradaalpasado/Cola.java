package cl.desafiolatam.miradaalpasado;

import java.util.LinkedList;
import java.util.Queue;


public class Cola {
	
	private Queue<String> juegos;
	
	public Queue<String> primareParte() {
	
	Utilidad.tEspera(2);
	System.out.println("\n\n/////////////////////////////");
	System.out.println("Ejercicio 4");	
	System.out.println("/////////////////////////////");	
	juegos = new LinkedList<String>();

	juegos.add("Tombo");
	juegos.add("Congelado");
	juegos.add("Quemaditas");
	juegos.add("Cachipún");
	juegos.add("Pillarse");				
	
	return juegos;
	}
	
	public void segundaParte(){
		
	for (String string : juegos) {
		System.out.println(string);
	}
	
	System.out.println("La cantidad de juegos son : "+ juegos.size());
	
	
	}
}
