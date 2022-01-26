package cl.desafiolatam.metodos;

public class Calculadora {
	int resultado = 0;

	public Calculadora(int a, int b, String oper) {

		if (oper.equalsIgnoreCase("+")) {
			resultado = a + b;
		} else if (oper.equalsIgnoreCase("-")) {
			resultado = a - b;
		} else if (oper.equalsIgnoreCase("/")) {
			resultado = a / b;
		} else if (oper.equalsIgnoreCase("*")) {
			resultado = a * b;
		}
	}
}