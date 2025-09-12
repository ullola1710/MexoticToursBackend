package com.mexotic.mexotic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mexotic.mexotic.model.Tour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class MexoticApplicationTests {

    // Opcional: si tu backend tiene autenticación JWT
    private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYUB5YWhvby5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTc1NzYyODEyNSwiZXhwIjoxNzU3NjM4OTI1fQ.0n4hJm0G-obq02GoqkChJU4YmUZ5LDM3Kn6VLQJ82E4"; 

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Se prueba GET de tours")
    void pruebaGETALL() throws Exception {
        this.mockMvc.perform(get("/mexotic/tours/"))
            .andDo(print())
            .andExpect(status().isOk());
    }
    
    @Test
    @DisplayName("Se prueba GET del tour con ID 1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/mexotic/tours/1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(
					containsString("CDMX")));
	}
    
    @Test
    @Disabled("Probado una vez, deshabilitado para ocasiones subsecuentes")
    @DisplayName("Se prueba DELETE del tour con ID 1")
    void pruebaDELETE() throws Exception {
        this.mockMvc.perform(delete("/mexotic/tours/1")
                .header("Authorization", token))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @Disabled("Probado una vez, deshabilitado para ocasiones subsecuentes")
    @DisplayName("Se prueba PUT para actualizar tour con ID 2")
    void pruebaPUT() throws Exception {
        this.mockMvc.perform(put("/mexotic/tours/2?nombre=Tour&precio=299.99")
                .header("Authorization", token))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Tour")))
            .andExpect(content().string(containsString("299.99")));
    }

    @Test
    @DisplayName("Se prueba POST para crear un nuevo tour")
    void pruebaPOST() throws Exception {
        Tour tour = new Tour();
        tour.setNombre("Tour de Prueba");
        tour.setCiudad("Queretaro");
        tour.setImg("imagenPrueba");
        tour.setImgPortada("Imagen");
        tour.setDescripcion("Descripción del tour de prueba");
        tour.setPrecio(199.99);
        tour.setDuracion("3 horas");
        tour.setPrecioExclusivo(500.25);
        tour.setIncluye("Propinas");
        tour.setCategoria(com.mexotic.mexotic.model.Categoria.Cultura); 
        tour.setEstado(com.mexotic.mexotic.model.Estado.Queretaro); 

        this.mockMvc.perform(post("/mexotic/tours/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(tour))
                .header("Authorization", token))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Tour de Prueba")));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
