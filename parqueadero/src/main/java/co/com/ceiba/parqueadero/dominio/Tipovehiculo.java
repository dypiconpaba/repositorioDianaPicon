package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipovehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipovehiculo.findAll", query="SELECT t FROM Tipovehiculo t")
public class Tipovehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idTipoVehiculo\"")
	private Long idTipoVehiculo;

	@Column(name="\"nombreTipoVehiculo\"")
	private String nombreTipoVehiculo;
	
	
	public Long getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getNombreTipoVehiculo() {
		return this.nombreTipoVehiculo;
	}

	public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
		this.nombreTipoVehiculo = nombreTipoVehiculo;
	}

}