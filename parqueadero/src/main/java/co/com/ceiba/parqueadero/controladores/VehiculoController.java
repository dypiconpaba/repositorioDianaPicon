package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.servicios.VehiculoService;
import co.com.ceiba.parqueadero.dto.VehiculoDto;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController { 
	
    private VehiculoService vehiculoService;

    @Autowired
    public void setProductService(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody VehiculoDto vehiculo){
    	return convertirAjson(vehiculoService.guardar(vehiculo));
    }
    
    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(vehiculoService.listAll());
    }
    
    @RequestMapping(value = "/validaPlaca")
    public String validar(@RequestParam("numPlaca") String numPlaca,@RequestParam("fechaIngreso") String fechaIngreso){
    	String mensaje="";
    	if(!vehiculoService.valida(numPlaca, fechaIngreso)) {
    		mensaje="No puede ingresar porque no está en un dia hábil";
    	}
    	return mensaje;
    }

}
