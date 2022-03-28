package cl.desafiolatam.ProductosLimpieza.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.ProductosLimpieza.dao.AlumnoDao;
import cl.desafiolatam.ProductosLimpieza.dao.model.Alumno;
import cl.desafiolatam.ProductosLimpieza.dao.model.Curso;
import cl.desafiolatam.ProductosLimpieza.dao.utils.ConnectionUtil;

public class AlumnoDaoImpl implements AlumnoDao{
	
		//Sin pool de coneccion
	//Connection conexion = crearConexionOracle("localhost", "1521", "orcl", "desrelop1", "1234"); 
	//Connection conexion = crearConexionPostgres("localhost", "5432", "orcl", "productos_limpieza", "1234");
			
	@Override
	public int add(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Alumno> getAll() {
		// TODO Auto-generated method stub
		Connection cn = null;
		List<Alumno> alumnos = null;
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT a.id_alumno, a.nombre, a.apellido, a.fecha_nac, a.curso_id, c.descripcion\r\n"
					+ "	FROM dbo.alumno a, dbo.curso c where a.curso_id = c.id_curso");
			alumnos = new ArrayList<Alumno>();
			while(rset.next()) {
				Alumno alumno = new Alumno();
				Curso curso = new Curso();
				
				curso.setIdCurso(rset.getInt("curso_id"));
				curso.setDescripcion(rset.getString("descripcion"));
				
				alumno.setCurso(curso);
				alumno.setIdAlumno(rset.getInt("id_alumno"));
				alumno.setNombre(rset.getString("nombre"));
				alumno.setApellido(rset.getString("apellido"));
				alumno.setFechaNac(rset.getDate("fecha_nac").toString());
				alumnos.add(alumno);
			}
			
			rset.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return alumnos;
	}

	@Override
	public Alumno getById(int idalumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
