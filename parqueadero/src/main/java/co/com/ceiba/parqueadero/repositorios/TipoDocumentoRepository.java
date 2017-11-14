package co.com.ceiba.parqueadero.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.dominio.Tipodocumento;

public interface TipoDocumentoRepository extends CrudRepository<Tipodocumento, Long> {
	
	
}
