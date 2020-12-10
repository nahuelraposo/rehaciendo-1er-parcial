package dominio.consulta;

import java.util.List;
import java.util.stream.Collectors;

public class Link {

	String url;
	
	public List<Consulta> buscarConsulta() {
		return RepositorioConsultas.getInstance().
					getConsultas().stream().
					filter(consulta -> consulta.validarLink(this.getLink()) && consulta.esAccesible()).collect(Collectors.toList());
	}
	
	public String getLink(){
		return this.url;
	}
}
