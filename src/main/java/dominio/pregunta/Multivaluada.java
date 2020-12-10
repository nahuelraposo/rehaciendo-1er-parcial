package dominio.pregunta;

import java.util.List;
import java.util.stream.Collectors;

import dominio.validaciones.ErrorValidacionDeRespuesta;

public class Multivaluada extends Pregunta {

	List<Opcion> opciones;
	
	@Override
	public void validarRespuesta(String respuesta) {
		if(!matchea(respuesta))
			throw new ErrorValidacionDeRespuesta();
		else{
			subirContadorALaQueMatchea(respuesta);
			this.guardarRespuesta(respuesta);
			this.respondida = true;
		}	
	}
	
	@Override
	public List<String> resultadoPregunta(){
		return this.getOpciones().stream().map(opcion->opcion.devolverContador()).
				map(contador->contador.toString()).collect(Collectors.toList());
	} //con esta funcion voy a devolver una lista de strings con los contadores
	// de cada opcion, lo que hay que hacer es un hashmap con una key(opcion)
	//y su valor(contador)
	
	public void subirContadorALaQueMatchea(String respuesta) {
		this.getOpciones().stream().filter(opcion -> opcion.getDescripcion().
				equals(respuesta)).forEach(opcion -> opcion.subirContador());
	}

	public boolean matchea(String respuesta) {
		return this.getOpciones().stream().map(opcion -> opcion.descripcion).
								collect(Collectors.toList()).contains(respuesta);
	}
	
	public List<Opcion> getOpciones(){
		return opciones;
	}
	
}
