package cl.desafiolatam.agendaDos.dao.impl;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import c.desafiolatam.agendaDos.dao.RecordatorioDao;
import cl.desafiolatam.agendaDos.modelo.Recordatorio;

public class RecordatorioDaoImpl implements RecordatorioDao {

	public String crearRecordatorios(Recordatorio recordatorio) {
		String respuesta = null;
		try {
			Archivos misArchivos = new Archivos();
			Map<Calendar, TreeMap> archivos = misArchivos.getDbRecordatorios();
			archivos.put(recordatorio.getCalendario(), recordatorio.getNota());
			misArchivos.setDbRecordatorios(archivos);
			respuesta ="Creado";

		} catch (Exception e) {
			respuesta="Error Recordatario no creado";
		}

		return respuesta;
	}
	
	/*
	 * public String actualizarRecordatorios(Recordatorio recordatorio) { String
	 * respuesta = null; try { Archivos misArchivos = new Archivos(); Map<Calendar,
	 * TreeMap> archivos = misArchivos.getDbRecordatorios();
	 * archivos.put(recordatorio.getCalendario(), recordatorio.getNota());
	 * misArchivos.setDbRecordatorios(archivos); respuesta ="Creado";
	 * 
	 * } catch (Exception e) { respuesta="Error Recordatario no creado"; }
	 * 
	 * return respuesta; }
	 */
}
