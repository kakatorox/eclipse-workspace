package cl.desafiolatam.clase.model1;

public class Trabajador extends Persona{

	private String tipoContrato;
	private String cargo;
	
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	
	public String saludar() {
		
		if("Español".equalsIgnoreCase("español")) {
			return "Hola a Todos";
		}else if("Ingles".equalsIgnoreCase("ingles")) {
			return "hello madafakas";
		}else {
			return "Indefinido";
		}		
	}
	
}
