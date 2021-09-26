package com.Controlador.Tienda_AgenciaViajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_AgenciaViajes.Conexion;

@SpringBootApplication
public class TiendaAgenciaViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaAgenciaViajesApplication.class, args);
		//Se deja comentariado ya que no se necesita que aparezca el aviso
		//Conexion conn = new Conexion();
		//conn.getCon();
	}

}
