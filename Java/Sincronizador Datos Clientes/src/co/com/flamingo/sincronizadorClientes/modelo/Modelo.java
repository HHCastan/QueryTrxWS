package co.com.flamingo.sincronizadorClientes.modelo;

import co.com.flamingo.sincronizadorClientes.controlador.Controlador;

public class Modelo {
	private Controlador controlador;
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public Controlador getControlador() {
		return this.controlador;
	}
}
