package co.com.ceiba.parqueadero.repositorios;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.com.ceiba.parqueadero.dominio.Vehiculo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehiculoRepositoryTest {


    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistenceGuardar() {
        //given
        Vehiculo objeto = new Vehiculo();
        objeto.setPlaca("MYT-340");
        objeto.setIdtipovehiculo(1L);
        objeto.setCilindraje(20L);
        
        //when
        vehiculoRepository.save(objeto);

        //then
        Assert.assertNotNull(objeto.getIdVehiculo());
        Vehiculo newProduct = vehiculoRepository.findOne(objeto.getIdVehiculo());
        Assert.assertEquals("MYT-340", newProduct.getPlaca());
    }
    
    @Test
    public void testPersistenceListar() {
        //given
    	Vehiculo objeto = new Vehiculo();
    	objeto.setPlaca("MYT-344");
        objeto.setIdtipovehiculo(2L);
        objeto.setCilindraje(20L);


        //when
        vehiculoRepository.save(objeto);

        //then
        Iterable <Vehiculo>listado=vehiculoRepository.findAll();
        Assert.assertTrue(listado.iterator().hasNext());
      }
}