package cl.desafiolatam.holamundo;

public class TipoDato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int miInt = 10;
		double miDouble = 10;
		float miFloat = 10;
		short miShort = 31999;
		double res = 0;
		System.out.println(miInt);
		System.out.println(miDouble);
		System.out.println(miFloat);
		System.out.println(miShort);
		
		res=Math.pow(miInt,2);//+miDouble;
		
		System.out.println(res);
		
		String miString = new String ("Hola Mundo desde String");
		
		miString = String.valueOf(miShort);
		
		System.out.println(miString);
		
		int edad = 34;
		String nombre = "William";
		String salida = String.format("%s tiene %d años.",nombre,edad);
		System.out.println(salida);
		
		//William tiene 34 años
		//int %d
		//char %c
		//float %f
		//String %s
		String s = "Paralelepipedo";
		System.out.printf("%s \n",s.substring(4));
		System.out.printf("%s \n",s.substring(0,4));
		
		//final int DIAS_SEMANA=7;
		//final int MAX_ITERACIONES = 10;
		
		
	}
}