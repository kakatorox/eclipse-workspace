package cl.desafiolatam.pokemonKAKATO.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Conexion {
	
	public Connection connection = null;
	
	public Conexion(String equipo,String puerto,String bbdd,String usuario,String contrasenia) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@"+equipo+":"+puerto+":"+bbdd,usuario,contrasenia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
