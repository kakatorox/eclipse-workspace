package cl.desafiolatam.fechas;

import java.util.Scanner;

public class Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fecha1,fecha2,opcion = null;;
		int f1Dia,f1Mes,f1Anio;
		int f2Dia,f2Mes,f2Anio;
		int flag=0;
		Scanner sc;
		sc=new Scanner(System.in);
			do {
				System.out.println("Ingrese la persona 1 fecha como DD/MM/AAAA");
				fecha1=sc.nextLine();
				
				System.out.println("Ingrese la persona 2 fecha como DD/MM/AAAA");
				fecha2=sc.nextLine();
				
				f1Dia=Integer.parseInt(fecha1.substring(0, 2));
				f1Mes=Integer.parseInt(fecha1.substring(3, 5));
				f1Anio=Integer.parseInt(fecha1.substring(6, 10));
				
				f2Dia=Integer.parseInt(fecha2.substring(0, 2));
				f2Mes=Integer.parseInt(fecha2.substring(3, 5));
				f2Anio=Integer.parseInt(fecha2.substring(6, 10));
				
				if((f1Anio<f2Anio)) {				
					System.out.println("persona 1 es mayor");							
				}
				if(f1Anio>f2Anio){
					System.out.println("persona 2 es mayor");
				}		
				if((f1Anio==f2Anio)&&(f1Mes==f2Mes)&&(f1Dia==f2Dia)) {
					System.out.println("Tienen la misma edad");
					flag=1;
				}	
				if((f1Anio==f2Anio)&&(flag==0)) {
					if(f1Mes<f2Mes) {
						if(f1Dia<f2Dia) {
							System.out.println("persona 1 es mayor");
						}
						if(f1Dia>f2Dia) {
							System.out.println("persona 2 es mayor");
						}
						if(f1Dia==f2Dia) {
							System.out.println("persona 1 es mayor");
						}				
					}
					if(f1Mes>f2Mes)
					{
						if(f1Dia<f2Dia){
							System.out.println("persona 1 es mayor");
						}
						if(f1Dia>f2Dia){
							System.out.println("persona 2 es mayor");			
						}
						if(f1Dia==f2Dia) {
							System.out.println("persona 2 es mayor");
						}
					}
					if(f1Mes==f2Mes) {
						if(f1Dia<f2Dia) {
							System.out.println("persona 1 es mayor");
						}
						if(f1Dia>f2Dia){
							System.out.println("persona 2 es mayor");
						}
					}
				}		
				
				System.out.println("Ingrese s o n. \"s\" para salir");
				opcion = sc.nextLine();
				
				if(((!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")))) {
					System.out.println("Por favor ingrese una opción correcta!!!");
				}
		}while(!opcion.equals("s"));
			sc.close();
			System.out.println("Hasta Luego");
	}
}