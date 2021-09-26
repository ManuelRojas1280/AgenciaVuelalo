package com.DAO.Tienda_AgenciaViajes;

import java.sql.*;

public class Conexion {
	
	//Parametros de conexion
	String bd = "BD_Agencia_Vuelalo";
	String Login = "root";
	String Password = "123456789";
	String url = "jdbc:mysql://localhost:3306/"+bd;
	
	Connection con = null;
	
	//Constructor de conexion
	public Conexion() 
	{
		try
		{
			//Obtener el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión
			con = DriverManager.getConnection(url,Login,Password);
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexión; " + e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de conexión; " + e);
		}
		catch(Exception e)
		{
			System.out.println("Error de conexión; " + e);
		}
		if (con != null)
			System.out.println("Conexión a la base de datos " + bd + " Exitosa");
	}
	//Metodo para retornar la conexion
	public Connection getCon()
	{
		return con;
	}
	//Metodo para desconectar la base de datos
	public void Desconectar()
	{
		con = null;
	}
	
}


