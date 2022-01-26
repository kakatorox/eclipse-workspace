package cl.desafiolatam.holamundo;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float area;
		float perimetro;
		float alto;
		float largo;
		Scanner sc;
		sc=new Scanner(System.in);
		System.out.print("Ingrese el Alto:");
		
		alto = sc.nextFloat();
		
		System.out.print("Ingrese el Largo:");
		largo = sc.nextFloat();
		
		perimetro=alto*largo;
		area=2*(alto*largo);
		sc.close();
		
		System.out.printf("El Area del Rectangulo es: %f \n El Perimetro del Rectangulo es %f",area,perimetro);
	}

}
