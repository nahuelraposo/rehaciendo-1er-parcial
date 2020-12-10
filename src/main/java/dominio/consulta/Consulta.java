package dominio.consulta;
import java.util.Calendar;
import java.util.Date;

import dominio.pregunta.Pregunta;

public abstract class Consulta {
	String linkConsulta;
	Calendar periodoInicial = Calendar.getInstance();
	Calendar periodoFinal = Calendar.getInstance();
	Boolean accesible;
	Calendar fechaSistema = Calendar.getInstance(); // cambiar
	// SuscriptoresSystem suscriptoresSystem;
	
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
	}//reveer
	
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

	notificarSuscriptores( ){
		this.suscriptoresSystem.encontrados( ).
		forEach(suscriptor -> this.notificarSuscriptor(suscriptor));
	}

	notificarSuscriptor(SuscriptorDTO suscriptor){
		if(suscriptor.enabledSystem()==1)
			new EnviadorWhatsapp.enviar(suscriptor.getTelephone(), this.getLink());
		else if(suscriptor.enabledSystem==0)
			new MailSender().send(mailDelEmisor,sucriptor.getMail(), this.getLink());
	} 
	este metodo seria para el suscriptor 

	
	en esta parte lo que se tiene que hacer es algo al estilo observer, el patron
	cuya función es notificar a una lista (en este caso a la interfaz Suscriptores
	System, la cual ya posee como atributo una lista de suscriptores) de que
	la consulta ya esta disponible para ser completada, y como nos dice que si bien
	actualmente se notifica a traves de mail y del whatsapp, hay que tener en cuenta
	de que en un futuro las plataformas se van a expandir, por ende habra que
	contruir algun adapter que nos permita con un solo mensaje enviar la notificacion
	a todas las plataformas disponibles.
	
	Para el adapter habria que hacer una interfaz que sea MedioDeComunicacion, y tanto
	mailSender como EnviadorWhatsapp compartirian un metodo llamado notificar()
	
	notificarSuscriptor(SuscriptorDTO suscriptor){
			enabledSystem().notificar(suscriptor, this.getLink());
	} 
	
	interface MedioDeComunicacion{
	
		
	
	 	public void notificar(SuscriptorDTO suscriptor, String contenido){
	 	}
	}
	
	public class EnviadorWhatsapp implements MedioDeComunicacion{
		
		public void notificar(SuscriptorDTO suscriptor, String link){
			this.enviar(suscriptor.getTelephone(),link)
		
		}
	}
	
	public class MailSender implements MedioDeComunicacion{
		
	
	}
	
	*/
	
}
