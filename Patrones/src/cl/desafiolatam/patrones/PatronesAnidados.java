package cl.desafiolatam.patrones;
import java.util.Scanner;
public class PatronesAnidados {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido");
		System.out.print("Ingresar valor de n para Patrones :");
		n = sc.nextInt();
		System.out.println("Patron 1");
		patronUno(n);//listo
		System.out.println("Patron 2");
		patronDos(n);//listo
		System.out.println("Patron 3");
		patronTres(n);//listo
		System.out.println("Patron 4");
		patronCuatro(n);//listo
		sc.close();
	}
	
	static void patronUno(int n) {

		int i, j;

		for (i = 1; i <= n; i++) {

			for (j = 1; j <= n; j++) {
				if (i == 1 || j == 1) {
					System.out.print("*");
				} else if (i == n || j == n) {
					System.out.print("*");
				} else if (j > 1 && j < n) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void patronDos(int n) {

		int i, j, verF;
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				if (i == 1) {
					System.out.print("*");
				} else if (i == n) {
					System.out.print("*");
				} else if (j > 1 && j < n) {
					verF = i + j;
					if (verF == n + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void patronTres(int n) {
		int i, j, verF;
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				if (j >= 1 && j <= n) {
					verF = i + j;
					if (verF == n + 1 || i == j) {
						System.out.print("X");
					}
					else {
						System.out.print(" ");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void patronCuatro(int n) {

		int i, j;

		for (i = 1; i <= n; i++) {

			for (j = 1; j <= n; j++) {
				if (i == 1) {
					if (j == n) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				} else if (i == n) {
					if (j == 1) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				} else if (j == 1) {
					System.out.print(" ");
				} else if (j > 1 && j < n) {
					System.out.print("*");

				}
			}
			System.out.println();
		}
	}

}
