package co.com.flamingo.transfer4690.controlador;

import java.awt.EventQueue;

import co.com.flamingo.transfer4690.modelo.Modelo;
import co.com.flamingo.transfer4690.vista.Ventana;

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
