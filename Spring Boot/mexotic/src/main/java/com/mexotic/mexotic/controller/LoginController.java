package com.mexotic.mexotic.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.config.JwtFilter;
import com.mexotic.mexotic.dto.Token;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/mexotic/login/") //http://localhost:8080/mexotic/login/
public class LoginController {
	
	private final UsuarioService service;
	
	@Autowired
	public LoginController(UsuarioService service) {
		this.service=service;
	}//constructor
	
	
	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) 
									throws ServletException {
		if(service.validateUser(usuario)) {
			return new Token(generateToken(usuario.getEmail()));
		}//if validateUser
		throw new ServletException("Nombre de usuario o constraseña incorrectos ["+ 
		usuario.getEmail()+ "]");
	}//loginUser

	private String generateToken (String email) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 3);
		return Jwts.builder()
				.setSubject(email)
				.claim("role","user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}//generateToken
	
}//class LoginController
