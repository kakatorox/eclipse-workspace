package cl.desafiolatam.pokemonKAKATO.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.pokemonKAKATO.conexion.Conexion;
import cl.desafiolatam.pokemonKAKATO.dao.PokemonDao;
import cl.desafiolatam.pokemonKAKATO.model.Pokemon;

public class PokemonDaoImpl extends Conexion implements PokemonDao {

	public Statement conectar() throws SQLException {		
		this.crearConexion("localhost", "1521", "orcl", "pokemon", "1234");
		return this.conexion.createStatement();

	}

	public List<Pokemon> getPokemones() {
		Pokemon pokemon = null;
		ResultSet rSet =null;
		List<Pokemon> listaPokemon = null;
		try {
			
			rSet = conectar().executeQuery("select * from POKEMONES p");
			listaPokemon = new ArrayList<Pokemon>();

			while (rSet.next()) {
				pokemon = new Pokemon();
				pokemon.setPokedex(rSet.getInt("ID"));
				pokemon.setNombre(rSet.getString("NOMBRE"));
				pokemon.setTipo1(rSet.getString("TIPO1"));
				pokemon.setTipo2(rSet.getString("TIPO2"));
				listaPokemon.add(pokemon);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				rSet.close();
				this.cerrarConexion();	
				conectar().close();
				if (conectar().isClosed()) {
					System.out.println("conn cerrada");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaPokemon;
	}

	@Override
	public void crearPokemon(int pokedexNum, String nombre, String tipo1, String tipo2) {
		
		try {
			ResultSet rSet = conectar().executeQuery("Insert into pokemon.POKEMONES (ID,NOMBRE,TIPO1,TIPO2) values ("
					+ pokedexNum + ",'" + nombre + "','" + tipo1 + "','" + tipo2 + "')");

			rSet.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				this.cerrarConexion();
				conectar().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updatePokemon(int pokedexNum, String nombre, String tipo1, String tipo2, int pokedexNumActualizar) {
		// TODO Auto-generated method stub
		try {
			
			if (pokedexNumActualizar !=0) {

				ResultSet rSet = conectar()
						.executeQuery("UPDATE pokemon.POKEMONES SET ID  =" + pokedexNumActualizar + " WHERE ID =" + pokedexNum);
				rSet.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
			if (!nombre.equals(null)) {

				ResultSet rSet = conectar()
						.executeQuery("UPDATE pokemon.POKEMONES SET NOMBRE  ='" + nombre + "' WHERE ID =" + pokedexNum);
				rSet.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!tipo1.equals(null)) {

				ResultSet rSet = conectar()
						.executeQuery("UPDATE pokemon.POKEMONES SET TIPO1  ='" + tipo1 + "' WHERE ID =" + pokedexNum);
				rSet.close();
			}
		} catch (Exception e) {
		// TODO: handle exception
		}
		try {
			if (!tipo2.equals(null)) {

				ResultSet rSet = conectar()
						.executeQuery("UPDATE pokemon.POKEMONES SET TIPO2  ='" + tipo2 + "' WHERE ID =" + pokedexNum);
				rSet.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				conectar().close();
				this.cerrarConexion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void borrarPokemon(int pokedexNum) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		try {
			ResultSet rSet = conectar().executeQuery("DELETE FROM pokemon.POKEMONES  WHERE ID=" + pokedexNum);

			rSet.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				this.cerrarConexion();
				conectar().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
