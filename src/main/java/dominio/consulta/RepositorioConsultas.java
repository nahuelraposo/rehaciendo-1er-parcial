package dominio.consulta;

import java.util.List;

public class RepositorioConsultas {

	private final static RepositorioConsultas INSTANCE = new RepositorioConsultas();
	List<Consulta> consultas;
	
	public static RepositorioConsultas getInstance() {
		return INSTANCE;
	}
	
	public List<Consulta> getConsultas(){
		return consultas;
	}
	
	public void agregarConsulta(Consulta consulta) {
		consultas.add(consulta);
	}
	
	public void notificarASuscriptores() {
		this.getConsultas().stream().forEach(consulta -> consulta.chequearAccesibilidadParaNotificarConsulta());
	} // esto se tendría que programar para que se haga cada ciertos lapsos de tiempo
}
