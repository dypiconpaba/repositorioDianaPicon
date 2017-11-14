package co.com.ceiba.parqueadero.repositorios;


import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.dominio.Tipovehiculo;

public interface TipovehiculoRepository extends CrudRepository<Tipovehiculo, Long> {
	
}
