package com.mexotic.mexotic.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	public static final String secret = "MexoticToursTuViajeTuVoz";


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest =  (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("Authorization");
		
		String method = httpServletRequest.getMethod();
		String URI = httpServletRequest.getRequestURI();
	
		if ( 
				(( method.equals("POST")  ) && (! URI.contains("/mexotic/usuarios/"))) 
				|| (method.equals("GET")  ) && (! URI.contains("/mexotic/tours/") && ! URI.contains("/mexotic/experiencia/") && ! URI.contains("/mexotic/tours/{tourId}/DetalleDeTour/"))
				|| (method.equals("PUT") )
				|| (method.equals("DELETE") )
				){
					if( (authHeader==null) || (! authHeader.startsWith("Bearer: ")) ) {
						System.out.println("1. Invalid Token");
						throw new ServletException("1. Invalid Token");
					}//if
					String token = authHeader.substring(7);
					try{
						Claims claims = Jwts.parser().setSigningKey(secret)
							.parseClaimsJws(token).getBody();
						claims.forEach(
								(key,value)->System.out.println("Key:[" + key 
										+ "[ Value:["+value+"]") 
								);
					}catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
						System.out.println("2. Invalid Token");
						throw new ServletException("2. Invalid Token");
					}//catch
				}//if method
		
//		if  (usuario.isAdmin() && (
//				(( method.equals("POST") )  && (! URI.contains("/mexotic/"))) || 
//				((method.equals("GET") )  && (! URI.contains("/mexotic/"))) ||
//				((method.equals("PUT") )  && (! URI.contains("/mexotic/"))) || 
//				((method.equals("DELETE")) && (! URI.contains("/mexotic/"))) 
//				)){
//					if( (authHeader==null) || (! authHeader.startsWith("Bearer: ")) ) {
//						System.out.println("1. Invalid Token");
//						throw new ServletException("1. Invalid Token");
//					}//if
//					String token = authHeader.substring(7);
//					try{
//						Claims claims = Jwts.parser().setSigningKey(secret)
//							.parseClaimsJws(token).getBody();
//						claims.forEach(
//								(key,value)->System.out.println("Key:[" + key 
//										+ "[ Value:["+value+"]") 
//								);
//					}catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
//						System.out.println("2. Invalid Token");
//						throw new ServletException("2. Invalid Token");
//					}//catch
//				}//if method
//		
		
		
		chain.doFilter(request, response);
	}//doFilter
	
	
	
}//class JwtFilter

