package com.desafiolatam.entidades;

public class FormaDePagoDTO {
	
	private int idFormaDePago;
	
	private String descripcion;
	
	private double recargo;

	public int getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(int idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(String recargo) {
		String[] s = recargo.split("%");
		this.recargo = Double.parseDouble(s[0])/100;
	}
}
