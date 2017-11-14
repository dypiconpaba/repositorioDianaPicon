package co.com.ceiba.parqueadero.servicios;


import static  co.com.ceiba.parqueadero.traductores.VehiculoTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.VehiculoTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.VehiculoTraductor.convertPersistencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.parqueadero.dominio.Vehiculo;
import co.com.ceiba.parqueadero.dto.VehiculoDto;
import co.com.ceiba.parqueadero.repositorios.VehiculoRepository;


@Service
public class VehiculoServiceImpl implements VehiculoService {

    private VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void delete(Long id) {
    	vehiculoRepository.delete(id);

    }

    @Override
    public VehiculoDto guardar(VehiculoDto vehiculo) {
    	Vehiculo persistencia = convertPersistencia(vehiculo);
        return convertDto(vehiculoRepository.save(persistencia));
        
    }

	@Override
	public List<VehiculoDto> listAll() {
		List<Vehiculo> documentos = new ArrayList<>();
		vehiculoRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public VehiculoDto getById(Long id) {
		return convertDto(vehiculoRepository.findOne(id));
	}

	@Override
	public VehiculoDto actualizar(VehiculoDto vehiculo) {
		return null;
	}
	
	public VehiculoDto buscarxPlaca(String numeroPlaca){
		return convertDto(vehiculoRepository.findByPlaca(numeroPlaca));
	}
	
	public boolean valida(String numPlaca,String fechaIngreso) {
		
		return valida(numPlaca,fechaIngreso);
	}
		
}
