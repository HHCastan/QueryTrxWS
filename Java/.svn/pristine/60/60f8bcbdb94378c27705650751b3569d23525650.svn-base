package com.fla.cotizador.controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.fla.cotizador.Version;
import com.fla.cotizador.modelo.Proceso;
import com.fla.cotizador.util.Util;
import com.fla.cotizador.vista.Ventana;
import com.fla.cotizador.vista.VentanaIngreso;

public class Cotizador {
	private static Logger log = Util.getLogger();

	public void iniciarSistema() {
		log.info("Cotizador Front Office: Inicia ejecución del módulo Versión: " + Version.getVersion());
		
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				// instanciamos las clases unicas:
    				Ventana ventana = new Ventana(log); // creamos una ventana
    				VentanaIngreso ventanaIngreso = new VentanaIngreso(ventana, true);
    				Coordinador coordinador = new Coordinador();
    				Proceso proceso = new Proceso();
    				
    				// Relacionamos las clases con el coordinador:
    				ventana.setCoordinador(coordinador);
    				ventanaIngreso.setCoordinador(coordinador);
    				ventanaIngreso.setLog(log);
    				proceso.setCoordinador(coordinador);
    				
    				// Relacionamos el coordinador con las clases:
    				coordinador.setVentanaIngreso(ventanaIngreso);
    				coordinador.setVentanaPrincipal(ventana);
    				coordinador.setProceso(proceso);
    				if(!Util.isValidVersion()) {
    					Util.okDialog("No está ejecutando la última versión del cotizador. Debe remitirse a la mesa de ayuda para solicitar actualización", new JFrame(), JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				// Hacemos visibles las ventanas:
    				ventana.setVisible(true);
    				ventanaIngreso.setVisible(true);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
	}

}
