package dominio.criterios;

import dominio.pregunta.Pregunta;

public class Indefinido extends Criterio {

	@Override
	public void deshabilitar(Pregunta pregunta) {
		if(pregunta.getRespuestas().size()>=30)
			pregunta.deshabilitar();
	}
	
}
