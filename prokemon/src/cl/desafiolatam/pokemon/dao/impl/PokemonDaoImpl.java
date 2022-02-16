package cl.desafiolatam.pokemon.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.pokemon.dao.PokemonDao;
import cl.desafiolatam.pokemon.model.Pokemon;
import oracle.jdbc.driver.OracleDriver;


public class PokemonDaoImpl implements PokemonDao{
	public Connection connection = null;
    public Statement stmt = null;
    public Pokemon pokemon = null;
   
	public List<Pokemon> getPokemones(){
		 	
	        try {
				DriverManager.registerDriver(new OracleDriver());
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclkr","ashketchup","1234");
				
				stmt = connection.createStatement();
				
				if (!stmt.isClosed()) {
					System.out.println("Statement Creado");
				}
				
				ResultSet rSet = stmt.executeQuery("select * from POKEMONES p");
				List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
				
				 while (rSet.next()) {
					pokemon = new Pokemon();
					pokemon.setPokedex(Integer.parseInt(rSet.getString("ID")));
					pokemon.setNombre(rSet.getString("NOMBRE"));
					pokemon.setTipo1(rSet.getString("TIPO1"));
					pokemon.setTipo2(rSet.getString("TIPO2"));
					listaPokemon.add(pokemon);
				}
				rSet.close();
				return listaPokemon;				
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
	        
	        return null;
	      
	}
	
	@Override
		public void crearPokemon(int pokedexNum, String nombre, String tipo1, String tipo2) {
			
			 try {
					DriverManager.registerDriver(new OracleDriver());
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclkr","ashketchup","1234");
					
					stmt = connection.createStatement();
					
					if (!stmt.isClosed()) {
						System.out.println("Statement Creado");
					}
					
					ResultSet rSet = stmt.executeQuery("Insert into ASHKETCHUP.POKEMONES (ID,NOMBRE,TIPO1,TIPO2) "
														+ "values ("+pokedexNum+",'"+nombre+"','"+tipo1+"','"+tipo2+"');");
					
					rSet.close();
									
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

	@Override
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclkr","ashketchup","1234");
			
			stmt = connection.createStatement();
			
			if (!stmt.isClosed()) {
				System.out.println("Statement Creado");
			}
			
			if (!nombre.equals(null)) {
				
				ResultSet rSet = stmt.executeQuery("UPDATE POST SET TITULO  ='"+nombre+"' WHERE ID ="+pokedexNum+";");
				rSet.close();
			}
			if (!nombre.equals(null)) {
				
				ResultSet rSet = stmt.executeQuery("UPDATE POST SET TITULO  ='"+tipo1+"' WHERE ID ="+pokedexNum+";");
				rSet.close();
			}
			if (!nombre.equals(null)) {
	
				ResultSet rSet = stmt.executeQuery("UPDATE POST SET TITULO  ='"+tipo2+"' WHERE ID ="+pokedexNum+";");
				rSet.close();
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

	@Override
	public void borrarPokemon(int pokedexNum) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclkr","ashketchup","1234");
			
			stmt = connection.createStatement();
			
			if (!stmt.isClosed()) {
				System.out.println("Statement Creado");
			}
			
			ResultSet rSet = stmt.executeQuery("DELETE FROM pokemones  WHERE id="+pokedexNum+");");
			
			rSet.close();
							
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
