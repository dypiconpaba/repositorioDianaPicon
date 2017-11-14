package co.com.ceiba.parqueadero.traductores;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonTraductor {
	
	private JsonTraductor(){}
	
	public static String convertirAjson(Object objeto) {
		ObjectMapper mapper;
		String resultado = null;
		try {
			mapper = new ObjectMapper();
			resultado = mapper.writeValueAsString(objeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
