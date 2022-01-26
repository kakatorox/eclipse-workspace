package cl.desafiolatam.holamundo;
import java.util.Scanner;
public class InstruccionIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad;
		Scanner sc;
		System.out.println("Que edad Tienes");
		sc=new Scanner(System.in);
		
		edad = sc.nextInt();
		
		if(edad>=18) {
			System.out.println("Eres Mayor de Edad");
		}		
		
		String a = "texto 4";
		String b = "texto 2";
		
		System.out.println(a==b);
		
		
		
		
		
		sc.close();
	}
}
