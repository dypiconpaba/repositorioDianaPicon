package co.com.ceiba.parqueadero.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.dto.PersonaDto;

public interface PersonaService {

    List<PersonaDto> listAll();

    PersonaDto getById(Long id);
    
    PersonaDto buscarxDocumento(Long idDocumento);

    PersonaDto actualizar(PersonaDto personaForm);

    void delete(Long id);

    PersonaDto guardar(PersonaDto productForm);
    
}
