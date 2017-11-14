package co.com.ceiba.parqueadero.dto;

import java.io.Serializable;


public class FacturaDto  implements Serializable{
	
	private static final long serialVersionUID = 7739131649944202475L;
	
	private Long idFactura;
	
	private Long idParking;

	private Long numeroHoras;

	private double totalPagar;
	
	private Long idTarifa;

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Long getIdParking() {
		return idParking;
	}

	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}

	public Long getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Long numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

}
