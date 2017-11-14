package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idLugar\"")
	private Long idLugar;

	@Column(name="\"nombreLugar\"")
	private String nombreLugar;

	public Long getIdLugar() {
		return this.idLugar;
	}

	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombreLugar() {
		return this.nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

}