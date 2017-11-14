package co.com.ceiba.parqueadero.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
	@NamedQuery(name="Persona.findByDocumento", query="SELECT p FROM Persona p WHERE p.iddocumento =:id ")
	})
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idpersona;

	private String apellido;

	private Long iddocumento;

	private Long idtipodocumento;

	private String nombre;

	private String tipopersona;

	public Long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getIddocumento() {
		return this.iddocumento;
	}

	public void setIddocumento(Long iddocumento) {
		this.iddocumento = iddocumento;
	}

	public Long getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

}