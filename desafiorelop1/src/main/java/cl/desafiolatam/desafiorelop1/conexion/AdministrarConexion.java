package cl.desafiolatam.desafiorelop1.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import oracle.jdbc.driver.*;

public class AdministrarConexion {
//	se debe agregar esto en el pom.xml
//	 <!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 -->
//			<dependency>
//				<groupId>com.oracle.database.jdbc</groupId>
//				<artifactId>ojdbc8</artifactId>
//				<version>19.10.0.0</version>
//			</dependency>
	
	protected Connection conexion;
	
	public Connection crearConexion(String equipo,String puerto,String bbdd,String usuario,String contrasenia) {
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","desafio","1234");
			
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
