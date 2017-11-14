package co.com.ceiba.parqueadero.servicios;

import static  co.com.ceiba.parqueadero.traductores.TipodocumentoTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.TipodocumentoTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.TipodocumentoTraductor.convertPersistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.dominio.Tipodocumento;
import co.com.ceiba.parqueadero.dto.TipoDocumentoDto;
import co.com.ceiba.parqueadero.repositorios.TipoDocumentoRepository;

@Service
public class TipodocumentoServiceImpl implements TipodocumentoService {

    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    public TipodocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public void delete(Long id) {
        tipoDocumentoRepository.delete(id);

    }

    @Override
    public TipoDocumentoDto guardar(TipoDocumentoDto tipoDocumentoDto) {
    	Tipodocumento persistencia = convertPersistencia(tipoDocumentoDto);
        return convertDto(tipoDocumentoRepository.save(persistencia));
    }

	@Override
	public List<TipoDocumentoDto> listAll() {
		List<Tipodocumento> documentos = new ArrayList<>();
		tipoDocumentoRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public TipoDocumentoDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDocumentoDto actualizar(TipoDocumentoDto productForm) {
		// TODO Auto-generated method stub
		return null;
	}
}
