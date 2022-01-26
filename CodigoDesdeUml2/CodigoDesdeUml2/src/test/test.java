package test;

import java.util.ArrayList;

import modelo.Bus;
import modelo.Cliente;
import modelo.MiniBus;
import modelo.Stock;
import modelo.Taxi;
import modelo.Tienda;
import modelo.Vendedor;

public class test {
	
	public static void main(String[] args) {
		
		//Se crea Taxi 
		Taxi taxi = new Taxi("verde", "asdf-1234", 750);
		String color = taxi.getColor();
		String patente = taxi.getPatente();
		int valorPasaje = taxi.getValorPasaje();
		System.out.println("El color del taxi es " + color);
		System.out.println("La patente del taxi es " + patente);
		System.out.println("El valor del pasaje del taxi es " + valorPasaje);
		System.out.println(taxi.pagarPasaje());
		System.out.println();
		
		//Se crea MiniBus
		MiniBus miniBus = new MiniBus("azul", "zxcv-456", "viaje intercomunal", 8);
		miniBus.imprimeBus();
		System.out.println();
		
		
		//Se Crea Bus
		Bus bus = new Bus("rojo", "dfg-9874", 40);
		color = bus.getColor();
		patente = bus.getPatente();
		int cantidadAsientos = bus.getCantidadAsientos();
		int asientosDisponibles = bus.asientosDisponibles();
		System.out.println("El color del bus es " + color);
		System.out.println("La patente del bus es " + patente);
		System.out.println("La cantidad de asientos es " + cantidadAsientos);
		System.out.println("La cantidad de asientos disponibles es " + asientosDisponibles);
		
		
		Stock stock = new Stock();
		
		//Inicio Buses
		
		ArrayList<Bus> newBuses= new ArrayList<Bus>();
		
		newBuses.add(bus);
		newBuses.add(new Bus("Beige","ffgg-45",45));
		
		
		stock.setStockBus(newBuses);		
		//Termino Buses
		
		//Inicio MiniBuses
		
		ArrayList<MiniBus> newMiniBuses= new ArrayList<MiniBus>();
		
		newMiniBuses.add(miniBus);
		newMiniBuses.add(new MiniBus());
		newMiniBuses.add(new MiniBus());
		
		
		stock.setStockMiniBus(newMiniBuses);
		//Termino MiniBuses
		
		//Inicio Taxi
		
		ArrayList<Taxi> newTaxi= new ArrayList<Taxi>();
		
		newTaxi.add(taxi);
		newTaxi.add(new Taxi());
		newTaxi.add(new Taxi());
		newTaxi.add(new Taxi());
		
		stock.setStockTaxi(newTaxi);
		//Termino MiniBuses
		
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		vendedores.add(new Vendedor("Juan","23.234.564-4","Calle Machu pichu 3423"));
		vendedores.add(new Vendedor("Felipe","14.221.423-7","Calle Kurutu 556"));

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Carlos","15.911.701-3",37));
		clientes.add(new Cliente("Jhonny","25.343.111-3",25));
		
		Tienda tienda = new Tienda("La Tienda mas Pulentosa", stock, vendedores,clientes);
		
		System.out.println(tienda.existeStock());
		
		
		for(int i=0;i<tienda.getVendedores().size();i++) {			
			System.out.println( "|"+tienda.getVendedores().get(i).getNombre()+
								"|"+tienda.getVendedores().get(i).getRut()+
								"|"+tienda.getVendedores().get(i).getDireccion()+"|");				
		}  
		
		for(int i=0;i<tienda.getClientes().size();i++) {			
			System.out.println( "|"+tienda.getClientes().get(i).getNombre()+
								"|"+tienda.getClientes().get(i).getRut()+
								"|"+tienda.getClientes().get(i).getEdad()+"|");				
		}
		
	}
}