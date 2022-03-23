package cl.desafiolatam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.conexion.Conexion;
import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.model.Saludo;

public class ConsultasBDDaoImpl extends Conexion implements ConsultasBDDao {

	public Statement conectar() throws SQLException {		
		this.crearConexion("localhost", "1521", "orcl", "saludo", "1234");
		return this.conexion.createStatement();

	}
	
	@Override
	public List<Saludo> getSaludos() {
		// TODO Auto-generated method stub
		Saludo saludo = null;
		ResultSet rSet =null;
		List<Saludo> listaSaludos = null;
		try {
			
			if(conectar().isClosed()) {
				System.out.println("cerrado");
			}
			rSet = conectar().executeQuery("select * from SALUDOHOLA sh");
			listaSaludos = new ArrayList<Saludo>();

			while (rSet.next()) {
				saludo = new Saludo();
				saludo.setId(rSet.getString("ID"));
				saludo.setTexto(rSet.getString("DECIR"));
				saludo.setPais(rSet.getString("PAIS"));
				listaSaludos.add(saludo);
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
		
		return listaSaludos;
	}

	

	
}
