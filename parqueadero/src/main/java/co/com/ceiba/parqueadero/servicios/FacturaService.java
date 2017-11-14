package co.com.ceiba.parqueadero.servicios;

import java.util.List;
import co.com.ceiba.parqueadero.dto.FacturaDto;


public interface FacturaService {

    List<FacturaDto> listAll();

    FacturaDto getById(Long id);
    
    FacturaDto actualizar(FacturaDto personaForm);

    void delete(Long id);

    FacturaDto guardar(FacturaDto productForm, String fechaSalida);
     
}
