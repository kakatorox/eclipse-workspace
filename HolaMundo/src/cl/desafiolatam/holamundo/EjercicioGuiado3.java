package cl.desafiolatam.holamundo;

import java.util.Scanner;

public class EjercicioGuiado3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float distancia;
		float tiempo;
		float velocidad;
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("Distancia:");
		distancia = sc.nextFloat();

		System.out.print("Tiempo:");
		tiempo = sc.nextFloat();
		
		velocidad=distancia/tiempo;
		
		System.out.printf("La Velocidad es :%f km/h",velocidad);
		sc.close();
	}

}
