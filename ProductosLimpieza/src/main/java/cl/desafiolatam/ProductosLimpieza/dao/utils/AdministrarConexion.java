package cl.desafiolatam.ProductosLimpieza.dao.utils;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.postgresql.Driver;

import oracle.jdbc.driver.*;
import oracle.jdbc.pool.OracleDataSource;
import oracle.ucp.jdbc.PoolDataSource;

public class AdministrarConexion {
//	se debe agregar esto en el pom.xml
//	 <!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 -->
//			<dependency>
//				<groupId>com.oracle.database.jdbc</groupId>
//				<artifactId>ojdbc8</artifactId>
//				<version>19.10.0.0</version>
//			</dependency>
		//	<dependency>
			//	<groupId>org.postgresql</groupId>
			//	<artifactId>postgresql</artifactId>
			//	<version>42.2.10</version>
		//	</dependency>
	private static Context initContext;
	private static Connection conexion = null;
	
	public Connection crearConexionOracle(String equipo,String puerto,String bbdd,String usuario,String contrasenia) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+equipo+":"+puerto+":"+bbdd,usuario,contrasenia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	public Connection crearConexionPostgres(String equipo,String puerto,String bbdd,String usuario,String contrasenia) {
		try {
			DriverManager.registerDriver(new Driver());
			conexion = DriverManager.getConnection("jdbc:postgresql://"+equipo+":"+puerto+":"+bbdd,usuario,contrasenia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	public static Connection generaPoolConexionOracle() throws NamingException, SQLException {
			
		initContext = new InitialContext();
		OracleDataSource ods= (OracleDataSource) initContext.lookup("java:/comp/env/jdbc/OraConnProdLimp");
		conexion = ods.getConnection();
		return conexion;	
	}
	
	public static Connection generaPoolConexionPostGres() throws NamingException, SQLException {
		
		initContext = new InitialContext();
	    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/PGConnProdLimp");
	    conexion = ds.getConnection();
		return conexion;
	}
	
	public static void closeConnection() throws SQLException {
		if(conexion != null) {
			conexion.close();
		}
	}
}
