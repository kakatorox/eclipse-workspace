package modelo;

import java.util.Scanner;

public class Bus extends Vehiculo {
	
	public Bus() {
		
	}
	
	public Bus(String color, String patente, int cantidadAsientos) {
		super(color, patente, cantidadAsientos);
	}
	
	public int asientosDisponibles() {
		
		Scanner tx=new Scanner(System.in);
		int asientosOcu;
		System.out.println("Ingrese Cantidad de Asientos Ocupados:");
		asientosOcu = tx.nextInt();
		tx.close();		
		return this.cantidadAsientos - asientosOcu;
	}

	@Override
	public int getCantidadAsientos() {
		// TODO Auto-generated method stub
		return super.getCantidadAsientos();
	}

	@Override
	public void setCantidadAsientos(int cantidadAsientos) {
		// TODO Auto-generated method stub
		super.setCantidadAsientos(cantidadAsientos);
	}

}
