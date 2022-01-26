package cl.desafiolatam.miradaalpasado;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class Mapa {
	
	private Map<String, Integer> golosinas;
	
	public Map<String, Integer> primeraParte() {
		
		Utilidad.tEspera(2);
		System.out.println("\n\n/////////////////////////////");
		System.out.println("Ejercicio 3");
		System.out.println("/////////////////////////////\n");
		golosinas = new TreeMap<>();

		golosinas.put("Chocman", 100);
		golosinas.put("Trululú", 100);
		golosinas.put("Centella", 100);
		golosinas.put("Kilate", 50);
		golosinas.put("Miti-miti", 30);
		golosinas.put("Traga Traga", 150);
		golosinas.put("Tabletón", 5);
		
		System.out.println(golosinas);
						
		

					
		golosinas.entrySet().stream()
							.sorted(Map.Entry.comparingByValue())
							.forEach(System.out::println);

		System.out.println("\nSeparador ordena de Menor a Mayor por precio\n");
		
		Map<String, Integer> result = 
				golosinas.entrySet().stream()
									.sorted(Entry.comparingByValue())
									.collect(Collectors
												.toMap( Entry::getKey,
														Entry::getValue, 
														(e1,e2) -> e1, 
														LinkedHashMap::new));  
		result.forEach((k,v)->System.out.println(k+" = "+v));
				
		return golosinas;
	}
	
	public void segundaParte(){
		System.out.println("\nLas Golosinas que valen menos de 100 son:"); 
		
		Map<String, Integer> res = 
				golosinas.entrySet().stream()
									.sorted(Entry.comparingByValue())
									.filter(valor -> valor.getValue() < 100)
									.collect(Collectors
											.toMap( Entry::getKey,
													Entry::getValue, 
													(e1,e2) -> e2, 
													LinkedHashMap::new));
		res.forEach((k,v)->System.out.println(k+" = "+v));
	}
}
