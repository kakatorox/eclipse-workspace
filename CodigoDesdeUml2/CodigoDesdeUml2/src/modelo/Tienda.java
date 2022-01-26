package modelo;

import java.util.ArrayList;

public class Tienda {

	private String nombreTienda;
	private	Stock stock;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Cliente> clientes;
	
	public Tienda(String nombreTienda, Stock stock, ArrayList<Vendedor> vendedores) {
		super();
		this.nombreTienda = nombreTienda;
		this.stock = stock;
		this.vendedores = vendedores;
	}
	
	public Tienda(String nombreTienda, Stock stock, ArrayList<Vendedor> vendedores, ArrayList<Cliente> clientes) {
		super();
		this.nombreTienda = nombreTienda;
		this.stock = stock;
		this.vendedores = vendedores;
		this.clientes = clientes;
	}

	public String existeStock(){
		
		String stockString = "";
		int cantB = this.stock.getStockBus().size();
		int cantMB=this.stock.getStockMiniBus().size();
		int cantT = this.stock.getStockTaxi().size();
		int total=cantB+cantMB+cantT;
		this.stock.getStockBus().size();
		stockString += 	
						"\nStock Bus : "+cantB +
						"\nStock MiniBus : "+cantMB +
						"\nStock Taxi : "+cantT+
						"\nTotal de Stock es : "+total;		
		return stockString;
	}
	
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}

	public Stock getStock() {
			
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
		
}
