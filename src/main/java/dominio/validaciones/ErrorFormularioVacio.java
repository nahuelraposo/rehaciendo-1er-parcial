package dominio.validaciones;

public class ErrorFormularioVacio extends RuntimeException{
	
	public ErrorFormularioVacio() {
		super("El formulario est� vac�o.");
	}

}
