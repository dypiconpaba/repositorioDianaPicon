package co.ceiba.service;

public class EmailService {

	public String sendEmail(String mensaje) {
		String mensajeCorreo=null;
		
		try {
			
			mensajeCorreo="Email enviado con msje: "+mensaje;
			
		}catch(Exception e) {
			
		}
		return mensajeCorreo;
	}
}
