package co.com.ceiba.parqueadero.dto;

import java.io.Serializable;

public class VehiculoDto implements Serializable{
	
	private static final long serialVersionUID = 7739131649944202475L;
	
	private Long idVehiculo;
	
	private Long cilindraje;

	private Long idtipovehiculo;

	private String marca;

	private String modelo;

	private String placa;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Long getIdtipovehiculo() {
		return idtipovehiculo;
	}

	public void setIdtipovehiculo(Long idtipovehiculo) {
		this.idtipovehiculo = idtipovehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
