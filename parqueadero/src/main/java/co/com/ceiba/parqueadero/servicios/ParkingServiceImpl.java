package co.com.ceiba.parqueadero.servicios;

import static  co.com.ceiba.parqueadero.traductores.ParkingTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.ParkingTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.ParkingTraductor.convertPersistencia;
import static co.com.ceiba.parqueadero.traductores.GeneralTraductor.convertirFecha;
import static co.com.ceiba.parqueadero.traductores.GeneralTraductor.splitConsulta;
import static co.com.ceiba.parqueadero.traductores.VehiculoTraductor.valida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.parqueadero.dominio.Parking;
import co.com.ceiba.parqueadero.dominio.Tipovehiculo;
import co.com.ceiba.parqueadero.dominio.Vehiculo;
import co.com.ceiba.parqueadero.dto.ParkingDto;
import co.com.ceiba.parqueadero.repositorios.ParkingRepository;
import co.com.ceiba.parqueadero.repositorios.TipovehiculoRepository;
import co.com.ceiba.parqueadero.repositorios.VehiculoRepository;

@Service
public class ParkingServiceImpl implements ParkingService {

    private ParkingRepository parkingRepository;
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Autowired
    private TipovehiculoRepository tipovehiculoRepository;
        
    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public void delete(Long id) {
    	parkingRepository.delete(id);

    }

    @Override
    public ParkingDto guardar(ParkingDto parking) {
    	
    	boolean validarCantidad=false;
    	Parking persistencia = convertPersistencia(parking);
    	ParkingDto registrar = null; 
    	String sql=calcula(persistencia.getIdVehiculo(),persistencia.getFechaIngreso());
    	
    	if(sql!=null) {
    		String[] consulta=splitConsulta(sql);
    		validarCantidad=(Integer.valueOf(consulta[1])==1 && Integer.valueOf(consulta[0])<=20) || (Integer.valueOf(consulta[1])==2 && Integer.valueOf(consulta[0])<=10)?false:true;
      	}
    	
    	Vehiculo vehiculo=vehiculoRepository.findOne(persistencia.getIdVehiculo());
    	
    	boolean validarPlaca=valida(vehiculo.getPlaca(),persistencia.getFechaIngreso());
    	
    	if(!validarCantidad && validarPlaca) {
    			registrar=convertDto(parkingRepository.save(persistencia));
    	}
    	
    	return registrar;
    }

	@Override
	public List<ParkingDto> listAll() {
		List<Parking> documentos = new ArrayList<>();
		parkingRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public ParkingDto getById(Long id) {
		return convertDto(parkingRepository.findOne(id));
	}

	@Override
	public ParkingDto actualizar(ParkingDto parking) {
		return null;
	}
	
	public ParkingDto consultarParking(Long idCliente, String fechaIngreso){
		Date fechaIngresaVehiculo= null;
		try {
			fechaIngresaVehiculo = convertirFecha(fechaIngreso);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertDto(parkingRepository.findByClienteFecha(idCliente, fechaIngresaVehiculo));
		
	}
	
	public String calcula(Long idVehiculo, String fechaIngreso){
		Date fechaIngresaVehiculo= null;
		try {
			fechaIngresaVehiculo = convertirFecha(fechaIngreso);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parkingRepository.calcular(idVehiculo, fechaIngresaVehiculo);
		
	}
	
	public String calcula(Long idVehiculo, Date fechaIngreso){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    	
		return calcula(idVehiculo, formatter.format(fechaIngreso));
	}
	
	public List<ParkingDto> findParkingActuales() {
		List<Parking> documentos = new ArrayList<>();
		parkingRepository.findParkingActuales().forEach(documentos::add); 
		return convertListaDto(documentos);
		        
	}
	
	public List<String> listarParkingActual(){
		List<ParkingDto> vehiculos= findParkingActuales();
		List<String> listadoActual=new ArrayList<>();
		long idParking=0;
		
		for (ParkingDto item : vehiculos) {
		   
		   idParking=null==item.getIdParking()?0:item.getIdParking();
		   
		   Vehiculo vehiculo= idParking>0?vehiculoRepository.findOne(idParking):null;
		   
		   if(vehiculo!=null) {
			   Tipovehiculo tipo= tipovehiculoRepository.findOne(vehiculo.getIdtipovehiculo());
			   
			   if(tipo!=null) {
				   listadoActual.add(item.getFechaIngreso()+" , "+vehiculo.getPlaca()+" , "+tipo.getNombreTipoVehiculo());
			   }
		   }
		  
		}
		
		return listadoActual;
	 }
	
}
