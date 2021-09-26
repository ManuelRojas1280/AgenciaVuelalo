package com.Controlador.Tienda_AgenciaViajes;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_AgenciaViajes.UsuarioDAO;
import com.DTO.Tienda_AgenciaViajes.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listaUsuarios")
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
		
		return Dao.listaUsuarios();
	}
	
	@RequestMapping("/consultarUsuarios")
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.ConsultarUsuario(documento);
		
	}
	@RequestMapping("/registrarUsuario")
	public void registrarUsuarios(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}
	@RequestMapping("/eliminarUsuarios")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento);
	}
	@RequestMapping("/actualizarUsuarios")
	public void actualizarUsuario(int documento, String nombre, String correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.actualizarUsuario(documento, nombre, correo);
	}
}
