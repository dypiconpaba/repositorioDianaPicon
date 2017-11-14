package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.dto.TipoDocumentoDto;
import co.com.ceiba.parqueadero.servicios.TipodocumentoService;

@RestController
@RequestMapping("/tipodocumento")
public class TipodocumentoController { 
	
    private TipodocumentoService tipodocumentoService;

    @Autowired
    public void setProductService(TipodocumentoService tipodocumentoService) {
        this.tipodocumentoService = tipodocumentoService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody TipoDocumentoDto tipodocumento){
    	return convertirAjson(tipodocumentoService.guardar(tipodocumento));
    }

    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(tipodocumentoService.listAll());
    }

    
}
