package co.com.ceiba.parqueadero.servicios;

import java.util.List;
import co.com.ceiba.parqueadero.dto.TarifaDto;


public interface TarifaService {

    List<TarifaDto> listAll();

    TarifaDto getById(Long id);
    
    TarifaDto actualizar(TarifaDto personaForm);

    void delete(Long id);

    TarifaDto guardar(TarifaDto productForm);
     
}
