package cl.desafiolatam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.conexion.Conexion;
import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.model.Users;

public class ConsultasBDDaoImpl extends Conexion implements ConsultasBDDao {

	public Statement conectar() throws SQLException {		
		this.crearConexion("localhost", "1521", "orcl", "factura", "1234");
		return this.conexion.createStatement();

	}
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		Users usuario = null;
		ResultSet rSet =null;
		List<Users> listaUsuarios = null;
		try {
			
			if(conectar().isClosed()) {
				System.out.println("cerrado");
			}
			rSet = conectar().executeQuery("select * from USERS f");
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
		//return listaPokemon;
		
		return listaUsuarios;
	}

	
}
