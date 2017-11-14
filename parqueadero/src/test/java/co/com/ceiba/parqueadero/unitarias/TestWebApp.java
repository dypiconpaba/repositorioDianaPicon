package co.com.ceiba.parqueadero.unitarias;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import co.com.ceiba.parqueadero.controladores.PersonaController;
import co.com.ceiba.parqueadero.dominio.Persona;
import co.com.ceiba.parqueadero.repositorios.PersonaRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonaController.class , secure= false)
public class TestWebApp{
	
	@MockBean
    private PersonaRepository repository;
	
	@MockBean
    private PersonaController controller;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEmployee() throws Exception {
		List<Persona> personas = new ArrayList<>();
		personas.add(this.personaPrueba());		
		Mockito.when(repository.findAll()).thenReturn(personas);
		MvcResult result = mockMvc.perform(get("/persona/listar").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
		System.out.println(result.getResponse().getStatus());
		assertNotNull(result.getResponse());
		assertEquals(result.getResponse().getStatus(), 200);
	}
	
	public Persona personaPrueba() {
    	
   	 Persona per = new Persona();  
        per.setIdpersona(1L);
        per.setIdtipodocumento(1L);
        per.setIddocumento(23L);
        per.setNombre("Alex");
        per.setApellido("Rodriguez");
        
        return per;
   }

}