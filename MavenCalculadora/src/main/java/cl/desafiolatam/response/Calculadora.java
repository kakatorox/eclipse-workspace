package cl.desafiolatam.response;

public class Calculadora {


		public int a;
		public int b;

		public Calculadora() {
			// TODO Auto-generated constructor stub
			
		}

		public boolean restar(int a, int b) {
			
			int res = 0;
			boolean bRes = false;
			res = a - b;
			if(res<=b ) bRes = true;
			else bRes= false;
			return bRes;
		}

		public int sumar(int a, int b) {

			int res = 0;
			res = a + b;
			return res;
		}

		public int multiplicar(int a, int b) {

			int res = 0;
			res = a * b;
			return res;
		}

		public String dividir(double a, double b) {

			String res = "";
			res = String.valueOf(a / b);
			return res;
		}
	
}
