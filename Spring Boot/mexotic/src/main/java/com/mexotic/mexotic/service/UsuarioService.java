package com.mexotic.mexotic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mexotic.mexotic.dto.ChangedataUser;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.repository.UsuariosRepository;



@Service
public class UsuarioService {
	private final UsuariosRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuariosRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}//getUsuarios

	public Usuario getUsuario(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElseThrow(()-> new IllegalArgumentException("El usuario con el id [" + idUsuario+ "] no existe"));
	}//getUsuario
		
		
	public Usuario deleteUsuario(Long idUsuario) {
		Usuario user = null;
		if(usuarioRepository.existsById(idUsuario)) {
			user = usuarioRepository.findById(idUsuario).get();
			usuarioRepository.deleteById(idUsuario);
			}//if
			return user;
		}//deleteUsuario

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		if (user.isEmpty()) {
			usuarioRepository.save(usuario);
			}else {
				usuario = null;
			}//else
			return usuario;
		}//addUsuario

	public Usuario updateUsuario(Long idUsuario, String telefono,String imgUsuario) {
			Usuario user = null;
			if(usuarioRepository.existsById(idUsuario)) {
				user = usuarioRepository.findById(idUsuario).get();
				if(telefono!=null) user.setTelefono(telefono);
				if(imgUsuario!=null) user.setImgUsuario(imgUsuario);
				usuarioRepository.save(user);
				}//if
			return user;
		}//updateUsuario

	public Usuario updateUser(Long idUsuario, ChangedataUser changedataUser) {
		if(!usuarioRepository.existsById(idUsuario)) {
			return null;
		}
		Usuario user = usuarioRepository.findById(idUsuario).get();
		
		if(changedataUser.getNcontrasena() != null && !changedataUser.getNcontrasena().isEmpty()) {
			if(changedataUser.getContrasena() == null || changedataUser.getContrasena().isEmpty()) {
				throw new RuntimeException("Debe proporcionar la contraseña actual para cambiarla");
			}//if contraseña actual
			if(!user.getContrasena().equals(changedataUser.getContrasena())) {
				throw new RuntimeException("La contraseña acual es incorrecta");
			}//no coinciden las contraseñas
			user.setContrasena(changedataUser.getNcontrasena());
		}//actualiza la contraseña
		
		
		if(changedataUser.getTelefono() != null && !changedataUser.getTelefono().isEmpty()) {
			user.setTelefono(changedataUser.getTelefono());
		}//actualizacion de telefono
		
		if(changedataUser.getImgUsuario() != null && !changedataUser.getImgUsuario().isEmpty()) {
			user.setImgUsuario(changedataUser.getImgUsuario());
		}//actualizacion de imgUsuario
		
		return usuarioRepository.save(user);
	}
}//class UsuarioService

