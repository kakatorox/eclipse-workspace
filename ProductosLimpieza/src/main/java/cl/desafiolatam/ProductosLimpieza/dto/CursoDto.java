package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Curso;

public class CursoDto {
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
