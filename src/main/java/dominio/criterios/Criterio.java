package dominio.criterios;

import dominio.pregunta.Pregunta;

public abstract class Criterio {

	public void deshabilitar(Pregunta pregunta) {
	}
	
	public void habilitar(Pregunta pregunta) {
		pregunta.habilitar();
	}

}
