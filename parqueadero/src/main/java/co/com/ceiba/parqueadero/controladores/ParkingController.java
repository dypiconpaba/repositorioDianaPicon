package co.com.ceiba.parqueadero.controladores;

import static co.com.ceiba.parqueadero.traductores.JsonTraductor.convertirAjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.dto.ParkingDto;
import co.com.ceiba.parqueadero.servicios.ParkingService;



@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class ParkingController { 
	
    private ParkingService parkingService;
     

    @Autowired
    public void setProductService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@RequestBody ParkingDto parking){
    	return convertirAjson(parkingService.guardar(parking));
    }

    @RequestMapping("/listarAll")
    public String listar(){
        return convertirAjson(parkingService.listAll());
    }
    
    @RequestMapping("/consultar")
    public String consultar(@RequestParam("idCliente") Long idCliente,@RequestParam("fechaIngreso") String fechaIngreso){
        return convertirAjson(parkingService.consultarParking(idCliente, fechaIngreso));
        
    }
    
    @RequestMapping("/calcular")
    public String calculaVehiculos(@RequestParam("id") Long idVehiculo,@RequestParam("fecha") String fechaIngreso){
        return convertirAjson(parkingService.calcula(idVehiculo,fechaIngreso));
        
    }
    
    @RequestMapping("/listarParking")
    public String listarParking(){
        return convertirAjson(parkingService.listarParkingActual());
    }
    
}
