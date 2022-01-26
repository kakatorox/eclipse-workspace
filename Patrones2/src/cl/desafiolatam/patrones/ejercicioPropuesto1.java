package cl.desafiolatam.patrones;

import java.util.Scanner;

public class ejercicioPropuesto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		Scanner sc = new Scanner(System.in);
		int n = 0, m = 0;
		System.out.println("Ingrese cantidad de columnas de n:");
		n = sc.nextInt();
		for (j = 1; j <= n; j++) {
			for (i = 1; i <= j; i++) {
					System.out.print(i);
					}
				System.out.print("\n");
			}
	}
}