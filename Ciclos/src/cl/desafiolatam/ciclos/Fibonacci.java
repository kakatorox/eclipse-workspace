package cl.desafiolatam.ciclos;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i = 0, a = 0, b = 1, acu = 0;
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Ingrese cantidad de número que desea visualizar:");
		n = sc.nextInt();
		sc.close();

		for (i = 0; i <= n; i++) {
			if (i > 1) {
				acu = a + b;
				System.out.println(acu);
				a = b;
				b = acu;
			} else if (i == 1) {
				System.out.println(1);
			} else if (i == 0) {
				System.out.println(0);
			}
		}
	}
}