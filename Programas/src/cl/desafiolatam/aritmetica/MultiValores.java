package cl.desafiolatam.aritmetica;
import java.util.Scanner;
public class MultiValores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double v1;
		double v2;
		Scanner val1=new Scanner(System.in);	
		System.out.println("Ingrese Primer Valor");
		
		v1 = val1.nextDouble();
		
		System.out.println("Ingrese Segundo Valor");
		
		v2 = val1.nextDouble();
		
		double res = v1*v2;
		
		System.out.printf("La Suma es:%f",res);
		val1.close();
	}

}
