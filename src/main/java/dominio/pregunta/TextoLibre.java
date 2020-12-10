package dominio.pregunta;

public class TextoLibre extends Pregunta {
	
	String texto;

	public void validarRespuesta(String respuesta) {
		this.guardarRespuesta(respuesta);
		this.respondida = true;
	}
}
