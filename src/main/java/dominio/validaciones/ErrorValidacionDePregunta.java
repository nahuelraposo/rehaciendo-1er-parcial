package dominio.validaciones;

public class ErrorValidacionDePregunta extends RuntimeException{
	
	public ErrorValidacionDePregunta() {
		super("Pregunta inv�lida, no respeta las condiciones.");
	}

}
