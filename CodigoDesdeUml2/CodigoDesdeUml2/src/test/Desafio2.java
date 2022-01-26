package test;

import modelo.Cliente;
import modelo.LibroVenta;

import modelo.Vehiculo;
public class Desafio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibroVenta libroVenta = new LibroVenta("Venta1 MiniBus", "22/--/12///2100");
		
		
		Vehiculo vc = new Vehiculo("Azul","PTXX56");
		Cliente cli = new Cliente("Ernesto","16.000.023-2",27);
		
		try {
			libroVenta.guardarVenta(cli,vc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
   