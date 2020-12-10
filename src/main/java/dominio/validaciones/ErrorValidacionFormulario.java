package dominio.validaciones;

public class ErrorValidacionFormulario extends RuntimeException{
	
	public ErrorValidacionFormulario() {
		super("El formulario no ha sido completo correctamente.");
	}

}
