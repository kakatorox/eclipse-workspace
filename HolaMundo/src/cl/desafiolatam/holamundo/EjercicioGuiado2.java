package cl.desafiolatam.holamundo;

import java.util.Scanner;

public class EjercicioGuiado2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreCompleto;
		String asignatura;
		String nombreDocente;
		String nota1;
		String nota2;
		String nota3;
		Scanner sc;
		String etiqueta;
		sc = new Scanner(System.in);
		
		System.out.print("Nombre Completo:");	
		nombreCompleto = sc.next();

		System.out.print("Asignatura:");
		asignatura = sc.next();
		
		System.out.print("Nombre Docente:");
		nombreDocente = sc.next();
		
		System.out.print("Nota1:");
		nota1 = sc.next();
		
		System.out.print("Nota2:");
		nota2 = sc.next();
		
		System.out.print("Nota3:");
		nota3 = sc.next();
		
		etiqueta = String.format(
				"Nombre del Alumno: %s \n Asigantura %s \n Nombre del Docente: %s \n Nota1:%s \n Nota2:%s \n Nota3: %s \n", 
				nombreCompleto,
				asignatura,
				nombreDocente,
				nota1,
				nota2,
				nota3);

		
		System.out.print(etiqueta);
		sc.close();
	}

}
