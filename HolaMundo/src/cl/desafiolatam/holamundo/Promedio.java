package cl.desafiolatam.holamundo;

import java.util.Scanner;

public class Promedio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float n1,n2,n3,nF;
		Scanner sc;
		sc=new Scanner(System.in);
		
		System.out.println("Ingrese Nota1");
		
		n1=sc.nextFloat();
		
		System.out.println("Ingrese Nota2");

		n2=sc.nextFloat();
		
		System.out.println("Ingrese Nota3");

		n3=sc.nextFloat();
		
		nF= (n1+n2+n3)/3;
		
		if(nF<4) {
			System.out.println("Reprobaste");			
		}
		else {
			System.out.println("Aprobaste");
		}
		sc.close();
		
	}
}