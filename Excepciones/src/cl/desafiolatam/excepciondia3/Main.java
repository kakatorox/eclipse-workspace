package cl.desafiolatam.excepciondia3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a, b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("valor a: ");
		a=sc.next();
		
		System.out.println("valor b: ");
		b=sc.next();
		
		System.out.println(excepcionNumeros( a, b));

		
		sc.close();
	}
	
	//@SuppressWarnings("finally")
	public static String excepcionNumeros(String a, String b) {
		String j = "";
		String resultado= "";
		int flag=1;
		try {
			
			 j = String.valueOf(Integer.parseInt(a)/Integer.parseInt(b));
			 					
		}catch(NumberFormatException ex) {
			flag=0;		
			resultado = "Solo se aceptan Números";
			
		}catch(ArithmeticException ar) {
			flag=0;	
			resultado ="Division en Zero no existe";
			
		}finally{
			if(flag==1)
			resultado = "El Resultado es: " + j;
		}
			return resultado;
	}

}
