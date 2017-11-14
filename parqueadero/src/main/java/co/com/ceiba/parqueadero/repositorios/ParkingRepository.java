package co.com.ceiba.parqueadero.repositorios;

import java.util.Date;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.dominio.Parking;


public interface ParkingRepository extends CrudRepository<Parking, Long> {
	
	Parking findByClienteFecha(@Param("idCliente") Long idCliente,@Param("fechaIngreso") Date fechaIngreso);
	
	String calcular(@Param("id") Long idVehiculo,@Param("fecha") Date fechaIngreso);
	
	Iterable<Parking>findParkingActuales();

}
