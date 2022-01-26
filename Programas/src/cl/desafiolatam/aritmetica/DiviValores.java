package cl.desafiolatam.aritmetica;
import java.util.Scanner;
public class DiviValores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double v1;
		double v2;
		Scanner val;
		val=new Scanner(System.in);
		System.out.println("Ingrese Primer Valor");
		
		v1 = val.nextDouble();

			
		System.out.println("Ingrese Segundo Valor");
				
		v2 = val.nextDouble();
		
		if(v2!=0)
		{
			double res = v1/v2;
			
			System.out.printf("La Suma es:%f",res);
		}
		else
		{
			System.out.println("La Division en Cero No existe");
		}
		val.close();
	}

}
