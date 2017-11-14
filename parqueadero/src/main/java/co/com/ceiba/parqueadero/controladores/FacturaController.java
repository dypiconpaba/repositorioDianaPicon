package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.dto.FacturaDto;
import co.com.ceiba.parqueadero.servicios.FacturaService;



@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController { 
	
    private FacturaService facturaService;

    @Autowired
    public void setProductService(FacturaService facturaService) {
        this.facturaService = facturaService;
    }
    
    @RequestMapping(value = "/registrarSalida")
    public String guardar(@RequestBody FacturaDto factura,@RequestParam("fechaSalida") String fechaSalida){
    	return convertirAjson(facturaService.guardar(factura,fechaSalida));
    }

    @RequestMapping("/listar")
    public String listar(){
        return convertirAjson(facturaService.listAll());
    }
      
}
