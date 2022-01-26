package cl.desafiolatam.ciclos;

import java.util.Scanner;

public class SumaImparLimite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m = 0, res = 0, acu = 0,i=0;
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Ingrese número Inferior:");
		m = sc.nextInt();
		System.out.print("Ingrese número Superior:");
		n = sc.nextInt();

		while (res < n - 1) {

			res = 2 * (i - 3) + 1;
			acu = acu + res;
			i++;
			if (res < n - 1)
				System.out.print(res + "+");
			else
				System.out.print(res);
		}
		System.out.println("\n" + acu);
		
		acu=0;
		res=0;
		for(i=m;i<n;i++) {
			
			if(i%3==0) {
				acu=res+acu;
			}	
		}
		System.out.print(acu);
		sc.close();	
	}
}