package dominio.criterios;

import dominio.pregunta.Pregunta;

public class Max30respuestas extends Criterio{

	@Override
	public boolean estaHabilitada(Pregunta pregunta) {
		return pregunta.getRespuestas().size()<30;
		
	}
	
	 /*
		@Override
		public void deshabilitar(Pregunta pregunta) {
			if(pregunta.getRespuestas().size()>=30)
				pregunta.setHabilitacion(false);
			// aca hay que poner un timer para que cuando llegue a las 30 respuestas se deshabilite
		}
	*/
	
}
