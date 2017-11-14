package co.com.ceiba.parqueadero.dto;

import java.io.Serializable;
import java.util.Date;


public class ParkingDto  implements Serializable{
	
	private static final long serialVersionUID = 7739131649944202475L;
	
	private Long idParking;
	
	private Date fechaIngreso;

	private Date fechaSalida;

	private Long idCliente;

	private Long idUbicacion;

	private Long idVehiculo;

	private Long idVigilante;

	public Long getIdParking() {
		return idParking;
	}

	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Long getIdVigilante() {
		return idVigilante;
	}

	public void setIdVigilante(Long idVigilante) {
		this.idVigilante = idVigilante;
	}

	

}
