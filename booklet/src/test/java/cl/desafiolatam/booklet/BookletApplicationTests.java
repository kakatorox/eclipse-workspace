package cl.desafiolatam.booklet;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.desafiolatam.booklet.app.ui.dao.LibroDao;
import cl.desafiolatam.booklet.app.ui.dao.impl.LibroDaoImpl;
import cl.desafiolatam.booklet.app.ui.dao.model.Libro;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;


@SpringBootTest
class BookletApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
	
	
	@Autowired
	LibroDto libroDto;
	@Autowired
	Libro libro;
	@Autowired
	LibroDao libroDao;
	
	@Test
	public void test1() {
	/* Código de prueba para el caso 1 */
		libroDao = new LibroDaoImpl();
		libro.setAutor("Felipe");
		libroDto.setLibro(libro);
		assertThat(1).has((Condition<? super Integer>) libroDao.getLibros());
	}
	

}
