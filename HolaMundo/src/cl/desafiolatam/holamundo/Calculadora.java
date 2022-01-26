package cl.desafiolatam.holamundo;
import java.util.Scanner;
public class Calculadora {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPri,numSec,calTot = 0;
		int eleccion=0;
		int proArit=0;
		Scanner sc;		
		sc=new Scanner(System.in);
		do {
			System.out.print("Ingrese el Primer Número:");		
			numPri = sc.nextInt();
			
			System.out.print("Ingrese el Segundo Número:");
			numSec = sc.nextInt();
			
			System.out.print("Ingrese proceso aritmetico:"
					+ "\n1.- Suma"
					+ "\n2.- Resta"
					+ "\n3.- Multiplicación"
					+ "\n4.- División\n");			
			proArit = sc.nextInt();
			try {
					if(proArit==1) 
							calTot=numPri+numSec;
					if(proArit==2)
							calTot=numPri-numSec;
					if(proArit==3) 
							calTot=numPri*numSec;
					if(proArit==4) 	
							calTot=numPri/numSec;								

					System.out.printf("El Calculo es: %f \n",calTot);
				}
			catch(ArithmeticException ex){ 
				System.out.print("nose puede dividir en los Enteros\n");
				System.out.print(ex.getMessage());					
			}				
			System.out.print("Desea repetir Si(1) o No(2) :");
			eleccion = sc.nextInt();
			
		}while(eleccion == 1);		
		sc.close();
		/*int i =0;
		int suma=0;
		while(i<5) {
			i+=1;
			System.out.printf("El i: %s \n",i);
			suma += i;
			System.out.printf("El suma: %s \n",suma);
		}*/
	}
}