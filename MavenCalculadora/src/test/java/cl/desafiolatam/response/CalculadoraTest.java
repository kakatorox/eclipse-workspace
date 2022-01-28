package cl.desafiolatam.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Calculadora")
public class CalculadoraTest {

	private static Logger logger = Logger.getLogger("CalculadoraTest");
	private static Calculadora calc = null;
	private static int cont = 1;
	@BeforeAll
	static void setup() {
		logger.info("\n------------------------------\n"
				  + "                              \n"
				  +"Bienvenidos a Test Calculadora\n"
				  + "                              \n"+
				  "------------------------------\n");
	}

	@BeforeEach
	void init1() {		
		logger.info("\n------------------------------\n"
				+ "                              \n"
				+ "Test Número " + cont
				+ "\n                              \n"+
				"------------------------------\n");
	}

	@Test
	void restarNum() {
		logger.info("Resta");
		calc = new Calculadora();
		boolean re = calc.restar(1, 1000000000);
		assertTrue(re);
	}
	@Test
	void sumarNum() {
		logger.info("Suma");
		calc = new Calculadora();
		int re = calc.sumar(1, 1);
		assertEquals(2,re);
	}
	@Test
	void multiplicarNum() {
		logger.info("Multiplicación");
		calc = new Calculadora();
		int re = calc.multiplicar(1, 1);
		assertEquals(1,re);
	}
	@Test
	void dividirNum() {
		logger.info("División");
		calc = new Calculadora();
		String re = calc.dividir(1, 0);
		assertSame("Infinity",re);
	}
	@AfterEach
	void endCalculadora() {		
		logger.info("\n------------------------------\n"
				+ "                              \n"
				+ "Termino del Test Numero " + cont
				+ "\n                              \n"+
				"------------------------------\n");
		
		cont++;
	}

	@AfterAll
	static void done() {
		logger.info("Hasta pronto dice la Calculadora");
	}

}
