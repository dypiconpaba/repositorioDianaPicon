package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.servicios.TipovehiculoService;
import co.com.ceiba.parqueadero.dto.TipoVehiculoDto;

@RestController
@RequestMapping("/tipovehiculo")
public class TipovehiculoController { 
	
    private TipovehiculoService tipovehiculoService;

    @Autowired
    public void setProductService(TipovehiculoService tipovehiculoService) {
        this.tipovehiculoService = tipovehiculoService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody TipoVehiculoDto tipovehiculo){
    	return convertirAjson(tipovehiculoService.guardar(tipovehiculo));
    }
    
    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(tipovehiculoService.listAll());
    }

}
