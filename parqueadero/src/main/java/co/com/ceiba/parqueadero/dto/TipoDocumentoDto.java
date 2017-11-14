package co.com.ceiba.parqueadero.dto;

import java.io.Serializable;

public class TipoDocumentoDto  implements Serializable{
	
	private static final long serialVersionUID = 7739131649944202475L;
	
	private Long id;
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
