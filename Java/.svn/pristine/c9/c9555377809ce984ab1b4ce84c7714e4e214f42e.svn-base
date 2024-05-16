package com.fla.remoteCommand.controlador;

import com.fla.remoteCommand.modelo.Modelo;
import com.fla.remoteCommand.vista.Ventana;

public class Principal {
	Controlador controlador;
	Modelo modelo;
	Ventana ventana;
	
	private void iniciar() {
		// Se instancian las clases:
		controlador = new Controlador();
		modelo = new Modelo();
		ventana = new Ventana();
		
		// Se establecen las relaciones entre las clases:
		modelo.setControlador(controlador);
		ventana.setControlador(controlador);
		
		// Se establecen las relaciones con la clase coordinador:
		controlador.setVentana(ventana);
		controlador.setModelo(modelo);
		
		ventana.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}

}
