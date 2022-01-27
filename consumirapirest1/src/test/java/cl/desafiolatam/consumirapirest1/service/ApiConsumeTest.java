package cl.desafiolatam.consumirapirest1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.desafiolatam.consumirapirest1.response.Post;
import cl.desafiolatam.consumirapirest1.response.ResponseObject;
import cl.desafiolatam.consumirapirest1.service.impl.ApiConsumeImpl;

@DisplayName("Test Consumo de APIS")

public class ApiConsumeTest {

	private static Logger logger = Logger.getLogger("ApiConsumeTest");
	private static ApiConsume apiConsume = null;
	private static ResponseObject responseObject = null;
	@BeforeAll
	static void setup() {
		logger.info("Inicio de Test ApiConsumeTest");
		apiConsume = new ApiConsumeImpl(); 
	}
	
	@BeforeEach
	void init1() {
		logger.info("Se ejecuta antes de Cada Test");
		responseObject = new ResponseObject();
	}
	
	@Test
	void evaluarObjetoPortTest() {
		logger.info("obtenerListaPostTest");
		responseObject = apiConsume.getPostResponseObject();
		List<Post> liPost = (List<Post>) responseObject.getBody();
		
		assertEquals("Post",liPost.get(0).getClass().getSimpleName());
		
	}
	
	@Test
	void obtenerListaPostFiltroTest() {
		logger.info("obtenerListaPostTest");
		//List<Post> liPost = apiConsume.getPostResponseObject("1");;
		//assertTrue(liPost.size() == 1);
		
	}
	@Test
	void obtenerListaPostFiltro2Test() {
		logger.info("obtenerListaPostTest");
		responseObject = apiConsume.getPostResponseObject();
		List<Post> liPost = (List<Post>) responseObject.getBody();
		assertTrue(liPost.size() == 0);
		
	}
	@AfterEach
	void endSetPostTest() {
		logger.info("endSetPostTest");
	}
	@AfterAll
	static void done(){
		logger.info("Prueba REalizadas Consumo Api");
	}
}