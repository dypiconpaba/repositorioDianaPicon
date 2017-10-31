package co.ceiba.service;

public class NotifyPersonService {

	private EmailService emailService;
	
	public String notificar(Persona persona) {
		
	String respuesta="";
	
		try {
		String nombreCompleto=persona.getName()+" "+persona.getLast_name();
		respuesta= emailService.sendEmail("Bienvenido/a: "+nombreCompleto);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return respuesta;
	}
}
