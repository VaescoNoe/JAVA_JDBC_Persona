package mx.com.twg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mx.com.twg.conexion.Conexion;
import mx.com.twg.entity.Persona;

public class PersonaDao {
	
	private final String SQL_INSERT="INSERT INTO persona values(null,?,?)";
	
	private final String SQL_UPDATE="UPDATE persona SET nombre=?,apellido=? WHERE id_persona=?";
	
	private final String SQl_DELETE="DELETE FROM persona WHERE id_persona=?";

	private final String SQl_SELECT="SELECT * FROM persona ORDER BY id_persona";
	
	
	public int insert(String nombre,String apellido) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		int rows = 0;
		
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(SQL_INSERT);
			int index = 1;
			ps.setString(index++, nombre);
			ps.setString(index, apellido);
				System.out.println("Ejecutando query:"+SQL_INSERT);
			rows=ps.executeUpdate();
				System.out.println("Registros afectados:"+rows);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			Conexion.close(ps);
			Conexion.close(conn);
		}
		
		return rows;
	}
	
	public int update(int id,String nombre,String apellido) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		int rows = 0;
		
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(SQL_UPDATE);
			int index = 1;
			ps.setString(index++, nombre);
			ps.setString(index++, apellido);
			ps.setInt(index, id);
				System.out.println("Ejecutando query: "+SQL_UPDATE);
			rows=ps.executeUpdate();
				System.out.println("Registros afectados:"+rows);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			Conexion.close(ps);
			Conexion.close(conn);
		}
		
		return rows;
	}
	
	public int delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		int rows = 0;
		
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(SQl_DELETE);
			ps.setInt(1, id);
				System.out.println("Ejecutando query: "+SQL_UPDATE);
			rows=ps.executeUpdate();
				System.out.println("Registros afectados:"+rows);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			Conexion.close(ps);
			Conexion.close(conn);
		}
		
		return rows;
	} 

	
	public List<Persona> select() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(SQl_SELECT);
			System.out.println("Ejecutando query: "+SQl_SELECT);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				persona = new Persona();
				int index =1;
				persona.setId_persona(rs.getInt(index++));
				persona.setNombre(rs.getString(index++));
				persona.setApellido(rs.getString(index));
				personas.add(persona);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			Conexion.close(rs);
			Conexion.close(ps);
			Conexion.close(conn);
			
		}
		return personas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
