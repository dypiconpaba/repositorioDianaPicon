package co.com.ceiba.parqueadero.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.dto.TipoVehiculoDto;;


public interface TipovehiculoService {

    List<TipoVehiculoDto> listAll();

    TipoVehiculoDto getById(Long id);

    TipoVehiculoDto actualizar(TipoVehiculoDto productForm);

    void delete(Long id);

    TipoVehiculoDto guardar(TipoVehiculoDto productForm);
}
