package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Alumno;

public class AlumnoDto {
	private List<Alumno> alumnos;

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
}
