package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;
import co.com.ceiba.parqueadero.dominio.Tarifa;
import co.com.ceiba.parqueadero.dto.TarifaDto;


public class TarifaTraductor {
	
	private TarifaTraductor(){}

    public static Tarifa convertPersistencia(TarifaDto objeto) {
    	Tarifa persistencia = new Tarifa();
    	persistencia.setIdTarifa(objeto.getIdTarifa());
    	persistencia.setIdTipoVehiculo(objeto.getIdTipoVehiculo());
    	persistencia.setValorxdia(objeto.getValorxdia());
    	persistencia.setValorxhora(objeto.getValorxhora());
    	
        return persistencia;
    }
    
    public static TarifaDto convertDto(Tarifa objeto) {
    	TarifaDto dto = null;
    	if(objeto != null){
	    	dto = new TarifaDto();
	    	dto.setIdTarifa(objeto.getIdTarifa());
	    	dto.setIdTipoVehiculo(objeto.getIdTipoVehiculo());
	    	dto.setValorxdia(objeto.getValorxdia());
	    	dto.setValorxhora(objeto.getValorxhora());
	    	
    	}
        return dto;
    }
    
    public static List<TarifaDto> convertListaDto(List<Tarifa>objeto) {
    	List<TarifaDto> dtoLista=new ArrayList<>();
    	TarifaDto dto;
    	for (Tarifa tipo : objeto) {
    		dto = new TarifaDto();
    		dto.setIdTarifa(tipo.getIdTarifa());
	    	dto.setIdTipoVehiculo(tipo.getIdTipoVehiculo());
	    	dto.setValorxdia(tipo.getValorxdia());
	    	dto.setValorxhora(tipo.getValorxhora());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
    
   
}
