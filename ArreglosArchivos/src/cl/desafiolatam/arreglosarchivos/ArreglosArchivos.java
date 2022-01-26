package cl.desafiolatam.arreglosarchivos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArreglosArchivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = new int[4];

		// ArrayList<Integer> arrEnt = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		String ingre;
		int[] a = { 1, 2, 3, 4, 5, 8, 3, 2, 11, 10 };
		System.out.println(sumaArr(a));

		int[] sueldos = { 400000, 760000, 1100000, 650000, 654980, 987300, 700450, 442300 };
		System.out.println(promSueldos(sueldos));

		// System.out.println("Ingrese Ingrediente");
		// ingre = sc.next();
		// System.out.println(pizzaCon(ingre));

		removerEncuentraDetiene();
		removerTodo();

		//System.out.println("Ingrese Ingrediente");
		//ingre = sc.next();
		//System.out.println((Integer.parseInt(ingre)));
		
		sortear();
		minMax();
		sc.close();
	}

	static int sumaArr(int[] a) {
		int suma = 0, i;

		int n = a.length;
		for (i = 0; i < n; i++) {
			if (a[i] >= 1 && a[i] <= 10) {
				suma = suma + a[i];
			}
		}
		return suma;
	}

	static int promSueldos(int[] a) {
		int prom = 0, cont = 0, acu = 0;
		int n = a.length, i;
		for (i = 0; i < n; i++) {
			if (a[i] > 500000) {
				acu = acu + a[i];
				cont++;
			}
		}
		prom = acu / cont;

		return prom;
	}

	static ArrayList<String> pizzaCon(String ing) {

		ArrayList<String> ingredientes = new ArrayList<String>();
		ingredientes.add("Masa");
		ingredientes.add("Oregano");
		ingredientes.add("Tomate");
		System.out.print("asd" + ing + "333");
		int n = ingredientes.size(), i;

		for (i = 0; i < n; i++) {
			if (ingredientes.contains(ing)) {
				System.out.println("Ya Existe");
				i = n;
			} else {

				ingredientes.add(ing);
				i = n;
			}
		}

		return ingredientes;// con;
	}

	static void removerEncuentraDetiene() {

		ArrayList<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("a");
		System.out.println(a); // [a,b,c,d]
		a.remove("a");
		System.out.println(a); // [b,c,d]
		a.remove("a");
		System.out.println(a);
	}

	static void removerTodo() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("c");
		a.add("c");
		a.add("c");
		a.add("a");
		a.add("d");
		System.out.println(a); // [a, b, c, c, c, c, a, d]
		ArrayList<String> elementosABorrar = new ArrayList<String>();
		elementosABorrar.add("a");
		elementosABorrar.add("c");
		a.removeAll(elementosABorrar);
		System.out.println(a);
	}

	static ArrayList<Integer> agregarElemento(int parT) {
		
		ArrayList<Integer> par=new ArrayList<Integer>();
		String res="s";
		Scanner sc = new Scanner(System.in);
		while(res.equalsIgnoreCase("s")) {
			if(parT%2==0) {
				par.add(parT);
			}
			else {
				System.out.println("es Impar");
			}
			
			System.out.println("desea ingresar otro numero");
			res = sc.next();
			
		}
		return par;	
	}
	
	static void sortear() {
		ArrayList<String> paises = new ArrayList<String>();
		paises.add("Chile");
		paises.add("Argentina");
		paises.add("Colombia");
		paises.add("Perú");
		paises.add("Venezuela");
		Collections.sort(paises);
		System.out.println(paises); //[Argentina, Chile,Colombia, Perú, Venezuela]
		
		//reverso
		Collections.reverse(paises);
		System.out.println(paises);
		
		Collections.reverse(paises);
	}

	static void minMax() {
		ArrayList<Integer> numeros = new
				ArrayList<Integer>();
				numeros.add(5);
				numeros.add(1);
				numeros.add(4);
				numeros.add(1);
				numeros.add(2);
				numeros.add(6);
				System.out.println(Collections.min(numeros)); //1
				System.out.println(Collections.max(numeros)); //6
				System.out.println(Collections.frequency(numeros, 1)); //2
	}

	static void iteratores() {
		
		//agenda, agregar ,modificar
		
				
	}
	
	
}
