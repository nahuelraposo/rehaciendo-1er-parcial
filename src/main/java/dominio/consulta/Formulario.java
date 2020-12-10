package dominio.consulta;

import java.util.Date;
import java.util.List;

import dominio.pregunta.*;
import dominio.validaciones.ErrorFormularioVacio;
import dominio.validaciones.ErrorValidacionFormulario;

public class Formulario extends Consulta {

	List<Pregunta> preguntas;
	List<Pregunta> preguntasRespondidas;

	public Formulario(String linkConsulta, Date periodoInicial, Date periodoFinal, boolean esAccesible,
			List<Pregunta> preguntas) {
		super(linkConsulta, periodoInicial, periodoFinal, esAccesible);
		this.preguntas = preguntas;
	}

	public Formulario crearFormulario(String linkConsulta, Date periodoInicial, Date periodoFinal, boolean accesible,
			List<Pregunta> preguntas) {
		return new Formulario(linkConsulta, periodoInicial, periodoFinal, accesible, preguntas);
	}

	public void responder(String respuesta) {
		if (preguntas.size() > 1) {
			this.realizarProcesosDeRespuesta(respuesta);
		} else if (preguntas.size() == 1) {
			this.realizarProcesosDeRespuesta(respuesta);
			this.validarPreguntasResueltas();
		} else
			throw new ErrorFormularioVacio();
	}

	public void validarPreguntasResueltas() {
		if (!this.preguntasObligatoriasRespondidas() || !this.preguntasDentroDeOpciones())
			throw new ErrorValidacionFormulario();
	}

	public boolean preguntasObligatoriasRespondidas() {
		return this.getPreguntas()==null;

	}// todas las respuestas van a pasar a preguntasRespondidas, hayan sido nulas o no,
	// por ende si quedo alguna respuesta en la lista preguntas, esa va a ser la obligatoria
	// que no se completo

	public boolean preguntasDentroDeOpciones() {
		return true; // lo tengo que revisar
	}

	public void realizarProcesosDeRespuesta(String respuesta){
		Pregunta preguntaTemporal = this.getPreguntas().get(0);
		if((preguntaTemporal.esObligatoria() && preguntaTemporal.estaHabilitada()) || respuesta!=null) {
			preguntaTemporal.validarRespuesta(respuesta);
			this.quitarPreguntaPendienteDeResponder(preguntaTemporal);;
			this.agregarPreguntaARespondida(preguntaTemporal);}
		else
			this.quitarPreguntaPendienteDeResponder(preguntaTemporal);
			this.agregarPreguntaARespondida(preguntaTemporal);
	}// la cagada aca es que si la pregunta no es valida, no arranca mas, se estanca,
		// tengo que pensar una solución o replantearme la implementación de resolución
		// de preguntas, con mayor simplicidad

	public void quitarPreguntaPendienteDeResponder(Pregunta pregunta) {
		this.getPreguntas().remove(pregunta);
	}

	public void agregarPreguntaARespondida(Pregunta pregunta) {
		this.getPreguntasRespondidas().add(pregunta);
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public List<Pregunta> getPreguntasRespondidas() {
		return preguntasRespondidas;
	}

}
