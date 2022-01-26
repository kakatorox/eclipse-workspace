package modelo;

import java.util.Scanner;

public class Taxi extends Vehiculo{
	
	private int valorPasaje;
	
	public Taxi() {
		
	}
	//Constructor y se usa Super desde vehiculo
	public Taxi(String color, String patente, int valorPasaje){
		super(color, patente);
		this.valorPasaje = valorPasaje;
	}
	
	public String pagarPasaje() {
		int pasaje = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Estimado pague con sencillo el pasaje : ");
		pasaje=sc.nextInt();
		
		if (pasaje < this.valorPasaje) {
			return "Le faltan " + (this.valorPasaje - pasaje);
		} else if (pasaje > this.valorPasaje) {
			return "Le sobran " + (pasaje - this.valorPasaje);
		} else {
			return "Que tenga un buen día"; 
		}
	}

	public int getValorPasaje() {
		return valorPasaje;
	}

	public void setValorPasaje(int valorPasaje) {
		this.valorPasaje = valorPasaje;
	}

}
