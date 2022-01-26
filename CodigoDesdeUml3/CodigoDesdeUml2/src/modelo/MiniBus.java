package modelo;

public class MiniBus extends Vehiculo{
	
	private String tipoViaje;
	
	public MiniBus() {
		
	}
	
	public MiniBus(String color, String patente, String tipoViaje, int cantidadAsientos) {
		super(color, patente, cantidadAsientos);
		this.tipoViaje = tipoViaje;
	}
	
	public void imprimeBus() {
		String color = this.color;
		String patente = this.patente;
		String tipoViaje = this.tipoViaje;
		int cantidadAsientos = this.cantidadAsientos;
		
		System.out.println("El color del MiniBus es " + color);
		System.out.println("La patente del MiniBus es " + patente);
		System.out.println("El tipo de viaje es: " + "\"" + tipoViaje + "\"");
		System.out.println("La cantidad de asientos es " + cantidadAsientos);
	}

	public String getTipoViaje() {
		return tipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
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
