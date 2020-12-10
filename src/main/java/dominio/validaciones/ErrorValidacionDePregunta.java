package dominio.validaciones;

public class ErrorValidacionDePregunta extends RuntimeException{
	
	public ErrorValidacionDePregunta() {
		super("Pregunta inválida, no respeta las condiciones.");
	}

}
