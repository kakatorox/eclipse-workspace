package cl.desafiolatam.clase.clase1;

import cl.desafiolatam.clase.model1.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Familiar papa= new Familiar();
		Trabajador t1= new Trabajador();
		papa.setNombre("Pepito");
		papa.setApellido("Torres");
		papa.setRut("15911702-2");
		papa.setGenero('d');
		papa.setEdad(37);
		papa.setTipoPersona("Papa");
		papa.setFechaNacimiento("31/10/1984");
		papa.setLenguaje("ingles");
		
		t1.setCargo("jardinero");
		t1.setEdad(24);
		t1.setFechaNacimiento("10-10-1990");
		t1.setNombre("Juanito");
		t1.setLenguaje("Ingles");
		
		
		
		
	}

}
