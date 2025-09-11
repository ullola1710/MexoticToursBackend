package com.mexotic.mexotic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mexotic.mexotic.config.JwtFilter;

@SpringBootApplication
public class MexoticApplication {

	public static void main(String[] args) {
		SpringApplication.run(MexoticApplication.class, args);
	}
	
	//activa el filtro
		@Bean
		public FilterRegistrationBean<JwtFilter> jwtFilter(){
			FilterRegistrationBean<JwtFilter> registrationBean =
					new FilterRegistrationBean<JwtFilter>(); 
			registrationBean.setFilter(new JwtFilter());
			registrationBean.addUrlPatterns("/mexotic/usuarios/*");
			registrationBean.addUrlPatterns("/mexotic/tours/*");
			registrationBean.addUrlPatterns("/mexotic/experiencia/*");
			registrationBean.addUrlPatterns("/mexotic/tours/{tourId}/detalle-tour/*");
			return registrationBean;
		}//jwtFilter

}