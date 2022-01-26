package cl.desafiolatam.ciclos;

import java.util.Scanner;

public class SumaImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n, i = 0, res = 0, acu = 0;
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Ingrese La cantidad n de numeros impares que desea ver:");
		n = sc.nextInt();

		while (acu < n) {
			res = 2 * i + 1;
			acu = acu + res;
			i++;
			if (acu < n)
				System.out.print(res + "+");
			else
				System.out.print(res);
		}
		System.out.println("\n" + acu);
		sc.close();
	}
}