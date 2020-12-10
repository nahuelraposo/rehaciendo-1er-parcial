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
}
