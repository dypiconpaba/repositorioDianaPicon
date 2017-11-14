package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idFactura\"")
	private Long idFactura;

	@Column(name="\"idParking\"")
	private Long idParking;

	@Column(name="\"numeroHoras\"")
	private Long numeroHoras;

	@Column(name="\"totalPagar\"")
	private double totalPagar;
	
	@Column(name="\"idTarifa\"")
	private Long idTarifa;

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Long getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Long getIdParking() {
		return this.idParking;
	}

	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}

	public Long getNumeroHoras() {
		return this.numeroHoras;
	}

	public void setNumeroHoras(Long numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public double getTotalPagar() {
		return this.totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

}