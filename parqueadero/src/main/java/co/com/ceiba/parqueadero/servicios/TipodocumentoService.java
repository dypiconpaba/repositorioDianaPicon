package co.com.ceiba.parqueadero.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.dto.TipoDocumentoDto;

public interface TipodocumentoService {

    List<TipoDocumentoDto> listAll();

    TipoDocumentoDto getById(Long id);

    TipoDocumentoDto actualizar(TipoDocumentoDto productForm);

    void delete(Long id);

    TipoDocumentoDto guardar(TipoDocumentoDto productForm);
    
}
