package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.Tipodocumento;
import co.com.ceiba.parqueadero.dto.TipoDocumentoDto;

public class TipodocumentoTraductor {
	
	private TipodocumentoTraductor(){}

    public static Tipodocumento convertPersistencia(TipoDocumentoDto objeto) {
    	Tipodocumento persistencia = new Tipodocumento();
    	persistencia.setIdtipodocumento(objeto.getId());
    	persistencia.setDescripciontipodocumento(objeto.getDescripcion());
        return persistencia;
    }
    
    public static TipoDocumentoDto convertDto(Tipodocumento objeto) {
    	TipoDocumentoDto dto = new TipoDocumentoDto();
    	dto.setId(objeto.getIdtipodocumento());
    	dto.setDescripcion(objeto.getDescripciontipodocumento());
        return dto;
    }
    
    public static List<TipoDocumentoDto> convertListaDto(List<Tipodocumento>objeto) {
    	List<TipoDocumentoDto> dtoLista=new ArrayList<>();
    	TipoDocumentoDto dto;
    	for (Tipodocumento tipo : objeto) {
    		dto = new TipoDocumentoDto();
    		dto.setId(tipo.getIdtipodocumento());
        	dto.setDescripcion(tipo.getDescripciontipodocumento());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
}
