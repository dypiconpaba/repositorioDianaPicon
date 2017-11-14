package co.com.ceiba.parqueadero.servicios;

import static  co.com.ceiba.parqueadero.traductores.PersonaTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.PersonaTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.PersonaTraductor.convertPersistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.dominio.Persona;
import co.com.ceiba.parqueadero.dto.PersonaDto;
import co.com.ceiba.parqueadero.repositorios.PersonaRepository;


@Service
public class PersonaServiceImpl implements PersonaService {

    private PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void delete(Long id) {
    	personaRepository.delete(id);

    }

    @Override
    public PersonaDto guardar(PersonaDto persona) {
    	Persona persistencia = convertPersistencia(persona);
        return convertDto(personaRepository.save(persistencia));
    }

	@Override
	public List<PersonaDto> listAll() {
		List<Persona> documentos = new ArrayList<>();
		personaRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public PersonaDto getById(Long id) {
		return convertDto(personaRepository.findOne(id));
	}

	@Override
	public PersonaDto actualizar(PersonaDto persona) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PersonaDto buscarxDocumento(Long idDocumento){
		return convertDto(personaRepository.findByDocumento(idDocumento));
	}
}
