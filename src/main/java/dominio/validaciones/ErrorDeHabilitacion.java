package dominio.validaciones;

public class ErrorDeHabilitacion extends RuntimeException{
	public ErrorDeHabilitacion(){
		super("ERROR, EN ESTE MOMENTO NO SE PERMITE LA HABILITACION DE LA PREGUNTA.");
	}

}
