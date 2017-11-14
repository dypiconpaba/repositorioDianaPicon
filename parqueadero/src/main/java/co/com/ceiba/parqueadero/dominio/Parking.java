package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the parking database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Parking.findAll", query="SELECT p FROM Parking p"),
	@NamedQuery(name="Parking.findByClienteFecha", query="SELECT p FROM Parking p WHERE p.idCliente =:idCliente AND p.fechaIngreso =:fechaIngreso "),
	@NamedQuery(name="Parking.calcular", query="SELECT COUNT(p.idVehiculo),v.idtipovehiculo FROM Parking p, Vehiculo v WHERE p.fechaIngreso =:fecha AND v.idVehiculo=p.idVehiculo AND v.idtipovehiculo= (SELECT a.idtipovehiculo FROM Vehiculo a WHERE a.idVehiculo =:id) GROUP BY v.idtipovehiculo "),
	@NamedQuery(name="Parking.findParkingActuales", query="SELECT p FROM Parking p WHERE p.idParking NOT IN  (SELECT f.idParking FROM Factura f) ")
	})
public class Parking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idParking\"")
	private Long idParking;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"fechaIngreso\"")
	private Date fechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"fechaSalida\"")
	private Date fechaSalida;

	@Column(name="\"idCliente\"")
	private Long idCliente;

	
	@Column(name="\"idUbicacion\"")
	private Long idUbicacion;

	@Column(name="\"idVehiculo\"")
	private Long idVehiculo;

	@Column(name="\"idVigilante\"")
	private Long idVigilante;

	public Long getIdParking() {
		return this.idParking;
	}

	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	
	public Long getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(Long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Long getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Long getIdVigilante() {
		return this.idVigilante;
	}

	public void setIdVigilante(Long idVigilante) {
		this.idVigilante = idVigilante;
	}

}