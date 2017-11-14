package co.com.ceiba.parqueadero.traductores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class GeneralTraductor {
	
	private GeneralTraductor(){}

    public static Date convertirFecha(String fecha) throws ParseException{
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    	return formatter.parse(fecha.replaceAll("Z$", "+0000"));
    }
    
    public static String[] splitConsulta(String consultaRealizada) {
    	return consultaRealizada.split(",");
    }
    
    public static long cantidadHoras(Date fechaInicio, Date fechaFin) {
    	
    	Calendar fechaInicial=convertirCalendar(fechaInicio);
    	Calendar fechaFinal=convertirCalendar(fechaFin);
        long totalMinutos=0;
        totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60/60);
    
        return totalMinutos;
     }
    
    public static int obtenerDiaFecha(String fechaIngreso) {
    	int dia=0;
    	Calendar calendar=convertirCalendar(fechaIngreso);
    	dia=calendar.get(Calendar.DAY_OF_WEEK);
		
    	return dia;
    }
    
    public static Calendar convertirCalendar(String fecha) {
    	Calendar calendar=Calendar.getInstance();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    	Date fechaParseo;
			try {
				fechaParseo = formatter.parse(fecha.replaceAll("Z$", "+0000"));
				calendar.setTime(fechaParseo);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		return calendar;
    }
    
    public static Calendar convertirCalendar(Date fecha) {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(fecha);
    	return calendar;
		
    }
}
