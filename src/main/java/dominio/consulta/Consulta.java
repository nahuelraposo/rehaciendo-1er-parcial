package dominio.consulta;
import java.util.Calendar;
import java.util.Date;

import dominio.pregunta.Pregunta;

public abstract class Consulta {
	String linkConsulta;
	Calendar periodoInicial = Calendar.getInstance();
	Calendar periodoFinal = Calendar.getInstance();
	Boolean accesible;
	Calendar fechaSistema = Calendar.getInstance();
	
	@SuppressWarnings("deprecation")
	public Consulta(String linkConsulta, Date periodoInicial,Date periodoFinal, boolean esAccesible) {
		this.linkConsulta = linkConsulta;
		this.periodoInicial.set(periodoInicial.getYear(), periodoInicial.getMonth(), periodoInicial.getDay());
		this.periodoFinal.set(periodoFinal.getYear(), periodoFinal.getMonth(), periodoFinal.getDay());
		this.accesible = esAccesible;
	}
	
	public boolean validarLink(String url) {
		return this.getLink().equals(url);
	}
	
	public boolean esAccesible() {
		if(this.compararFechas(periodoInicial,periodoFinal, fechaSistema))
			this.accesible = true;
			this.accesible = false;
		return accesible;
	}
	
	public String getLink() {
		return this.linkConsulta;
	}
	
	public void responder(String respuesta) {}
	
	public void deshabilitarHastaFecha(Pregunta pregunta, Date fechaLimite) {
		pregunta.deshabilitar();
	}
	
	public void deshabilitarVoluntariamente(Pregunta pregunta) {
		pregunta.deshabilitar();
	}
	
	public void deshabilitarPorLimite(Pregunta pregunta) {
		pregunta.deshabilitar();
	}
	
	public boolean compararFechas(Calendar fechaInicial, Calendar fechaFinal, Calendar fechaSistema) {
		if(fechaInicial.compareTo(fechaSistema)<=0 && fechaFinal.compareTo(fechaSistema)>=0)
			return true;
			return false;
	}
	
	/*
	public void notificarASuscriptores(List <Suscriptor> suscriptores) {
		
	} */
	
}
