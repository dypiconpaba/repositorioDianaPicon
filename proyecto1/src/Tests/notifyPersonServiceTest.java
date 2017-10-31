package Tests;

import co.ceiba.service.EmailService;
import co.ceiba.service.NotifyPersonService;
import co.ceiba.service.Persona;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class notifyPersonServiceTest {
	
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup() {
		emailService= new EmailService();
		notifyPersonService= new NotifyPersonService();
	}
	
	@Test
	public void notificarTest() {
		
		Persona persona= new PersonTestDataBuilder().build();
		
		String mensaje=notifyPersonService.notificar(persona);
		
		Assert.assertNotNull(mensaje);
	}

}
