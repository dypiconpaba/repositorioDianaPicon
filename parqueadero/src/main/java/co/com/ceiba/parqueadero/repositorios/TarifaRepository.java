package co.com.ceiba.parqueadero.repositorios;


import org.springframework.data.repository.CrudRepository;
import co.com.ceiba.parqueadero.dominio.Tarifa;



public interface TarifaRepository extends CrudRepository<Tarifa, Long> {

	
}
