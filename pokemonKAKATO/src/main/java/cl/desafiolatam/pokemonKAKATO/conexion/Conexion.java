package cl.desafiolatam.pokemonKAKATO.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Conexion {
	
	protected Connection conexion;
	
	public Connection crearConexion(String equipo,String puerto,String bbdd,String usuario,String contrasenia) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+equipo+":"+puerto+":"+bbdd,usuario,contrasenia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

	public void cerrarConexion() throws SQLException {		
		if (conexion != null) {			
				if (!conexion.isClosed()) {
					conexion.close();
				}
			} 		
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
	
	
	
	
}
