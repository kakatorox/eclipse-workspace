package cl.desafiolatam.ciclos;

public class CambiarWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		/*
		 * while (i<50) { i+=1; System.out.printf("Iteración %d\n", i); } i=0;
		 */
		do {
			i += 1;
			System.out.printf("Iteración %d\n", i);
		} while (i < 50);
	}
}