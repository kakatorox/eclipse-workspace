package cl.desafiolatam.patrones;

import java.util.Scanner;

public class Patrones {
	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		sc = new Scanner(System.in);

		System.out.println("Bienvenido");
		System.out.print("Ingresar valor de n para Patron 1");
		n = sc.nextInt();
		patronUno(n);

		System.out.print("\n \nIngresar valor de n para Patron 2");
		n = sc.nextInt();
		patronDos(n);

		System.out.print("\n \nIngresar valor de n para Patron 3");
		n = sc.nextInt();
		patronTres(n);

		sc.close();
	}

	static void patronUno(int n) {
		int i;
		for (i = 1; i <= n; i++) {
			if (i % 2 == 0)
				System.out.print(".");
			else
				System.out.print("*");
		}
	}

	static void patronDos(int n) {
		int i, j=0;
		for (i = 0; i < n; i++) {
			j++;
			if(j<=4) {
				System.out.print(j);
			}else{
				j=1;
				System.out.print(j);
			}
		}
	}

	static void patronTres(int n) {
		int i;
		for (i = 1; i <= n; i++) {
			if (i % 3 == 0)
				System.out.print("*");
			else
				System.out.print("|");
		}
	}
}
