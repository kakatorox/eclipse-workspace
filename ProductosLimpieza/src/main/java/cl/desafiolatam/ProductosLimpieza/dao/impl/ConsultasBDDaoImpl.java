package cl.desafiolatam.ProductosLimpieza.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.ConsultasBDDao;
import cl.desafiolatam.ProductosLimpieza.dao.model.Users;
import cl.desafiolatam.ProductosLimpieza.dao.utils.AdministrarConexion;


public class ConsultasBDDaoImpl implements ConsultasBDDao {

	
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		Users usuario = null;
		ResultSet rSet =null;
		List<Users> listaUsuarios = null;
		Connection cn = null;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "select * from USERS";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			rSet = stmt.executeQuery();
			
			if(cn.isClosed()) {
				System.out.println("cerrado");
			}
			
			listaUsuarios = new ArrayList<Users>();

			while (rSet.next()) {
				usuario = new Users();
				usuario.setId(Integer.parseInt(rSet.getString("ID")));
				usuario.setNombre(rSet.getString("NOMBREUSUARIO"));
				usuario.setPassword(rSet.getString("PASSWORD"));
				listaUsuarios.add(usuario);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				rSet.close();
				AdministrarConexion.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return listaPokemon;
		
		return listaUsuarios;
	}

	
}
