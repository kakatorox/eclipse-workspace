package cl.desafiolatam.miradaalpasado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Seteo {
	
	private Set<String> invitados;
	
	
	
	public void primeraParte(){
		
		Utilidad.tEspera(2);	
		System.out.println("\n\n/////////////////////////////");
		System.out.println("Ejercicio 2");
		System.out.println("/////////////////////////////");
		invitados = new TreeSet<>();

		invitados.add("Daniel");
		invitados.add("Paola");
		invitados.add("Facundo");
		invitados.add("Pedro");
		invitados.add("Jacinta");
		invitados.add("Florencia");
		invitados.add("Juan Pablo");				
	}
	
	public void segundaParte(String invi1,String invi2, String invi3){
		
		Set<String> posiblesInvitados = new HashSet<>(Arrays.asList(invi1, invi2, invi3));

		invitados.addAll(posiblesInvitados);
		
		System.out.println("Nuevo Listado de invitados");
		for (String string : invitados) {
			System.out.println(string);
		}
	}
	
	public void terceraParte(String borrar) {
		invitados.remove(borrar);
		for (String string : invitados) {
			System.out.println(string);
		}
	}
}
