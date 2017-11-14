package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idtipodocumento;

	private String descripciontipodocumento;

	public Long getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getDescripciontipodocumento() {
		return this.descripciontipodocumento;
	}

	public void setDescripciontipodocumento(String descripciontipodocumento) {
		this.descripciontipodocumento = descripciontipodocumento;
	}

}