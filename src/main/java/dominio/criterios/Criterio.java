package dominio.criterios;

import dominio.pregunta.Pregunta;

public abstract class Criterio {

	public boolean estaHabilitada(Pregunta pregunta) {
		return true;
	}

}
