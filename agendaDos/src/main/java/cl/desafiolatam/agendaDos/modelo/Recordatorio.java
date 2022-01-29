package cl.desafiolatam.agendaDos.modelo;

import java.util.Calendar;
import java.util.TreeMap;

public class Recordatorio {
	private Calendar calendario;
	private TreeMap<Calendar,String> nota;
	public Recordatorio(Calendar calendario, TreeMap nota) {
		super();
		this.calendario = calendario;
		this.nota = nota;
	}
	public Calendar getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}
	public TreeMap<Calendar,String> getNota() {
		return nota;
	}
	public void setNota(TreeMap nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Recordatorio [calendario=" + calendario + ", nota=" + nota + "]";
	}

}
