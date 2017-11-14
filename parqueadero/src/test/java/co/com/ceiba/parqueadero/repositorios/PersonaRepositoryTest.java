package co.com.ceiba.parqueadero.repositorios;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.ceiba.parqueadero.dominio.Persona;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonaRepositoryTest {


    @Autowired
    private PersonaRepository personaRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistenceGuardar() {
        //given
        Persona objeto = new Persona();
        objeto.setIdtipodocumento(1L);
        objeto.setIddocumento(23L);
        objeto.setNombre("Diana");
        objeto.setApellido("Picon");
        objeto.setTipopersona("Cliente");

        //when
        personaRepository.save(objeto);

        //then
        Assert.assertNotNull(objeto.getIdpersona());
        Persona newProduct = personaRepository.findOne(objeto.getIdpersona());
        Assert.assertEquals((Long) 23L, newProduct.getIddocumento());
    }
    
    @Test
    public void testPersistenceListar() {
        //given
    	Persona objeto = new Persona();
    	objeto.setIdtipodocumento(1L);
        objeto.setIddocumento(23L);
        objeto.setNombre("Diana");
        objeto.setApellido("Picon");
        objeto.setTipopersona("Cliente");

        //when
        personaRepository.save(objeto);

        //then
        Iterable <Persona>listado=personaRepository.findAll();
        Assert.assertTrue(listado.iterator().hasNext());
      }
    
    @Test
    public void testPersistenceconsultar() {
        //given
    	Persona objeto = new Persona();
    	objeto.setIdtipodocumento(1L);
        objeto.setIddocumento(25L);
        objeto.setNombre("Lorena");
        objeto.setApellido("Picon");
        objeto.setTipopersona("Cliente");

        //when
        personaRepository.save(objeto);

        //then
        Persona persona=personaRepository.findByDocumento(23L);
        Assert.assertEquals("Diana", persona.getNombre());
      }
}