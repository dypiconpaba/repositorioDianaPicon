package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.Parking;
import co.com.ceiba.parqueadero.dto.ParkingDto;


public class ParkingTraductor {
	
	private ParkingTraductor(){}

    public static Parking convertPersistencia(ParkingDto objeto) {
    	Parking persistencia = new Parking();
    	persistencia.setIdCliente(objeto.getIdCliente());
    	persistencia.setFechaIngreso(objeto.getFechaIngreso());
    	persistencia.setFechaSalida(objeto.getFechaSalida());
    	persistencia.setIdParking(objeto.getIdParking());
    	persistencia.setIdUbicacion(objeto.getIdUbicacion());
    	persistencia.setIdVehiculo(objeto.getIdVehiculo());
    	persistencia.setIdVigilante(objeto.getIdVigilante());
        return persistencia;
    }
    
    public static ParkingDto convertDto(Parking objeto) {
    	ParkingDto dto = null;
    	if(objeto != null){
	    	dto = new ParkingDto();
	    	dto.setIdCliente(objeto.getIdCliente());
	    	dto.setFechaIngreso(objeto.getFechaIngreso());
	    	dto.setFechaSalida(objeto.getFechaSalida());
	    	dto.setIdParking(objeto.getIdParking());
	    	dto.setIdUbicacion(objeto.getIdUbicacion());
	    	dto.setIdVehiculo(objeto.getIdVehiculo());
	    	dto.setIdVigilante(objeto.getIdVigilante());
    	}
        return dto;
    }
    
    public static List<ParkingDto> convertListaDto(List<Parking>objeto) {
    	List<ParkingDto> dtoLista=new ArrayList<>();
    	ParkingDto dto;
    	for (Parking tipo : objeto) {
    		dto = new ParkingDto();
    		dto.setIdCliente(tipo.getIdCliente());
	    	dto.setFechaIngreso(tipo.getFechaIngreso());
	    	dto.setFechaSalida(tipo.getFechaSalida());
	    	dto.setIdParking(tipo.getIdParking());
	    	dto.setIdUbicacion(tipo.getIdUbicacion());
	    	dto.setIdVehiculo(tipo.getIdVehiculo());
	    	dto.setIdVigilante(tipo.getIdVigilante());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
    
  
}
