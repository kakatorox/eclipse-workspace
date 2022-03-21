package cl.desafiolatam.model;

public class Item {
	
	public int valortotal;
		
	public Item(int cantidad,int valor) {
		this.valortotal = cantidad * valor;
		
	}

	public int getValortotal() {
		return valortotal;
	}

	public void setValortotal(int valortotal) {
		this.valortotal = valortotal;
	}	
	

}
