package cl.desafiolatam.ProductosLimpieza.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.ProductosLimpieza.dao.ProductoDao;
import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dao.utils.AdministrarConexion;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;

public class ProductoDaoImpl implements ProductoDao{

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> listaProductos = null; 
		Connection cn = null;
	              
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "SELECT * FROM PRODUCTO p, CATEGORIA C"
					+ " WHERE p.ID_CATEGORIA = c.ID_CATEGORIA";
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			ResultSet rSet = stmt.executeQuery();
			listaProductos = new ArrayList<Producto>();
			while(rSet.next()) {
				Categoria categoria = new Categoria();
				Producto producto = new Producto();
											
				
				producto.setIdProducto(rSet.getInt("ID_producto"));
				producto.setNombreProducto(rSet.getString("nombre_producto"));
				producto.setPrecioProducto(rSet.getInt("precio_producto"));
				producto.setDescripcionProducto(rSet.getString("DESCRIPCION_producto"));
				
				categoria.setId_categoria(rSet.getInt("ID_CATEGORIA"));
				categoria.setNombre_categoria(rSet.getString("nombre_categoria"));

				producto.setCategoria(categoria);	
				
				listaProductos.add(producto);				
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
		return listaProductos;
	}
	
	@Override 
	public int deleteProducto(int idProd) {
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "DELETE FROM PRODUCTO WHERE ID_PRODUCTO = ?";
			
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setInt(1, idProd);
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
	public int createProducto(String nombre,int precioProd, String desProd,int idCat) {
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "INSERT INTO PRODUCTOS_LIMPIEZA.PRODUCTO\r\n"
					+ "(NOMBRE_PRODUCTO, PRECIO_PRODUCTO, DESCRIPCION_PRODUCTO, ID_CATEGORIA) "
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setString(1, nombre);
			stmt.setInt(2, precioProd);
			stmt.setString(3, desProd);
			stmt.setInt(4, idCat);
			
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
	public int updateProducto(int idProducto,String nomProd,int precioProd, String desProd,int idCat) {
		Connection cn = null;
		int resultado=0;
		try {
			cn = AdministrarConexion.generaPoolConexionOracle();
			String consultaSql = "UPDATE PRODUCTO SET NOMBRE_PRODUCTO=?,"
								+ " PRECIO_PRODUCTO=?,"
								+ " DESCRIPCION_PRODUCTO=?, "
								+ " ID_CATEGORIA=?"
								+ "	WHERE ID_PRODUCTO = ?";
			
			PreparedStatement stmt = cn.prepareStatement(consultaSql);
			stmt.setString(1, nomProd);
			stmt.setInt(2, precioProd);
			stmt.setString(3, desProd);
			stmt.setInt(4, idCat);
			stmt.setInt(5, idProducto);
			
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
