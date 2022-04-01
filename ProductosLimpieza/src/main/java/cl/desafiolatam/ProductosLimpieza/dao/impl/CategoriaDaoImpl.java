package cl.desafiolatam.ProductosLimpieza.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.ProductosLimpieza.dao.CategoriaDao;
import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dao.utils.AdministrarConexion;

public class CategoriaDaoImpl implements CategoriaDao{

	@Override
	public List<Categoria> getAllCategorias() {
		List<Categoria> listaCategoria = null; 
		Connection cn = null;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "select * from Categoria";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			ResultSet rSet = stmt.executeQuery();

//			Statement st = cn.createStatement();
//			ResultSet rset = st.executeQuery("SELECT a.id_alumno, a.nombre, a.apellido, a.fecha_nac, a.curso_id, c.descripcion\r\n"
//					+ "	FROM dbo.alumno a, dbo.curso c where a.curso_id = c.id_curso");
			listaCategoria = new ArrayList<Categoria>();
			while(rSet.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setId_categoria(rSet.getInt("id_categoria"));
				categoria.setNombre_categoria(rSet.getString("nombre_categoria"));
				listaCategoria.add(categoria);
				
			}
			rSet.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				AdministrarConexion.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return listaCategoria;
	}
	
	@Override
	public int deleteCategoria(int idCat) {
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA = ?";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setInt(1, idCat);
			resultado=stmt.executeUpdate();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				AdministrarConexion.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		
		return resultado;
	}
	
	@Override
	public int updateCategoria(int idCat, String nombreCat) {
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "UPDATE CATEGORIA SET NOMBRE_CATEGORIA= ? WHERE ID_CATEGORIA = ?";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setString(1, nombreCat);
			stmt.setInt(2, idCat);
			resultado=stmt.executeUpdate();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				AdministrarConexion.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return resultado;		
	}
	
	@Override
	public int createCategoria(int idCat, String nombreCat) {
		
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "INSERT INTO PRODUCTOS_LIMPIEZA.CATEGORIA\r\n"
					+ "(ID_CATEGORIA, NOMBRE_CATEGORIA) VALUES (?, ?)";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setInt(1, idCat);
			stmt.setString(2, nombreCat);
			resultado=stmt.executeUpdate();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				AdministrarConexion.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
		return resultado;
	}
	
}
