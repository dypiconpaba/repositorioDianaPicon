package co.com.ceiba.parqueadero.repositorios;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.ceiba.parqueadero.dominio.Tipovehiculo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TipovehiculoRepositoryTest {


    @Autowired
    private TipovehiculoRepository tipoVehiculoRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistenceGuardar() {
        //given
        Tipovehiculo objeto = new Tipovehiculo();
        objeto.setIdTipoVehiculo(1L);
        objeto.setNombreTipoVehiculo("Carro");

        //when
        tipoVehiculoRepository.save(objeto);

        //then
        Assert.assertNotNull(objeto.getIdTipoVehiculo());
        Tipovehiculo newProduct = tipoVehiculoRepository.findOne(objeto.getIdTipoVehiculo());
        Assert.assertEquals((Long) 1L, newProduct.getIdTipoVehiculo());
    }
    
    @Test
    public void testPersistenceListar() {
        //given
    	Tipovehiculo objeto = new Tipovehiculo();
        objeto.setNombreTipoVehiculo("moto");
        objeto.setIdTipoVehiculo(1L);

        //when
        tipoVehiculoRepository.save(objeto);

        //then
        Iterable <Tipovehiculo>listado=tipoVehiculoRepository.findAll();
        Assert.assertTrue(listado.iterator().hasNext());
      }
}