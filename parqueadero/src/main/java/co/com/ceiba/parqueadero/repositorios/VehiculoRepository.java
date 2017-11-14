package co.com.ceiba.parqueadero.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import co.com.ceiba.parqueadero.dominio.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
	
	Vehiculo findByPlaca(@Param("placa")String numPlaca);

}
