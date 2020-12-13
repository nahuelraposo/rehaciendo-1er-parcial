package dominio.pregunta;

public class Opcion {

	int contador;
	String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void subirContador() {
		contador += 1;
	}
	
	public int devolverContador() {
		return contador;
	}
	
	public boolean matcheaConRespuesta(String respuesta) {
		return this.getDescripcion()==respuesta;
	}
}
