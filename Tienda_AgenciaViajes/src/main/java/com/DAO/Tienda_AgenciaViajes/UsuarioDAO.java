package com.DAO.Tienda_AgenciaViajes;

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_AgenciaViajes.UsuarioVO;
 //Esta clase permite el acceso a la base de datos
public class UsuarioDAO {
	//metodo para consultar usuarios
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM Tabla_Usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setNombre(rs.getString("Nombre_Usuario"));
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usuario")));
				persona.setCorreo(rs.getString("Correo_Usuario"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Contraseña_Usuario"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.Desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No Se Pudo Conectar " + e);
		}
		return miLista;
	}
	
	//Para consultar un usuario  por número de cédula
	public ArrayList<UsuarioVO> ConsultarUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM Tabla_Usuarios WHERE Cedula_Usuario = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setNombre(rs.getString("Nombre_Usuario"));
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usuario")));
				persona.setCorreo(rs.getString("Correo_Usuario"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Contraseña_Usuario"));
				
				miLista.add(persona);
				
			}
			rs.close();
			consulta.close();
			con.Desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error usuario no encontrado: " + e);
		}
		return miLista;
	}
	//Para registrar un usuario
	public void registrarUsuario(UsuarioVO persona)
	{
		Conexion con = new Conexion();
		
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO Tabla_Usuarios Values('"+persona.getNombre()+"','"
					+persona.getCedula()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"
					+persona.getClave()+"')");
			System.out.println("El usuario ha sido adicionado.");
			con.Desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de conexion: " + e);
		}
		
	}
	//Para eliminar un usuario
	public void eliminarUsuario(int documento)
	{
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM Tabla_Usuarios WHERE Cedula_Usuario = ?");
			consulta.setInt(1, documento);
			consulta.executeUpdate();
			System.out.println("El usuario ha sido eliminado.");
			
			consulta.close();
			con.Desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error usuario no encontrado: " + e);
		}
	}
	//Para actualizar un usuario por numero de documento
	public void actualizarUsuario(int documento, String nombre, String correo)
	{
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("UPDATE Tabla_Usuarios SET Nombre_Usuario = ?, Correo_Usuario = ? WHERE Cedula_Usuario = ?");
			consulta.setString(1, nombre);
			consulta.setString(2, correo);
			consulta.setInt(3, documento);
			consulta.executeUpdate();
			System.out.println("El usuario ha sido actualizado.");
			
			consulta.close();
			con.Desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error usuario no encontrado: " + e);
		}
	}
	
}
