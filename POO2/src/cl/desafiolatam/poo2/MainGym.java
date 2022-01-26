package cl.desafiolatam.poo2;

import java.util.ArrayList;

public class MainGym {

	public static void main(String[] args) {
		
		ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		ArrayList<Profesor> listaProfesors = new ArrayList<Profesor>();
		
		listaEstudiantes.add(new Estudiante("1","Juan",true));
		listaEstudiantes.add(new Estudiante("2","Andrés",true));
		listaEstudiantes.add(new Estudiante("3","Juan",false));
		listaProfesors.add(new Profesor("10", "Jose", true));
		
		for (Profesor profesor : listaProfesors) {
			System.out.println(profesor.toString());
		}
		
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println(estudiante.toString());
		}
		System.out.println("\n");
		ArrayList<Persona> lista = new ArrayList<Persona>();
		
		lista.add(new Estudiante(2500,"1","Juan",true));
		lista.add(new Estudiante(3000,"2","Andrés",true));
		lista.add(new Estudiante(3500,"3","Juan",false));
		lista.add(new Profesor(3.21f,"10","Jose",true));
		lista.add(new Profesor(4.32f,"10","Arnaldo",true));
		
		for (Persona individuo : lista) {
			System.out.println(individuo.getClass().getSimpleName());
			System.out.println(individuo.toString()); 
			if(individuo.getClass().getSimpleName().equals("Estudiante")) { 
				Estudiante estudiante = (Estudiante) individuo;
				System.out.println("Deuda : " + estudiante.getDeuda());
			}
			if(individuo.getClass().getSimpleName().equals("Profesor")) {
				Profesor profe = (Profesor) individuo;
				System.out.println("Sueldo : " + profe.getSueldo());
			}
		}
	}
}
