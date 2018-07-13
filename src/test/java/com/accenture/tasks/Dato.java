package com.accenture.tasks;

public class Dato {

	
	private String correo;
	private String asunto;
	private String texto;
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Dato(String correo) {
	
		this.correo = correo;
	}
	
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Dato() {
		
		correo = "";
		asunto ="";
		texto ="";
		
	}
}
