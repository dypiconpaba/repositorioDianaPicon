package co.com.ceiba.parqueadero.servicios;

import static  co.com.ceiba.parqueadero.traductores.TarifaTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.TarifaTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.TarifaTraductor.convertPersistencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.parqueadero.dominio.Tarifa;
import co.com.ceiba.parqueadero.dto.TarifaDto;
import co.com.ceiba.parqueadero.repositorios.TarifaRepository;

@Service
public class TarifaServiceImpl implements TarifaService {

    private TarifaRepository tarifaRepository;
    
    @Autowired
    public TarifaServiceImpl(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    @Override
    public void delete(Long id) {
    	tarifaRepository.delete(id);

    }

    @Override
    public TarifaDto guardar(TarifaDto tarifa) {
    	Tarifa persistencia = convertPersistencia(tarifa);
    	return convertDto(tarifaRepository.save(persistencia));
    	
    }

	@Override
	public List<TarifaDto> listAll() {
		List<Tarifa> documentos = new ArrayList<>();
		tarifaRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public TarifaDto getById(Long id) {
		return convertDto(tarifaRepository.findOne(id));
	}

	@Override
	public TarifaDto actualizar(TarifaDto factura) {
		return null;
	}
	
		
}
