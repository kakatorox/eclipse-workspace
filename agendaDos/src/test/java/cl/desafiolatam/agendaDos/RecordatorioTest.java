package cl.desafiolatam.agendaDos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.desafiolatam.agendaDos.modelo.FormatoFecha;
import cl.desafiolatam.agendaDos.modelo.Recordatorio;

@DisplayName("Prueba de Recordatorio")
public class RecordatorioTest {

	private static Recordatorio recoTest = null;
	@Test
	public void testRecordatorio() {
		recoTest = new Recordatorio();
		new FormatoFecha();
		recoTest.setTituloRecordatorio("Aprendiendo Recordatorios");
		recoTest.setFechaEnAgenda(2022,9, 1);
		recoTest.setNota(2022, 11, 1, 14, 10, 2, "Primera Nota");
		recoTest.setNota(2022, 11, 1, 21, 21, 1, "Segunda Nota");
		System.out.println(recoTest.toString());
		
	}
}
