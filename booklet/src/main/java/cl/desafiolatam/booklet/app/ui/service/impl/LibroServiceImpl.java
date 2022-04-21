package cl.desafiolatam.booklet.app.ui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.desafiolatam.booklet.app.ui.dao.LibroDao;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;
import cl.desafiolatam.booklet.app.ui.service.LibroService;


@Service("libroService")

public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroDao libroDAO;
	
	@Override
	public boolean addLibro(LibroDto libroDTO) {
		// TODO Auto-generated method stub
		return libroDAO.addLibro(libroDTO);
	}

	@Override
	public String getLibros() {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		return gson.toJson(libroDAO.getLibros());
		
	}
	
	@Override
	public boolean deleteLibro(int i) {
		// TODO Auto-generated method stub
		return libroDAO.deleteLibro(i);
	}

	@Override
	public boolean updateLibro(LibroDto libroDTO) {
		// TODO Auto-generated method stub
		return libroDAO.updateLibro(libroDTO);
	}

}
