package co.com.ceiba.parqueadero.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.dominio.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	
	Persona findByDocumento(@Param("id") Long id);
	
}
