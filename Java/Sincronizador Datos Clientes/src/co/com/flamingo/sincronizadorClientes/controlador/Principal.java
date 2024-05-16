package co.com.flamingo.sincronizadorClientes.controlador;

import java.awt.EventQueue;

import org.apache.log4j.Logger;

import co.com.flamingo.sincronizadorClientes.modelo.Modelo;
import co.com.flamingo.sincronizadorClientes.util.Util;
import co.com.flamingo.sincronizadorClientes.vista.SincronizadorClientesVentana;

public class Principal {
	Controlador controlador;
	Modelo modelo;
	SincronizadorClientesVentana ventana;
	private static Logger log = Util.getLogger();

	private void iniciar() {
		// Se instancian las clases:
		controlador = new Controlador();
		modelo = new Modelo();
		ventana = new SincronizadorClientesVentana();	
		
		// Se establecen las relaciones entre las clases:
		modelo.setControlador(controlador);
		ventana.setControlador(controlador);
		ventana.setLog(log);
		
		// Se establecen las relaciones con la clase coordinador:
		controlador.setVentana(ventana);
		controlador.setModelo(modelo);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}
}
