package cl.desafiolatam.dbconnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Connection connection = null;
        Statement stmt = null;
        try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclkr","ashketchup","1234");
			
			stmt = connection.createStatement();
			
			if (!stmt.isClosed()) {
				System.out.println("Statement Creado");
			}
			
			ResultSet rSet = stmt.executeQuery("select * from POKEMONES");
			
			while (rSet.next()) {
				System.out.print("| ");
				System.out.print(rSet.getString("ID"));
				System.out.print(" | ");
				System.out.print(rSet.getString("NOMBRE"));
				System.out.print(" | ");
				System.out.print(rSet.getString("TIPO1"));
				System.out.print(" | ");
				System.out.print(rSet.getString("TIPO2"));
				System.out.println(" |");
			}
			
			rSet = stmt.executeQuery("select * from POKEDEX");
			
			while (rSet.next()) {
				System.out.print("| ");
				System.out.print(rSet.getString("ID"));
				System.out.print(" | ");
				System.out.print(rSet.getString("ID_POKEMON"));
				System.out.print(" | ");
				System.out.print(rSet.getString("FECHA_CAPTURA"));
				System.out.print(" | ");
				System.out.print(rSet.getString("LUGAR"));
				System.out.print(" | ");
				System.out.print(rSet.getString("HUEVO"));
				System.out.print(" | ");
				System.out.print(rSet.getString("PESO"));
				System.out.print(" | ");
				System.out.print(rSet.getString("ESTATURA"));
				System.out.println(" |");
			}
			rSet = stmt.executeQuery("select * from pokemones pok inner join pokedex pdex on pok.id = pdex.id_pokemon");
			
			while (rSet.next()) {
				System.out.print("| ");
				System.out.print(rSet.getString("NOMBRE"));
				System.out.print(" | ");
				System.out.print(rSet.getString("TIPO1"));
				System.out.print(" | ");
				System.out.print(rSet.getString("TIPO2"));
				System.out.print(" | ");
				System.out.print(rSet.getString("FECHA_CAPTURA"));
				System.out.print(" | ");
				System.out.print(rSet.getString("LUGAR"));
				System.out.print(" | ");
				System.out.print(rSet.getString("HUEVO"));
				System.out.print(" | ");
				System.out.print(rSet.getString("PESO"));
				System.out.print(" | ");
				System.out.print(rSet.getString("ESTATURA"));
				System.out.println(" |");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
					if(connection!= null && !connection.isClosed()) {
						connection.close();
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
