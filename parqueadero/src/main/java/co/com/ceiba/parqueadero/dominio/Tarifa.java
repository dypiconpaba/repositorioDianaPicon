package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idTarifa\"")
	private Long idTarifa;

	@Column(name="\"idTipoVehiculo\"")
	private Long idTipoVehiculo;

	private double valorxhora;
	
	private double valorxdia;

	
	public double getValorxdia() {
		return valorxdia;
	}

	public void setValorxdia(double valorxdia) {
		this.valorxdia = valorxdia;
	}

	public Long getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Long getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public double getValorxhora() {
		return this.valorxhora;
	}

	public void setValorxhora(double valorxhora) {
		this.valorxhora = valorxhora;
	}

}