package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.dto.TarifaDto;
import co.com.ceiba.parqueadero.servicios.TarifaService;



@RestController
@RequestMapping("/tarifa")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class TarifaController { 
	
    private TarifaService tarifaService;

    @Autowired
    public void setProductService(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody TarifaDto tarifa){
    	return convertirAjson(tarifaService.guardar(tarifa));
    }

    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(tarifaService.listAll());
    }
      
}
