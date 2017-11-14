package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Vehicle database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v"),
	@NamedQuery(name="Vehiculo.findByPlaca", query="SELECT v FROM Vehiculo v WHERE v.placa =:placa ")
	})
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idVehiculo\"")
	private Long idVehiculo;

	private Long cilindraje;

	private Long idtipovehiculo;

	private String marca;

	private String modelo;

	private String placa;

	public Long getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Long getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(Long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Long getIdtipovehiculo() {
		return this.idtipovehiculo;
	}

	public void setIdtipovehiculo(Long idtipovehiculo) {
		this.idtipovehiculo = idtipovehiculo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}