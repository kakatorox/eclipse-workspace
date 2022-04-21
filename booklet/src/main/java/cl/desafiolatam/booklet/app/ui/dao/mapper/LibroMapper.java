package cl.desafiolatam.booklet.app.ui.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.desafiolatam.booklet.app.ui.dao.model.Libro;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;

public class LibroMapper implements RowMapper<LibroDto>{

	
	@Override
	public LibroDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		LibroDto libroDTO = new LibroDto();
		Libro libro = new Libro();
		
		libro.setId(rs.getInt("id"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAnio(rs.getString("anio"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getBoolean("disponible"));
		
		libroDTO.setLibro(libro);
		
		return libroDTO;
	}

}
