package cl.desafiolatam.miradaalpasado;

import java.util.concurrent.TimeUnit;

public class Utilidad {
	
	public static void tEspera(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
