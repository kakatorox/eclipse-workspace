package cl.desafiolatam.contactmanager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;
import cl.desafiolatam.contactmanager.app.ui.model.Contacto;
import cl.desafiolatam.contactmanager.app.ui.service.ContactoService;


@SpringBootTest
class ContactmanagerApplicationTests {
	@Autowired
	ContactoDto contactoDto;
	@Autowired
	Contacto contacto;
	@Autowired
	ContactoService contactoService;
	
	@Test
	public void test1() {
	/* Código de prueba para el caso 1 */
		contacto.setNombre("Felipe");
		contactoDto.setContacto(contacto);
		assertThat("Felipe").as(contactoDto.getContacto().getNombre());
	}
	
}
