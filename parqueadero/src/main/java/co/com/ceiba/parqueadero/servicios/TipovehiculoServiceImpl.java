package co.com.ceiba.parqueadero.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.parqueadero.dto.TipoVehiculoDto;
import co.com.ceiba.parqueadero.dominio.Tipovehiculo;
import co.com.ceiba.parqueadero.repositorios.TipovehiculoRepository;
import static co.com.ceiba.parqueadero.traductores.TipovehiculoTraductor.convertListaDto;
import static  co.com.ceiba.parqueadero.traductores.TipovehiculoTraductor.convertDto;
import static  co.com.ceiba.parqueadero.traductores.TipovehiculoTraductor.convertPersistencia;

/**
 * Created by dp on 1/10/17.
 */
@Service
public class TipovehiculoServiceImpl implements TipovehiculoService {

    private TipovehiculoRepository tipovehiculoRepository;

    @Autowired
    public TipovehiculoServiceImpl(TipovehiculoRepository tipovehiculoRepository) {
        this.tipovehiculoRepository = tipovehiculoRepository;
    }

    @Override
    public void delete(Long id) {
    	tipovehiculoRepository.delete(id);

    }

    @Override
    public TipoVehiculoDto guardar(TipoVehiculoDto tipovehiculo) {
    	Tipovehiculo persistencia = convertPersistencia(tipovehiculo);
        return convertDto(tipovehiculoRepository.save(persistencia));
        
    }
    

	@Override
	public List<TipoVehiculoDto> listAll() {
		List<Tipovehiculo> documentos = new ArrayList<>();
		tipovehiculoRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);
	}

	@Override
	public TipoVehiculoDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVehiculoDto actualizar(TipoVehiculoDto productForm) {
		// TODO Auto-generated method stub
		return null;
	}
}
