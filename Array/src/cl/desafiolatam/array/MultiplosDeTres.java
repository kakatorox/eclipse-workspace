package cl.desafiolatam.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MultiplosDeTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> vis = new ArrayList<Integer>();
		System.out.println("Bienvenido");
		vis.add(10); 
		vis.add(20);
		vis.add(30); 
		vis.add(33); 
		vis.add(21); 
		vis.add(8);
		vis.add(2);
		vis.add(61);
		sc.close();
		System.out.println(vis);
		System.out.println("    Suma :"+suma(vis).get(0));
		System.out.println("Promedio :"+suma(vis).get(1));
		
		String number = "pato";

		 System.out.println(someFunc(number));

	}
	

	public static String someFunc(String number) {
	  String newNumber = "";
	  for (int i = number.length()-1; 0 <= i; i--) {
			  newNumber += number.charAt(i);
		}
	  return newNumber;
	}
	
	static ArrayList<Integer> suma(ArrayList<Integer> vis) {
		int i,acu = 0,cont=0,prom=0;		
		for(i=0;i<vis.size();i++) {			
			if(vis.get(i)%3==0) {				
				acu=acu+vis.get(i);
				cont++;
			}			
		}		
		prom = acu/cont;
		ArrayList<Integer> resultado=new ArrayList<Integer>();
		resultado.add(acu);
		resultado.add(prom);
		return resultado;
	}
	
}
