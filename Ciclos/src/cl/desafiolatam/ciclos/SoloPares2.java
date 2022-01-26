package cl.desafiolatam.ciclos;

import java.util.Scanner;

public class SoloPares2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i = 1, res;
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Ingrese La cantidad n de numeros pares que desea ver:");
		n = sc.nextInt();

		while (i <= n) {
			res = 2 * i;
			System.out.println(res);
			i++;
		}
		sc.close();
	}
}