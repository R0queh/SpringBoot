package com.habilidades.habilidade.module;

public class objeto {
	public String tipo;
	public String text;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public objeto() {
		super();
	}
	
	public objeto(String tipo, String text) {
		super();
		this.tipo = tipo;
		this.text = text;
	}
	
	
}
