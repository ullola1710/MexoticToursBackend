package com.mexotic.mexotic.usuario.controller;

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

import com.mexotic.mexotic.usuario.model.Usuario;
import com.mexotic.mexotic.usuario.service.UsuarioService;

@RestController
@RequestMapping (path = "/mexotic/usuarios/") //http:localhost:8080/api/usuarios/
public class UsuarioController {
	private final UsuarioService service;
	
	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	//Get 
	@GetMapping 
	public List<Usuario> getUsuarios(){
		return service.getUsuario();
	}
	
	@GetMapping (path = "{usuarioId}") //http:localhost:8080/api/usuarios/1
	public Usuario getUsuario (@PathVariable("usuarioId")Long idUsuario) {
		return service.getUsuario(idUsuario);
	}
	
	//DELETE
	@DeleteMapping (path = "{usuarioId}") //http:localhost:8080/api/usuarios/1
	public Usuario deleteUsuario (@PathVariable("usuarioId")Long idUsuario) {
		return service.deleteUsuario(idUsuario);
	}
	
	//POST
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return service.addUsuario(usuario);
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
		return service.updateUsuario(idUsuario,nombre, apellido, email, telefono, contrasena, admin, imgUsuario);	
	}
	

}
