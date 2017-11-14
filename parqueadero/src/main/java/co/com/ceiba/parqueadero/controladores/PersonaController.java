package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.dto.PersonaDto;
import co.com.ceiba.parqueadero.servicios.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController { 
	
    private PersonaService personaService;

    @Autowired
    public void setProductService(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody PersonaDto persona){
    	return convertirAjson(personaService.guardar(persona));
    }

    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(personaService.listAll());
    }
    
    @RequestMapping("/consultarPersona/{idDocumento}")
    public String consultar(@PathVariable Long idDocumento){
        return convertirAjson(personaService.buscarxDocumento(idDocumento));
    }

    
}
