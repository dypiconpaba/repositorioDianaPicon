package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;


import co.com.ceiba.parqueadero.dominio.Tipovehiculo;
import co.com.ceiba.parqueadero.dto.TipoVehiculoDto;


public class TipovehiculoTraductor {
	
	private TipovehiculoTraductor(){}

    public static Tipovehiculo convertPersistencia(TipoVehiculoDto objeto) {
    	Tipovehiculo persistencia = new Tipovehiculo();
    	persistencia.setIdTipoVehiculo(objeto.getId());
    	persistencia.setNombreTipoVehiculo(objeto.getDescripcion());
        return persistencia;
    }
    
    public static TipoVehiculoDto convertDto(Tipovehiculo objeto) {
    	TipoVehiculoDto dto = new TipoVehiculoDto();
    	dto.setId(objeto.getIdTipoVehiculo());
    	dto.setDescripcion(objeto.getNombreTipoVehiculo());
        return dto;
    }
    
    public static List<TipoVehiculoDto> convertListaDto(List<Tipovehiculo>objeto) {
    	List<TipoVehiculoDto> dtoLista=new ArrayList<>();
    	TipoVehiculoDto dto;
    	for (Tipovehiculo tipo : objeto) {
    		dto = new TipoVehiculoDto();
    		dto.setId(tipo.getIdTipoVehiculo());
        	dto.setDescripcion(tipo.getNombreTipoVehiculo());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
}
