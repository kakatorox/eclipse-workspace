package cl.desafiolatam.holamundo;
import java.util.Scanner;
public class ejercicioGuiado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		String apellido;
		String direccion;
		int numeroDireccion;
		String ciudad;
		String telefono;
		Scanner sc;
		String etiqueta;
		sc = new Scanner(System.in);
		System.out.print("Nombre:");
		
		nombre = sc.next();
		
		System.out.print("Apellido:");
		
		apellido = sc.next();
		
		System.out.print("Direccion:");
		
		direccion = sc.next();
		
		System.out.print("Numero Direccion:");
		
		numeroDireccion = sc.nextInt();
		
		System.out.print("Ciudad:");
		
		ciudad = sc.next();
		
		System.out.print("Telefono:");
		
		telefono = sc.next();
		
		etiqueta = String.format(
				"De: %s %s \n Dirección: %s %d \n Ciudad: %s \n Contacto: %s \n", 
				nombre,
				apellido,
				direccion,
				numeroDireccion,
				ciudad,
				telefono);

		
		System.out.print(etiqueta);

		sc.close();
		
	}

}
