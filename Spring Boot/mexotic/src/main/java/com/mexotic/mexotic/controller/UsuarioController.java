package com.mexotic.mexotic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.UsuarioService;

@RestController
@RequestMapping (path = "/mexotic/usuarios/") //http:localhost:8080/api/usuarios/
public class UsuarioController {
	private final UsuarioService usuariosService;
	
	@Autowired
	public UsuarioController(UsuarioService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	//Get 
	@GetMapping 
	public List<Usuario> getUsuarios(){
		return usuariosService.getUsuario();
	}
	
	@GetMapping (path = "{usuarioId}") //http:localhost:8080/api/usuarios/1
	public Usuario getUsuario (@PathVariable("usuarioId")Long idUsuario) {
		return usuariosService.getUsuario(idUsuario);
	}
	
	//DELETE
	@DeleteMapping (path = "{usuarioId}") //http:localhost:8080/api/usuarios/1
	public Usuario deleteUsuario (@PathVariable("usuarioId")Long idUsuario) {
		return usuariosService.deleteUsuario(idUsuario);
	}
	
	//POST
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuariosService.addUsuario(usuario);
	}//addUsuario
	
	//PUT 
	@PutMapping(path = "{usuarioId}") //http:localhost:8080/api/usuarios/1
	public Usuario updateUsuario(@PathVariable ("usuarioId") Long idUsuario,
			@RequestParam (required = false)String nombre,
			@RequestParam (required = false)String apellido,
			@RequestParam(required = false) String email,
			@RequestParam (required = false)String telefono,
			@RequestParam (required = false)String contrasena,
			@RequestParam(required = false) Boolean admin,
			@RequestParam (required = false) String imgUsuario) {
		return usuariosService.updateUsuario(idUsuario,nombre, apellido, email, telefono, contrasena, admin, imgUsuario);	
	}
	

}
