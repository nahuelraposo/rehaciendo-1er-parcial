package dominio.consulta;
import java.util.Calendar;
import java.util.Date;

public abstract class Consulta {
	String linkConsulta;
	Calendar periodoInicial = Calendar.getInstance();
	Calendar periodoFinal = Calendar.getInstance();
	Boolean fueNotificada;
	// SuscriptoresSystem suscriptoresSystem;
	
	@SuppressWarnings("deprecation")
	public Consulta(String linkConsulta, Date periodoInicial,Date periodoFinal) {
		this.linkConsulta = linkConsulta;
		this.periodoInicial.set(periodoInicial.getYear(), periodoInicial.getMonth(), periodoInicial.getDay());
		this.periodoFinal.set(periodoFinal.getYear(), periodoFinal.getMonth(), periodoFinal.getDay());
		this.fueNotificada = false;
	}
	
	public boolean validarLink(String url) {
		return this.getLink().equals(url);
	}
	
	public boolean esAccesible() {
		return this.compararFechas(periodoInicial,periodoFinal);
	}
	
	public void chequearAccesibilidadParaNotificarConsulta() {
		if(this.esAccesible() && !this.haSidoNotificada()) {
			//this.notificarSucriptores();
		}
	}
	
	public boolean haSidoNotificada() {
		return fueNotificada;
	}
	
	public String getLink() {
		return this.linkConsulta;
	}
	
	public void responder(String respuesta) {}
	
	public boolean compararFechas(Calendar fechaInicial, Calendar fechaFinal) {
		Calendar fechaSistema = Calendar.getInstance();
		if(fechaInicial.compareTo(fechaSistema)<=0 && fechaFinal.compareTo(fechaSistema)>=0)
			return true;
			return false;
	}
	
	/*

	public void notificarSuscriptores(){
			this.suscriptoresSystem.todos().
			forEach(suscriptor -> suscriptor.medioComunicacion.notificar(suscriptor,this.getLink));
			this.fueNotifacada = true;
	}

	
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
	
	class MisSuscriptoresSistema{
	
		List<SuscriptorDTO> suscriptoresSystem;
		
		public List<SuscriptorDTO> todos(){
			return suscriptoresSystem.stream().map(s -> crearSuscriptor(s))
		}
		
		public SuscriptorDTO crearSuscriptor(suscriptorDTO){
			if(suscriptorDTO.enabledSystem = 1)
					MedioDeComunicacion medioComunicacion = new EnviadorWhatsapp();
			else 
				if(suscriptorDTO.enabledSystem = 0)
					MedioDeComunicacion medioComunicacion = new MailSender();
			return new SuscriptorDTO(medioComunicacion, suscriptorDTO.mail(), suscriptorDTO.telephone());
		}
	}
	
	interface MedioDeComunicacion{
	
	 	public void notificar(SuscriptorDTO suscriptor, String contenido){
	 	}
	}
	
	public class EnviadorWhatsapp implements MedioDeComunicacion{
		
		public void notificar(SuscriptorDTO suscriptor, String link){
			this.enviar(suscriptor.telephone(),link)
		
		}
	}
	
	public class MailSender implements MedioDeComunicacion{
		
		String mailOficial;
		
		public void notificar(SuscriptorDTO suscriptor, String link){
			this.send(this.getMailOficial(),suscriptor.mail(),link)
		
		} // aca hay que ver porque devuelve 0 si no se envio y 1 si se envio
		
		public String getMailOficial(){
			return mailOficial;
		}
	
	}
	
	*/
	
}
