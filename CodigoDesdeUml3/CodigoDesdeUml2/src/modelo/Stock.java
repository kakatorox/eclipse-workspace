package modelo;

import java.util.ArrayList;

public class Stock {
	private ArrayList<Taxi> stockTaxi;
	private ArrayList<Bus> stockBus;
	private ArrayList<MiniBus> stockMiniBus;
	
	public Stock() {
		
	}
	
	public Stock(ArrayList<Taxi> stockTaxi, ArrayList<Bus> stockBus, ArrayList<MiniBus> stockMiniBus) {
		super();
		this.stockTaxi = stockTaxi;
		this.stockBus = stockBus;
		this.stockMiniBus = stockMiniBus;
	}

	public ArrayList<Taxi> getStockTaxi() {
		return stockTaxi;
	}

	public void setStockTaxi(ArrayList<Taxi> stockTaxi) {
		this.stockTaxi = stockTaxi;
	}

	public ArrayList<Bus> getStockBus() {
		return stockBus;
	}

	public void setStockBus(ArrayList<Bus> stockBus) {
		this.stockBus = stockBus;
	}

	public ArrayList<MiniBus> getStockMiniBus() {
		return stockMiniBus;
	}

	public void setStockMiniBus(ArrayList<MiniBus> stockMiniBus) {
		this.stockMiniBus = stockMiniBus;
	}

}
