package cl.desafiolatam.colegio.dao.model;

import java.util.List;

public class Asignatura {

	private int idAsignatura;
	private String descripcion;
	private List<Curso> listaCurso;
	private List<Profesor> listaProfesor;
	public int getIdAsignatura() {
		return idAsignatura;
	}
	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Curso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	public List<Profesor> getListaProfesor() {
		return listaProfesor;
	}
	public void setListaProfesor(List<Profesor> listaProfesor) {
		this.listaProfesor = listaProfesor;
	}
	
}
