package cl.desafiolatam.holamundo;

public class EjercicioGuiadoCadenaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena1 = "1";
		String cadena2 = "2";
		
		if(cadena1.equals(cadena2)) {
		System.out.println("Son iguales");
		}
		else {
			System.out.println("Son Distintas");
		}
		if(cadena1.compareTo(cadena2)==0) {
			System.out.println("Cadena1 es igual a Cadena2");
			}
		if(cadena1.compareTo(cadena2)>0) {
			System.out.println("Cadena1 es mayor que Cadena2");
			}
		if(cadena1.compareTo(cadena2)<0 && cadena1.compareTo(cadena2)!=0){
			System.out.println("Cadena2 es mayor que Cadena1");
			}						
	}
}