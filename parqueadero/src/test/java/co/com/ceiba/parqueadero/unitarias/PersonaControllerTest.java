package co.com.ceiba.parqueadero.unitarias;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.controladores.PersonaController;
import co.com.ceiba.parqueadero.dominio.Persona;
import co.com.ceiba.parqueadero.dto.PersonaDto;
import co.com.ceiba.parqueadero.repositorios.PersonaRepository;
import co.com.ceiba.parqueadero.servicios.PersonaService;
import co.com.ceiba.parqueadero.servicios.PersonaServiceImpl;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
public class PersonaControllerTest {

	    // Mockito is now managing the fixture (no need to explicitly instntiate it in test)
	    @InjectMocks
	    private PersonaController fixture;
	    
	    @Mock
	    private PersonaService service;

	    // Mockito framework is now also managing the repository dependency that fixture has
	    @Mock
	    private PersonaRepository mockShipwreckRepository;

	    @Before
	    public void setup() throws Exception {
	        // Initialize all mock objects when test runs.
	        // Mockito will automatically setup deps with this line (similar to how spring manages deps).
	        // Mockito looks at @InjectMocks and @Mock's and determines if they need to be pushed together.
	    	List<Persona> personas = new ArrayList<>();
	    	personas.add(this.personaPrueba());	
	    	when(mockShipwreckRepository.findAll()).thenReturn(personas);
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGet() throws Exception {
	        
	    	List<Persona> personas = new ArrayList<>();
	    	personas.add(this.personaPrueba());	
	    	
	    	List<PersonaDto> personasDto = new ArrayList<>();
	    	personasDto.add(new PersonaDto());
			
//	    	when(mockShipwreckRepository.findAll()).thenReturn(personas);
//	    	when(service.listarTodos()).thenReturn(personas);

	    	String result = fixture.listar();

	        // junit assertion
//	        assertEquals(123L, result.getId().longValue());

	        // hamcrest assertion
	        assertNotNull(result);

//	        verify(mockShipwreckRepository).findAll();
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

