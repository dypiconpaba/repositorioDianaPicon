package co.com.ceiba.parqueadero.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.dto.VehiculoDto;


public interface VehiculoService {

    List<VehiculoDto> listAll();

    VehiculoDto getById(Long id);
    
    VehiculoDto buscarxPlaca(String numeroPlaca);

    VehiculoDto actualizar(VehiculoDto personaForm);

    void delete(Long id);

    VehiculoDto guardar(VehiculoDto productForm);
    
    boolean valida(String numPlaca,String fechaIngreso);
    
}
