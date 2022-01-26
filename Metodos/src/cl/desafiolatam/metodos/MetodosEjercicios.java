package cl.desafiolatam.metodos;

import java.util.Scanner;

public class MetodosEjercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int op, a, b;
		boolean res = true;
		String operAr;

		while (res) {
			System.out.println("Que Desea Hacer \n 1)Calculadora \n 2)Bomba");
			op = sc.nextInt();
			if (op == 1) {
				System.out.println("Ingrese Numero 1");
				a = sc.nextInt();
				System.out.println("Ingrese operacion aritmetica");
				operAr = sc.next();
				System.out.println("Ingrese Numero 2");
				b = sc.nextInt();
				System.out.println(calc(a, b, operAr));

			} else {
				System.out.println("Has Activado la Bomba de Tiempo");
				System.out.println("Ingrese milisegundos(x000)");
				a = sc.nextInt();
				actiBomb(a);
			}

			System.out.println("Desea Hacer algo mas \n 1)Si \n 2)No");
			op = sc.nextInt();
			if (op == 1)
				res = true;
			else
				res = false;
		}
		System.out.println("Hasta Luego");
	}

	public static int calc(int a, int b, String oper) {
		int resultado = 0;
		Calculadora cal = new Calculadora(a, b, oper);
		resultado = cal.resultado;
		return resultado;
	}

	private static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void actiBomb(int segundos) {

		Bomba_Splash deadEnd = new Bomba_Splash();

		/*delay(segundos);
		deadEnd.diez();
		delay(segundos);
		deadEnd.nueve();
		delay(segundos);
		deadEnd.ocho();
		delay(segundos);
		deadEnd.siete();
		delay(segundos);
		deadEnd.seis();
		delay(segundos);
		deadEnd.cinco();
		delay(segundos);
		deadEnd.cuatro();
		delay(segundos);
		deadEnd.tres();
		delay(segundos);
		deadEnd.dos();
		delay(segundos);*/
		deadEnd.uno();
		delay(segundos);
		deadEnd.splash();
	}
	//System.out.print("\033[H\033[2J");  
    //System.out.flush();
}
