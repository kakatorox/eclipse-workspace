package cl.desafiolatam.patrones;

import java.util.Scanner;

public class Patrones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner sc = new Scanner(System.in);
		int n = 0;

		System.out.println("Ingrese valor de n:");
		n = sc.nextInt();
		for (i = 0; i < n; i++) {
			if (i % 2 == 0) {
				System.out.print("*");
			} else {
				System.out.print(".");
			}
		}
	}
}