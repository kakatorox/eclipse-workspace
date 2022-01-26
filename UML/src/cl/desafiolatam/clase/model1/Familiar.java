package cl.desafiolatam.clase.model1;

public class Familiar extends Persona{

	private String tipoPersona;

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public String saludar() {
		
		if(getLenguaje().equalsIgnoreCase("español")) {
			return "Hola a Todos";
		}else if(getLenguaje().equalsIgnoreCase("ingles")) {
			return "hello madafakas";
		}else {
			return "agu agu";
		}	
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}

	@Override
	public String getApellido() {
		// TODO Auto-generated method stub
		return super.getApellido();
	}

	@Override
	public void setApellido(String apellido) {
		// TODO Auto-generated method stub
		super.setApellido(apellido);
	}

	@Override
	public int getEdad() {
		// TODO Auto-generated method stub
		return super.getEdad();
	}

	@Override
	public void setEdad(int edad) {
		// TODO Auto-generated method stub
		super.setEdad(edad);
	}

	@Override
	public char getGenero() {
		// TODO Auto-generated method stub
		return super.getGenero();
	}

	@Override
	public void setGenero(char genero) {
		// TODO Auto-generated method stub
		super.setGenero(genero);
	}

	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return super.getFechaNacimiento();
	}

	@Override
	public void setFechaNacimiento(String fechaNacimiento) {
		// TODO Auto-generated method stub
		super.setFechaNacimiento(fechaNacimiento);
	}

	@Override
	public String getRut() {
		// TODO Auto-generated method stub
		return super.getRut();
	}

	@Override
	public void setRut(String rut) {
		// TODO Auto-generated method stub
		super.setRut(rut);
	}

	@Override
	public String getLenguaje() {
		// TODO Auto-generated method stub
		return super.getLenguaje();
	}

	@Override
	public void setLenguaje(String lenguaje) {
		// TODO Auto-generated method stub
		super.setLenguaje(lenguaje);
	}
	
	
}
