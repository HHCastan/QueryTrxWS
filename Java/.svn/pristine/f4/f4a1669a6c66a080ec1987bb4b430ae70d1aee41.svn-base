package com.fla.cotizador.controlador;

import com.fla.cotizador.modelo.Proceso;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.vista.Ventana;
import com.fla.cotizador.vista.VentanaIngreso;

public class Coordinador {

	private VentanaIngreso ventanaIngreso;
	private Ventana ventana;
	private Proceso proceso;

	public void setVentanaIngreso(VentanaIngreso ventanaIngreso) {
		this.ventanaIngreso = ventanaIngreso;
	}

	public void setVentanaPrincipal(Ventana ventana) {
		this.ventana = ventana;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public Usuario validarIngreso(String sUsuario, String sPasswd, String sAplicacion) {
		return proceso.validarIngreso(sUsuario, sPasswd, sAplicacion);
		
	}

	public void cerrarVentanaIngreso() {
		ventanaIngreso.dispose();
	}

	public void asignarPrivilegios(Usuario usuario) {
		ventana.asignarPrivilegios(usuario);
		
	}

	public void cerrarVentana() {
		ventana.close();
	}

	public void cerrarSistema() {
		cerrarVentana();
		cerrarVentanaIngreso();
	}

}
