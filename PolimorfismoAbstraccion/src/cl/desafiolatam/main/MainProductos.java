package cl.desafiolatam.main;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.modelo.Menu;
import cl.desafiolatam.modelo.Producto;

public class MainProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p1 = new Producto("Polera" , "9990" , "Polera a rayas"   , "a1", "m" , "mi marca"  , "verde/rojo");
		Producto p2 = new Producto("Poleron", "19990", "Poleron con gorro", "b2", "l" , "mi marca 2", "gris");
		Producto p3 = new Producto("Jeans"  , "29990", "Jeans rectos"     , "c3", "42", "mi marca"  , "azul");
		Producto p4 = new Producto("Poleron", "19990", "Poleron ", "b2", "l" , "mi marca 3", "celeste");
		Producto p5 = new Producto("Polera", "19990", "Poleron ", "a1", "l" , "mi marca 4", "morado");
		Producto p6 = new Producto("Poleron", "19990", "Poleron ", "b2", "l" , "mi marca 25", "gris");
		
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);
		Menu menu = new Menu(productos);
		menu.menuVer();

	}

}
