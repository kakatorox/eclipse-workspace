package cl.desafiolatam.holamundo;

import java.util.Scanner;

public class Hipotenusa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float catetoA;
		float catetoB;
		float hipotenusa;
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("Ingrese Cateto A:");
	
		catetoA = sc.nextFloat();
		
		System.out.print("Ingrese Cateto B:");
		
		catetoB = sc.nextFloat();
		
		hipotenusa=(float)(Math.sqrt((Math.pow(catetoA,2)*Math.pow(catetoB,2))));
		
		
		System.out.printf("La Hipotenusa %f",hipotenusa);
		sc.close();
	}

}
