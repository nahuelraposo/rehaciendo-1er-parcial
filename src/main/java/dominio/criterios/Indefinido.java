package dominio.criterios;

import dominio.pregunta.Pregunta;

public class Indefinido extends Criterio {

	Boolean habilitada;
	
	@Override
	public boolean estaHabilitada(Pregunta pregunta) {
		return this.getHabilitada();
		
	}
	
	public boolean getHabilitada() {
		return habilitada;
	}

	public void cambiarHabilitacion(Boolean x) {
		this.habilitada = x;
	}
}
