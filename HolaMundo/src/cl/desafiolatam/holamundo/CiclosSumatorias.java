package cl.desafiolatam.holamundo;
import java.util.Scanner;
public class CiclosSumatorias {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numP,numS,calT = 0;
		String opAr,resp="s";
		Scanner sc;		
		sc=new Scanner(System.in);
		
		while(resp.equalsIgnoreCase("s")) {	
			
			System.out.print("Ingrese el Primer Número:");		
			numP = sc.nextInt();
			System.out.print("Ingrese operador aritmetico:");		
			opAr = sc.next();
			System.out.print("Ingrese el Segundo Número:");		
			numS = sc.nextInt();
			
				try {
					if(opAr.equals("+")){
						calT=numP + numS;	
					}else if (opAr.equals("-")) {
						calT=numP - numS;	
					}else if (opAr.equals("*")||opAr.equalsIgnoreCase("x")) {
						calT=(numP * numS);	
					}else if (opAr.equals("/")||opAr.equals(":")) {
						calT= (numP / numS);
					}
					System.out.printf("El Calculo es: %s \n",calT);			
					
				}catch(ArithmeticException ex){ 
					System.out.print("nose puede dividir en los Enteros\n");
					System.out.print(ex.getMessage());					
				}
				System.out.print("\nDesea Seguir SI(s) NO(n)");		
				resp=sc.next();	
		}		
		sc.close();
	}
}