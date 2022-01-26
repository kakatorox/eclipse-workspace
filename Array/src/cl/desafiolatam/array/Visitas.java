package cl.desafiolatam.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> vis = new ArrayList<Integer>();
		System.out.println("Bienvenido");
		vis.add(3001);
		vis.add(1402);
		vis.add(1304);
		vis.add(1505);
		System.out.println(vis);
		System.out.println("Para la entrada anterior, el resultado es " + promedio(vis));
	}

	static int promedio(ArrayList<Integer> visitasDiarias) {
		int prom = 0, acu=0;
		for (int i = 0; i < visitasDiarias.size(); i++) {
			acu = acu + visitasDiarias.get(i);
		}
		prom = acu / visitasDiarias.size();
		return prom;
	}
}
