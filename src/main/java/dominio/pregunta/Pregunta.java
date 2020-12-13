package dominio.pregunta;

import java.util.List;

import dominio.criterios.Criterio;

public abstract class Pregunta {

	TipoPregunta tipoPregunta;
	Boolean esObligatoria;
	List<String> respuestas;
	Boolean respondida;
	Criterio criterio;
	
	public  boolean esObligatoria() {
		if(this.estaHabilitada()) 
			return getEsObligatoria();
		else 
			return false;
	}
	
	public boolean getEsObligatoria( ){
		return esObligatoria;
		}

	
	public TipoPregunta tipoPregunta() {
		return tipoPregunta;
	}
	
	public List<String> resultadoPregunta(){
		return this.getRespuestas();
	}
	

	public void validarRespuesta(String respuesta) {}
	
	public void guardarRespuesta(String respuesta) {
		this.getRespuestas().add(respuesta);
	}
	
	public boolean fueRespondida() {
		return respondida;
	}
	
	public boolean estaHabilitada() {
		return this.criterio.estaHabilitada(this);
	}
	
	public List<String> getRespuestas(){
		return this.respuestas;
	}
	
}
