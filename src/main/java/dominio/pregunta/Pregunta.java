package dominio.pregunta;

import java.util.List;

import dominio.criterios.Criterio;

public abstract class Pregunta {

	TipoPregunta tipoPregunta;
	Boolean esObligatoria;
	List<String> respuestas;
	Boolean respondida;
	Boolean estaHabilitada;
	Criterio criterio;
	
	public  boolean esObligatoria() {
		if(estaHabilitada) 
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
	
	public void habilitar() {
		this.estaHabilitada = true;
	}
	
	public void deshabilitar() {
		this.criterio.deshabilitar(this);
	}
	
	public boolean estaHabilitada() {
		return this.estaHabilitada;
	}
	
	public List<String> getRespuestas(){
		return this.respuestas;
	}
	
}
