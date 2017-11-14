package co.com.ceiba.parqueadero.servicios;

import static  co.com.ceiba.parqueadero.traductores.FacturaTraductor.convertDto;
import static co.com.ceiba.parqueadero.traductores.FacturaTraductor.convertListaDto;
import static co.com.ceiba.parqueadero.traductores.FacturaTraductor.convertPersistencia;
import static co.com.ceiba.parqueadero.traductores.GeneralTraductor.convertirFecha;
import static co.com.ceiba.parqueadero.traductores.GeneralTraductor.cantidadHoras;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.parqueadero.dominio.Factura;
import co.com.ceiba.parqueadero.dominio.Parking;
import co.com.ceiba.parqueadero.dominio.Tarifa;
import co.com.ceiba.parqueadero.dto.FacturaDto;
import co.com.ceiba.parqueadero.repositorios.FacturaRepository;
import co.com.ceiba.parqueadero.repositorios.ParkingRepository;
import co.com.ceiba.parqueadero.repositorios.TarifaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

    private FacturaRepository facturaRepository;
    
    @Autowired
    private ParkingRepository parkingRepository;
    
    @Autowired
    private TarifaRepository tarifaRepository;
   
    
    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public void delete(Long id) {
    	facturaRepository.delete(id);

    }

    @Override
    public FacturaDto guardar(FacturaDto factura, String fechaSalida) {
    	
    	Factura persistencia = convertPersistencia(factura);
    	Parking parking=parkingRepository.findOne(factura.getIdParking());
    	long cantidadHoras=0;
    	Tarifa tarifa=tarifaRepository.findOne(persistencia.getIdTarifa());
    	double tarifaHora=tarifa.getValorxhora();
    	double tarifaDia=tarifa.getValorxdia();
    	double total=0;
    	try {
			parking.setFechaSalida(null==convertirFecha(fechaSalida)?new Date():convertirFecha(fechaSalida));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	cantidadHoras=cantidadHoras(parking.getFechaIngreso(), parking.getFechaSalida()); 
    	
    	if(cantidadHoras<=9) {
    		total=tarifaHora*cantidadHoras;
    	}else if(cantidadHoras<=24){
    		total=tarifaDia;
    	}else {
    		total+=tarifaDia*((double)cantidadHoras/24);
    		total+=tarifaHora*(cantidadHoras%24);
    	}
    	
    	persistencia.setNumeroHoras(cantidadHoras);
    	persistencia.setTotalPagar(total);
    	
    	return convertDto(facturaRepository.save(persistencia));
    	
    }

	@Override
	public List<FacturaDto> listAll() {
		List<Factura> documentos = new ArrayList<>();
		facturaRepository.findAll().forEach(documentos::add); 
        return convertListaDto(documentos);

	}

	@Override
	public FacturaDto getById(Long id) {
		return convertDto(facturaRepository.findOne(id));
	}

	@Override
	public FacturaDto actualizar(FacturaDto factura) {
		return null;
	}
	
		
}
