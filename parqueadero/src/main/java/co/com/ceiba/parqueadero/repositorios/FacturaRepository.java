package co.com.ceiba.parqueadero.repositorios;


import org.springframework.data.repository.CrudRepository;
import co.com.ceiba.parqueadero.dominio.Factura;



public interface FacturaRepository extends CrudRepository<Factura, Long> {

	
}
