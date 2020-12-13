package dominio.criterios;

import java.util.Calendar;
import java.util.Date;

import dominio.pregunta.Pregunta;

public class LimiteFecha extends Criterio {
	
	Calendar periodoFinal = Calendar.getInstance();
	
	@SuppressWarnings("deprecation")
	public LimiteFecha(Date periodoFinal) {
		this.periodoFinal.set(periodoFinal.getYear(), periodoFinal.getMonth(), periodoFinal.getDay());
	}
	
	@Override
	public boolean estaHabilitada(Pregunta pregunta) {
		Calendar fechaSistema = Calendar.getInstance();
		return periodoFinal.compareTo(fechaSistema)<0;
		
	}
	
	/*
	@Override
	public void deshabilitar(Pregunta pregunta) {
		Calendar fechaSistema = Calendar.getInstance();
		if(periodoFinal.compareTo(fechaSistema)>=0)
			pregunta.setHabilitacion(false);
		//aca habria que poner un timer para que se habilite cuando pase esa fecha
		else
			throw new ErrorFechaPasada();
	}
	
	@Override
	public void habilitar(Pregunta pregunta) {
		if(this.estaHabilitada(pregunta))
			pregunta.setHabilitacion(true);
		else
			throw new ErrorDeHabilitacion();
	}
	*/

}
