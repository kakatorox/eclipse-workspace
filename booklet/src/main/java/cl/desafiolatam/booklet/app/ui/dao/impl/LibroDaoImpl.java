package cl.desafiolatam.booklet.app.ui.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import cl.desafiolatam.booklet.app.ui.dao.LibroDao;
import cl.desafiolatam.booklet.app.ui.dao.mapper.LibroMapper;
import cl.desafiolatam.booklet.app.ui.dao.model.Libro;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;

@Repository("libroDAO")
public class LibroDaoImpl implements LibroDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<LibroDto> getLibros(){
		String consultaSql="SELECT * FROM public.\"LIBRO\";";
		return jdbcTemplate.query(consultaSql, new LibroMapper());		
	}
	
	
	@Override
	public boolean addLibro(LibroDto libroDto) {
		
		Libro libro = libroDto.getLibro();
		
		String sqlInsert = "INSERT INTO public.\"LIBRO\" (titulo,anio,autor,imprenta,disponible) VALUES (?,?,?,?,?);"; 
		
		int resultadoSql = jdbcTemplate.update(sqlInsert,libro.getTitulo(),libro.getAnio(),libro.getAutor(),libro.getImprenta(),libro.isDisponible());
		
		if (resultadoSql == 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean deleteLibro(int i) {
		
		String sqlDelete = "Delete from public.\"LIBRO\" where \"Id\" = ? ;"; 
		
		int resultadoSql = jdbcTemplate.update(sqlDelete,i);
		
		if (resultadoSql == 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean updateLibro(LibroDto libroDto) {
		
		Libro libro = libroDto.getLibro();
		
		String sqlUpdate = "UPDATE public.\"LIBRO\"SET titulo=?, anio=?, autor=?, imprenta=?, disponible=? WHERE \"Id\" = ? ;"; 
		
		int resultadoSql = jdbcTemplate.update(sqlUpdate,libro.getTitulo(),libro.getAnio(),libro.getAutor(),libro.getImprenta(),libro.isDisponible(),libro.getId());
		
		if (resultadoSql == 1) {
			return true;
		}
		
		return false;
	}
	
}
