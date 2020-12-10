package dominio.validaciones;

public class ErrorValidacionDeRespuesta extends RuntimeException{

	public ErrorValidacionDeRespuesta() {
		super("Respuesta inválida.");
	}
}
