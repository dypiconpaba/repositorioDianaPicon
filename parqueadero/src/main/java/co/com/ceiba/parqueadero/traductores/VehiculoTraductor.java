package co.com.ceiba.parqueadero.traductores;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.Vehiculo;
import co.com.ceiba.parqueadero.dto.VehiculoDto;

import static co.com.ceiba.parqueadero.traductores.GeneralTraductor.obtenerDiaFecha;


public class VehiculoTraductor {
	
	private VehiculoTraductor(){}

    public static Vehiculo convertPersistencia(VehiculoDto objeto) {
    	Vehiculo persistencia = new Vehiculo();
    	persistencia.setCilindraje(objeto.getCilindraje());
    	persistencia.setMarca(objeto.getMarca());
    	persistencia.setIdVehiculo(objeto.getIdVehiculo());
    	persistencia.setIdtipovehiculo(objeto.getIdtipovehiculo());
    	persistencia.setModelo(objeto.getModelo());
    	persistencia.setPlaca(objeto.getPlaca());
    	
        return persistencia;
    }
    
    public static VehiculoDto convertDto(Vehiculo objeto) {
    	VehiculoDto dto = null;
    	if(objeto != null){
	    	dto = new VehiculoDto();
	    	dto.setCilindraje(objeto.getCilindraje());
	    	dto.setMarca(objeto.getMarca());
	    	dto.setIdVehiculo(objeto.getIdVehiculo());
	    	dto.setIdtipovehiculo(objeto.getIdtipovehiculo());
	    	dto.setModelo(objeto.getModelo());
	    	dto.setPlaca(objeto.getPlaca());
    	}
        return dto;
    }
    
    public static List<VehiculoDto> convertListaDto(List<Vehiculo>objeto) {
    	List<VehiculoDto> dtoLista=new ArrayList<>();
    	VehiculoDto dto;
    	for (Vehiculo tipo : objeto) {
    		dto = new VehiculoDto();
    		dto.setCilindraje(tipo.getCilindraje());
	    	dto.setMarca(tipo.getMarca());
	    	dto.setIdVehiculo(tipo.getIdVehiculo());
	    	dto.setIdtipovehiculo(tipo.getIdtipovehiculo());
	    	dto.setModelo(tipo.getModelo());
	    	dto.setPlaca(tipo.getPlaca());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
    
    
    public static boolean valida(String numPlaca,String fechaIngreso) {
		boolean valida=true;
		int diaSemana = obtenerDiaFecha(fechaIngreso);
		
		if("A".equals(numPlaca.substring(0, 1)) && (diaSemana==1 || diaSemana==2)) {
				valida=false;
		}
		
		return valida;
	}
    
    public static boolean valida(String numPlaca,Date fechaIngreso) {
		boolean valida=true;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaIngreso);
		int diaSemana=calendar.get(Calendar.DAY_OF_WEEK);
		
		if("A".equals(numPlaca.substring(0, 1)) && (diaSemana==1 || diaSemana==2)) {
				valida=false;
		}
		
		return valida;
	}

}
