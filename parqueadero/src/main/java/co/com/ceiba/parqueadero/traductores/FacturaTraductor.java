package co.com.ceiba.parqueadero.traductores;

import java.util.ArrayList;
import java.util.List;
import co.com.ceiba.parqueadero.dominio.Factura;
import co.com.ceiba.parqueadero.dto.FacturaDto;


public class FacturaTraductor {
	
	private FacturaTraductor(){}

    public static Factura convertPersistencia(FacturaDto objeto) {
    	Factura persistencia = new Factura();
    	persistencia.setIdFactura(objeto.getIdFactura());
    	persistencia.setIdParking(objeto.getIdParking());
    	persistencia.setIdTarifa(objeto.getIdTarifa());
    	persistencia.setNumeroHoras(objeto.getNumeroHoras());
    	persistencia.setTotalPagar(objeto.getTotalPagar());
    	
        return persistencia;
    }
    
    public static FacturaDto convertDto(Factura objeto) {
    	FacturaDto dto = null;
    	if(objeto != null){
	    	dto = new FacturaDto();
	    	dto.setIdFactura(objeto.getIdFactura());
	    	dto.setIdParking(objeto.getIdParking());
	    	dto.setIdTarifa(objeto.getIdTarifa());
	    	dto.setNumeroHoras(objeto.getNumeroHoras());
	    	dto.setTotalPagar(objeto.getTotalPagar());
    	}
        return dto;
    }
    
    public static List<FacturaDto> convertListaDto(List<Factura>objeto) {
    	List<FacturaDto> dtoLista=new ArrayList<>();
    	FacturaDto dto;
    	for (Factura tipo : objeto) {
    		dto = new FacturaDto();
    		dto.setIdFactura(tipo.getIdFactura());
	    	dto.setIdParking(tipo.getIdParking());
	    	dto.setIdTarifa(tipo.getIdTarifa());
	    	dto.setNumeroHoras(tipo.getNumeroHoras());
	    	dto.setTotalPagar(tipo.getTotalPagar());
        	dtoLista.add(dto);
    	}
        return dtoLista;
    }
   
}
