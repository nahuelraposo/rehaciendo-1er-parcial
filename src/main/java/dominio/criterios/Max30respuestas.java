package dominio.criterios;

import dominio.pregunta.Pregunta;

public class Max30respuestas extends Criterio{

	@Override
	public void deshabilitar(Pregunta pregunta) {
		pregunta.deshabilitar();
	}
	
}
