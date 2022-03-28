package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Alumno;

public interface AlumnoDao {
	public int add(Alumno alumno);
	public List<Alumno> getAll();
	public Alumno getById(int idalumno);
	public int update(Alumno alumno);
	public int deleteById(int idAlumno);
}
