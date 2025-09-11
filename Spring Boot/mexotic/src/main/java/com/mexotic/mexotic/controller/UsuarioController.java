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
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.dto.ChangedataUser;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.UsuarioService;

@RestController
@RequestMapping(path = "/mexotic/usuarios/") //http:localhost:8080/mexotic/usuarios/
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	//Get 
	@GetMapping 
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping (path = "{userId}") //http:localhost:8080/mexotic/usuarios/1
	public Usuario getUsuario (@PathVariable("userId")Long idUsuario) {
		return usuarioService.getUsuario(idUsuario);
	}
	
	//DELETE
	@DeleteMapping (path = "{userId}") //http:localhost:8080/mexotic/usuarios/1
	public Usuario deleteUsuario (@PathVariable("userId")Long idUsuario) {
		return usuarioService.deleteUsuario(idUsuario);
	}
	
	//POST
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	//PUT 
	@PutMapping(path = "{userId}") //http:localhost:8080/mexotic/usuarios/1
	public Usuario updateUsuario(@PathVariable("userId") Long idUsuario,
			@RequestBody ChangedataUser ChangedataUser) {
		return usuarioService.updateUser(idUsuario,ChangedataUser);	
	}
	


}//UsuarioController
