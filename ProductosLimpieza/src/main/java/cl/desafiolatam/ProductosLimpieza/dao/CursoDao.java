package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Alumno;
import cl.desafiolatam.ProductosLimpieza.dao.model.Curso;

public interface CursoDao {
	public int add(Curso curso);
	public List<Curso> getAll();
	public Alumno getById(int idCurso);
	public int update(Curso alumno);
	public int deleteById(int idCurso);
}
