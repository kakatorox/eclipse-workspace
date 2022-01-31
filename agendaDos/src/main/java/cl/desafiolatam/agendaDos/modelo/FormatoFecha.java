package cl.desafiolatam.agendaDos.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatoFecha {
	public String setFormatoFecha(Calendar cal) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = df.format(cal.getTime());
		return fecha;
	}
	public String setFormatoFecha(Calendar cal,boolean hora) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fecha = df.format(cal.getTime());
		return fecha;
	}
}
