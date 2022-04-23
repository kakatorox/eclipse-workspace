package cl.desafiolatam.trazap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@SpringBootTest
public class BodegaServiceTests {
	//Mockito o Mocks en spring boot con junit jupiter
	
	private static BodegaService bodegaService;
	private static ResponseServiceObject responseServiceObject;
	private static ResponseServiceMessage responseServiceMessage;
	private static Bodega bodegaMock1;
	private static List<Bodega> bodegas;
	//BodegaRepository bodegaRepository = Mockito.mock(BodegaRepository.class);
	
	@BeforeAll
	public static void setUp() {
	
		bodegaService = mock(BodegaService.class);
		responseServiceObject = new ResponseServiceObject();
		responseServiceMessage = new ResponseServiceMessage();
		bodegaMock1 = new Bodega();
		bodegaMock1.setIdBodega(1);
		bodegaMock1.setDescripcion("Bodega Espacial");
		bodegas = new ArrayList<Bodega>();
		bodegas.add(bodegaMock1);
	}
	
	private void generateMockResponse(Object body,String code,ResponseServiceMessageType type ,String mensaje) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(bodegaMock1);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode(code);
		responseServiceMessage.setType(type);
		responseServiceMessage.setMensaje(mensaje);
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
	}
	
	@Test
	public void saveBodega() {
		
		generateMockResponse(bodegaMock1, "201", ResponseServiceMessageType.OK,"Servicio Finalizado Correctamente");
		
		Bodega bodegaAux = new Bodega();
		bodegaAux.setDescripcion("bodega ET");
		
		when(bodegaService.save(bodegaAux)).thenReturn(responseServiceObject);
		
		ResponseServiceObject respuesta = bodegaService.save(bodegaAux);
		
		assertThat(((Bodega) respuesta.getBody()).getIdBodega()).isEqualTo(1);
		assertThat(respuesta).isEqualTo(responseServiceObject);
	}
	
	@Test
	public void findAllBodega() {
		generateMockResponse(bodegas, "200", ResponseServiceMessageType.OK,"Servicio bodegas Finalizado Correctamente");
		
		when(bodegaService.findAll()).thenReturn(responseServiceObject);
		
		ResponseServiceObject respuesta = bodegaService.findAll();
		
		assertThat(((ArrayList<Bodega>)respuesta.getBody()).size()).isEqualTo(1);
		assertThat(((ArrayList<Bodega>)respuesta.getBody())).isNotNull();
				
	}
//	
//	@Test
//	void getBodegas() {
//		System.out.println("Dentro de La prueba");
//		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
//		bodega.setDescripcion("Bodega Test Junit");
//		responseServiceObject.setBody(bodegaRepository.save(bodega));
//		
//		responseServiceMessage.setTimestamp(new Date());
//		responseServiceMessage.setCode("201");
//		responseServiceMessage.setType(ResponseServiceMessageType.OK);
//		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
//		
//		messageList.add(responseServiceMessage);
//						
//		responseServiceObject.setMessageList(messageList);
//	}
}
