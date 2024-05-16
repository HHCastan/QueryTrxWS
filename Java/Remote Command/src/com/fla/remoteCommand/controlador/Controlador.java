package com.fla.remoteCommand.controlador;

import com.fla.remoteCommand.modelo.Modelo;
import com.fla.remoteCommand.vista.Ventana;

public class Controlador {
	Modelo modelo;
	Ventana ventana;
	
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Ventana getVentana() {
		return ventana;
	}
	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}
}
