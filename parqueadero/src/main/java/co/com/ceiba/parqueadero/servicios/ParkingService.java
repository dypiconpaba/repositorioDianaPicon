package co.com.ceiba.parqueadero.servicios;

import java.util.List;
import co.com.ceiba.parqueadero.dto.ParkingDto;


public interface ParkingService {

    List<ParkingDto> listAll();

    ParkingDto getById(Long id);
    
    ParkingDto consultarParking(Long idCliente, String fechaIngreso);

    ParkingDto actualizar(ParkingDto personaForm);

    void delete(Long id);

    ParkingDto guardar(ParkingDto productForm);
    
    String calcula(Long idVehiculo,String fechaIngreso);
    
    Iterable<ParkingDto> findParkingActuales();
    
    List<String> listarParkingActual();
}
