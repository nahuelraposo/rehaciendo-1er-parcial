package dominio.consulta;

import java.util.Date;
import java.util.List;

import dominio.pregunta.Pregunta;
import dominio.pregunta.TipoPregunta;
import dominio.validaciones.ErrorDeHabilitacion;
import dominio.validaciones.ErrorValidacionDePregunta;

public class Encuesta extends Consulta {
	
	Pregunta pregunta;
	List<String> respuestas;
	
	public Encuesta(String linkConsulta, Date periodoInicial, Date periodoFinal, Pregunta pregunta) {
		super(linkConsulta, periodoInicial, periodoFinal);
		this.validarPregunta(pregunta);
		this.pregunta = pregunta;
	}
	
	public Encuesta crearEncuesta(String linkConsulta, Date periodoInicial, 
									Date periodoFinal,boolean accesible, 
									Pregunta pregunta) {
		return new Encuesta(linkConsulta,periodoInicial,periodoFinal,pregunta);
	}
	
	public void validarPregunta(Pregunta pregunta) {
		if(!pregunta.esObligatoria() || pregunta.tipoPregunta()==TipoPregunta.ABIERTA)
			throw new ErrorValidacionDePregunta();
	}

	@Override
	public void responder(String respuesta) {
		if(this.getPregunta().estaHabilitada() ) {
			this.getPregunta().validarRespuesta(respuesta);
			this.guardarRespuesta(respuesta);
		}
		else
			throw new ErrorDeHabilitacion();
	}
	
	public void guardarRespuesta(String respuesta) {
		respuestas.add(respuesta);
	}
	
	public Pregunta getPregunta() {
		return pregunta;
	}
	
	public List<String> resultadoDeLaEncuesta(){
		return this.getPregunta().resultadoPregunta();
	}
	
}
