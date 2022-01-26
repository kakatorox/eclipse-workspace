package cl.desafiolatam.resistencia;
import java.util.Scanner;
public class Resistencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float r1,r2,r3,rt;
		boolean fin = true;
		Scanner sc;
	do {	
		do{
			System.out.println("Ingrese Valor Resistencia 1:");
			sc=new Scanner(System.in);
			r1=sc.nextFloat();
		}while(r1<=0);
		
		do{
			System.out.println("Ingrese Valor Resistencia 2:");
			sc=new Scanner(System.in);
			r2=sc.nextFloat();
		}while(r2<=0);	
		
		do{
			System.out.println("Ingrese Valor Resistencia 3:");
			sc=new Scanner(System.in);
			r3=sc.nextFloat();
		}while(r3<=0);
		
							
			rt=1/((1/r1)+(1/r2)+(1/r3));
							
			System.out.printf("La Resistencia Total es de:%.1f",rt);
			
			System.out.println("Desea Calcular otra Resistencia");
			System.out.println("1: Si, 2: No");
			
			if(sc.nextInt()==2) 
			{
				fin= false;
				sc.close();
			}			
			
	}while(fin);
	
	}
}