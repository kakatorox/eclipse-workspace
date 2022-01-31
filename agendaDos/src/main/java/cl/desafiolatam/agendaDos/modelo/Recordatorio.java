package cl.desafiolatam.agendaDos.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class Recordatorio {
	private Calendar calendario = null;
	private String tituloRecordatorio = null;
	private TreeMap<Calendar, String> nota = new TreeMap<Calendar, String>();
	private TreeMap<String,TreeMap<Calendar,TreeMap<Calendar, String>>> dbRecordatorio = new TreeMap<String, TreeMap<Calendar,TreeMap<Calendar,String>>>();
	
	private FormatoFecha formatoFecha;

	public Recordatorio() {

	}

	public Recordatorio(Calendar calendario, String tituloRecordatorio, TreeMap<Calendar, String> nota) {
		super();
		this.calendario = calendario;
		this.tituloRecordatorio = tituloRecordatorio;
		this.nota = nota;
	}
	

	public Calendar getFechaEnAgenda() {
		return calendario;
	}

	public void setFechaEnAgenda(int anio, int mes, int dia) {
		this.calendario = new GregorianCalendar();
		this.calendario.set(Calendar.YEAR, anio);
		this.calendario.set(Calendar.MONTH, mes);
		this.calendario.set(Calendar.DATE, dia);

	}

	public String getTituloRecordatorio() {
		return tituloRecordatorio;
	}

	public void setTituloRecordatorio(String tituloRecordatorio) {
		this.tituloRecordatorio = tituloRecordatorio;
	}

	public TreeMap<Calendar, String> getNota() {

		return nota;
	}

	public void setNota(int anio, int mes, int dia, int hora, int min, int seg, String contenidoNota) {
		
		Calendar nCalendario = new GregorianCalendar();
		nCalendario.set(Calendar.YEAR, anio);
		nCalendario.set(Calendar.MONTH, mes);
		nCalendario.set(Calendar.DATE, dia);
		nCalendario.set(Calendar.HOUR, hora);
		nCalendario.set(Calendar.MINUTE, min);
		nCalendario.set(Calendar.SECOND, seg);

		this.nota.put(nCalendario, contenidoNota);
	}

	@Override
	public String toString() {
		formatoFecha =new FormatoFecha();
		System.out.println("Titulo Recordatorio : " + getTituloRecordatorio()
						  +"\n       Fecha Alerta : "+formatoFecha.setFormatoFecha(getFechaEnAgenda()));
		Map<Calendar, String> result = 
				nota.entrySet().stream()
										.collect(Collectors
												.toMap( Entry::getKey,
														Entry::getValue, 
														(e1,e2) -> e1, 
														TreeMap::new));  
		result.forEach((k,v)->System.out.println(formatoFecha.setFormatoFecha(k,true)+" = "+v));
		return null;
	}

	public TreeMap<String,TreeMap<Calendar,TreeMap<Calendar, String>>> getDbRecordatorio() {
		return dbRecordatorio;
	}

	public void setDbRecordatorio(String tituloDeRecordatorio,int anio,) {
		Calendar nCalendario = new GregorianCalendar();
		nCalendario.set(Calendar.YEAR, anio);
		nCalendario.set(Calendar.MONTH, mes);
		nCalendario.set(Calendar.DATE, dia);
		nCalendario.set(Calendar.HOUR, hora);
		nCalendario.set(Calendar.MINUTE, min);
		nCalendario.set(Calendar.SECOND, seg);
		this.dbRecordatorio.put(tituloRecordatorio, null);
	}

}
