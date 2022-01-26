package cl.desafiolatam.patrones;

import java.util.Scanner;

public class CiclosAnidados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		Scanner sc = new Scanner(System.in);
		int n = 0, m = 0;

		System.out.println("Ingrese cantidad de columnas de n:");
		n = sc.nextInt();

		System.out.println("Ingrese cantidad de filas de n:");
		m = sc.nextInt();

		for (j = 0; j < m; j++) {
			for (i = 0; i < n; i++) {
				if (i % 2 == 0) {
					System.out.print("*");
				} else {
					System.out.print(".");
				}
			}
			System.out.print("\n");
		}
	}
}