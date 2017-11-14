package co.com.ceiba.parqueadero.repositorios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.ceiba.parqueadero.dominio.Tipodocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TipodocumentoRepositoryTest {


    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistenceGuardar() {
        //given
        Tipodocumento objeto = new Tipodocumento();
        objeto.setDescripciontipodocumento("prueba");
        objeto.setIdtipodocumento(1L);

        //when
        tipoDocumentoRepository.save(objeto);

        //then
        Assert.assertNotNull(objeto.getIdtipodocumento());
        Tipodocumento newProduct = tipoDocumentoRepository.findOne(objeto.getIdtipodocumento());
        Assert.assertEquals((Long) 1L, newProduct.getIdtipodocumento());
    }
    
    @Test
    public void testPersistenceListar() {
        //given
        Tipodocumento objeto = new Tipodocumento();
        objeto.setDescripciontipodocumento("prueba");
        objeto.setIdtipodocumento(1L);

        //when
        tipoDocumentoRepository.save(objeto);

        //then
        Iterable <Tipodocumento>listado=tipoDocumentoRepository.findAll();
        Assert.assertTrue(listado.iterator().hasNext());
      }
}