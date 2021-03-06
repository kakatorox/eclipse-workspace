package cl.desafiolatam.desafiorelop1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.desafiorelop1.conexion.AdministrarConexion;
import cl.desafiolatam.desafiorelop1.dao.ConsultasBDDao;
import cl.desafiolatam.desafiorelop1.dto.UsuarioDto;
import cl.desafiolatam.desafiorelop1.model.Usuario;

public class ConsultasBDDaoImpl extends AdministrarConexion implements ConsultasBDDao {

	@Override
	public List<Usuario> getUsers() {
		// TODO Auto-generated method stub
		Connection conexion = crearConexion("localhost", "1521", "orcl", "desrelop1", "1234");
		
		Usuario usuario = null;
		String consultaSql = "select * from USERS f";
		List<Usuario> listaUsuarios = null;
		ResultSet rSet =null;
		
		try(PreparedStatement stmt = conexion.prepareStatement(consultaSql)){
		
			if(conexion.isClosed()) {
				System.out.println("cerrado");
			}
			rSet = stmt.executeQuery();
			listaUsuarios = new ArrayList<Usuario>();

			while (rSet.next()) {
				usuario = new Usuario();
				usuario.setId(Integer.parseInt(rSet.getString("ID")));
				usuario.setNombre(rSet.getString("NOMBRE"));
				listaUsuarios.add(usuario);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				rSet.close();
				this.cerrarConexion();	
				conexion.close();
				if (conexion.isClosed()) {
					System.out.println("conn cerrada");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return listaPokemon;
		
		return listaUsuarios;
	}	
}
