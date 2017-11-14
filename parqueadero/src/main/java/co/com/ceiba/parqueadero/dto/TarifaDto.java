package co.com.ceiba.parqueadero.dto;

import java.io.Serializable;


public class TarifaDto  implements Serializable{
	
	private static final long serialVersionUID = 7739131649944202475L;
	
	private Long idTarifa;
	
	private Long idTipoVehiculo;

	private double valorxhora;
	
	private double valorxdia;

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public double getValorxhora() {
		return valorxhora;
	}

	public void setValorxhora(double valorxhora) {
		this.valorxhora = valorxhora;
	}

	public double getValorxdia() {
		return valorxdia;
	}

	public void setValorxdia(double valorxdia) {
		this.valorxdia = valorxdia;
	}

}
