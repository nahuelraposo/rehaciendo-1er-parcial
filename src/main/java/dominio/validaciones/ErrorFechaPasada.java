package dominio.validaciones;

public class ErrorFechaPasada extends RuntimeException{
	
	public ErrorFechaPasada() {
		super("La fecha introducida como limite para que la pregunta vuelva a ser habilitada es inválida.");
	}

}
