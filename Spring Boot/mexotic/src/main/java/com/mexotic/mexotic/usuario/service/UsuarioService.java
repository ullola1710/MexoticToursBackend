package com.mexotic.mexotic.usuario.service;

import java.util.ArrayList;
import java.util.List;

import com.mexotic.mexotic.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {
	
	private final ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	@Autowired
	public UsuarioService() {
		
		listaUsuarios.add (new Usuario("Brandy", "Medina", "medina@gmail.com","3358796542","Password_1", true, "brandy.jpg"));
		listaUsuarios.add (new Usuario("Jade", "Ullola", "ullola@gmail.com","3325469875","Password_2", true, "jade.jpg"));
		listaUsuarios.add (new Usuario("Abigail", "Ramírez", "ramirez@gmail.com","3387564123","Password_3", true, "abigail.jpg"));
		listaUsuarios.add (new Usuario("Isabel", "Romero", "romero@gmail.com","3398325469","Password_4", true, "isabel.jpg"));
		listaUsuarios.add (new Usuario("Marian", "Tejeda", "tejeda@gmail.com","3354870213","Password_5", true, "marian.jpg"));
		listaUsuarios.add (new Usuario("Mariana", "González", "gonzalez@gmail.com","3325146987","Password_6", true, "mariana.jpg"));
		listaUsuarios.add (new Usuario("Maritere", "Montiel", "montiel@gmail.com","3325469872","Password_7", true, "maritere.jpg"));
		listaUsuarios.add (new Usuario("Miriam", "Vega", "vega@gmail.com","3303259710","Password_8", true, "miriam.jpg"));
		listaUsuarios.add (new Usuario("Miguel", "R.", "miguelr@gmail.com","5512345678","Password_9", false, "miguel.jpg"));
		listaUsuarios.add (new Usuario("Ana", "L.", "anal@gmail.com","5523456789","Password_10", false, "ana.jpg"));
		listaUsuarios.add (new Usuario("Roberto", "G.", "robertog@gmail.com","5534567890","Password_11", false, "roberto.jpg"));
		listaUsuarios.add (new Usuario("Sofía", "M. ", "sofiam@gmail.com","5545678901","Password_12", false, "sofia.jpg"));
		listaUsuarios.add (new Usuario("Carlos", "P.", "carlosp@gmail.com","5556789012","Password_13", false, "carlos.jpg"));
		}//usuarioService
	
		public List<Usuario> getUsuario(){
			return listaUsuarios;
			
		}//getUsuario

		public Usuario getUsuario(Long idUsuario) {
			Usuario tmpUser = null;
			for(Usuario user : listaUsuarios) {
				if(user.getIdUsuario() == idUsuario) {
					tmpUser = user;
					break;
				}//if
			}//foreach
			return tmpUser;
		}//getUsuario
		
		
		public Usuario deleteUsuario(Long idUsuario) {
			Usuario tmpUser = null;
			for(Usuario user : listaUsuarios) {
				if(user.getIdUsuario().equals(idUsuario)) {
					tmpUser = user;
					listaUsuarios.remove(user);
					break;
				}//if
			}//foreach
			return tmpUser;
		}//deleteUsuario

		public Usuario addUsuario(Usuario usuario) {
			listaUsuarios.add(usuario);
			return usuario;
		}//addUsuario

		public Usuario updateUsuario(Long idUsuario, String nombre, String apellido, String email, String telefono,
				String contrasena, Boolean admin, String imgUsuario) {
			Usuario tmpUser = null;
			for(Usuario user : listaUsuarios) {
				if(user.getIdUsuario().equals(idUsuario)) {
					tmpUser = user;
					if(nombre!=null)user.setNombre(nombre);
					if(apellido!=null)user.setApellido(apellido);
					if(email!=null) user.setEmail(email);
					if(telefono!=null) user.setTelefono(telefono);
					if(contrasena!=null) user.setContrasena(contrasena);
					if(admin!=null) user.setAdmin(admin);
					if(imgUsuario!=null) user.setImgUsuario(imgUsuario);
				}//if
			}//foreach
			return tmpUser;
		}//updateUsuario
}//class UsuarioService

