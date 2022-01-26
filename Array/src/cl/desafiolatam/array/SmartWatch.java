package cl.desafiolatam.array;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> vis = new ArrayList<Integer>();
		System.out.println("Bienvenido");
		
		vis.add(300); 
		vis.add(405);
		vis.add(403); 
		vis.add(506); 
		vis.add(100020040); 
		vis.add(45006);
		vis.add(-1044);
		
		sc.close();
		System.out.println("Arreglo inicial\n"+ vis);
		System.out.println(clearSteps(vis));
	}

	static ArrayList<Integer> clearSteps(ArrayList<Integer> vis) {
		int i, prom, acu = 0;

		ArrayList<Integer> elementosABorrar = new ArrayList<Integer>();
		
		for (i = 0; i < vis.size(); i++) {
			if (vis.get(i) < 200 || vis.get(i) > 100000) {
				elementosABorrar.add(vis.get(i));
			}
		}

		vis.removeAll(elementosABorrar);

		for (i = 0; i < vis.size(); i++) {
			acu = acu + vis.get(i);
		}
		vis.size();
		if (vis.size() == 0) {
			prom = 0;
		}else {
			prom = acu / vis.size();
		}
		System.out.println("El Promedio del Arreglo es: " + prom);
		return vis;
	}
}
