package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.Persona;
import co.com.ceiba.parqueadero.dto.PersonaDto;


public class PersonaTraductor {
	
	private PersonaTraductor(){}

    public static Persona convertPersistencia(PersonaDto objeto) {
    	Persona persistencia = new Persona();
    	persistencia.setIdpersona(objeto.getId());
    	persistencia.setIddocumento(objeto.getIdDocumento());
    	persistencia.setIdtipodocumento(objeto.getIdTipoDocumento());
    	persistencia.setNombre(objeto.getNombre());
    	persistencia.setApellido(objeto.getApellido());
    	persistencia.setTipopersona(objeto.getTipoPersona());
        return persistencia;
    }
    
    public static PersonaDto convertDto(Persona objeto) {
    	PersonaDto dto = null;
    	if(objeto != null){
	    	dto = new PersonaDto();
	    	dto.setId(objeto.getIdpersona());
	    	dto.setIdDocumento(objeto.getIddocumento());
	    	dto.setIdTipoDocumento(objeto.getIdtipodocumento());
	    	dto.setNombre(objeto.getNombre());
	    	dto.setApellido(objeto.getApellido());
	    	dto.setTipoPersona(objeto.getTipopersona());
    	}
        return dto;
    }
    
    public static List<PersonaDto> convertListaDto(List<Persona>objeto) {
    	List<PersonaDto> dtoLista=new ArrayList<>();
    	PersonaDto dto;
    	for (Persona tipo : objeto) {
    		dto = new PersonaDto();
    		dto.setId(tipo.getIdpersona());
        	dto.setIdDocumento(tipo.getIddocumento());
        	dto.setIdTipoDocumento(tipo.getIdtipodocumento());
        	dto.setNombre(tipo.getNombre());
        	dto.setApellido(tipo.getApellido());
        	dto.setTipoPersona(tipo.getTipopersona());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
}
