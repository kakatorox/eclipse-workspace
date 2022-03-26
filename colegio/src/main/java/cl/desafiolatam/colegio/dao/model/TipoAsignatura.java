package cl.desafiolatam.colegio.dao.model;

import java.util.List;

public class TipoAsignatura {

	private int idTipoasignatura;
	private String descripcionl;
	private List<Asignatura> listaAsignatura;
	public int getIdTipoasignatura() {
		return idTipoasignatura;
	}
	public void setIdTipoasignatura(int idTipoasignatura) {
		this.idTipoasignatura = idTipoasignatura;
	}
	public String getDescripcionl() {
		return descripcionl;
	}
	public void setDescripcionl(String descripcionl) {
		this.descripcionl = descripcionl;
	}
	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}
	public void setListaAsignatura(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}
	
}
