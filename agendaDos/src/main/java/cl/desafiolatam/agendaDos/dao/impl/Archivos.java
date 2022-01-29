package cl.desafiolatam.agendaDos.dao.impl;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class Archivos {
	private Map<Calendar, TreeMap> dbRecordatorios = new TreeMap<Calendar, TreeMap>();
	
	public Map<Calendar, TreeMap> getDbRecordatorios() {
		return dbRecordatorios;
	}
	public void setDbRecordatorios(Map<Calendar, TreeMap> dbRecordatorios) {
		this.dbRecordatorios = dbRecordatorios;
	}
	

}
