package cl.desafiolatam.main;

import cl.desafiolatam.response.Calculadora;

public class MainCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculadora cal= new Calculadora();
		cal.restar(2, 3);
		cal.sumar(2, 3);
		cal.multiplicar(2, 3);
		cal.dividir(2, 3);
		
	}

}
