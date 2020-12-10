package dominio.criterios;

import java.util.Calendar;
import java.util.Date;

import dominio.pregunta.Pregunta;
import dominio.validaciones.ErrorFechaPasada;

public class LimiteFecha extends Criterio {
	
	Calendar periodoFinal = Calendar.getInstance();
	Calendar fechaSistema = Calendar.getInstance();
	
	@SuppressWarnings("deprecation")
	public LimiteFecha(Date periodoFinal) {
		this.periodoFinal.set(periodoFinal.getYear(), periodoFinal.getMonth(), periodoFinal.getDay());
	}

	@Override
	public void deshabilitar(Pregunta pregunta) {
		if(periodoFinal.compareTo(fechaSistema)>=0)
			pregunta.deshabilitar();
		//aca habria que poner un timer para que se habilite cuando pase esa fecha
		else
			throw new ErrorFechaPasada();
	}

}
