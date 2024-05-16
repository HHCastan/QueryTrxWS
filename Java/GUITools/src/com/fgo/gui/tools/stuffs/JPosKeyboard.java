package com.fgo.gui.tools.stuffs;

import org.apache.log4j.Logger;
import jpos.JposConst;
import jpos.JposException;
import jpos.POSKeyboard;
import jpos.events.DataEvent;
import jpos.events.DataListener;

/**
 * Clase que se encarga de administrar las peticiones al teclado mediante los drivers de java POS
 * 
 * @author hugo.castaneda
 * 
 */public class JPosKeyboard implements DataListener {
	 /* inicia declaración de variables de clase */

	 private static String logicalName = "IBM4690Keyboard";
	 
	 private POSKeyboard keyboard = new POSKeyboard();
	 
	 private Logger log = Util.getLogger();
	 
	 private static final String MODULE_NAME = "[JPosScanner]";
	 
	 private String dato;
	 
	 /**
	  * Constructor vacío:
	  */
	 public JPosKeyboard(){
		 
	 }
	 
	 public void openKeyboard() {
		 log.info(MODULE_NAME + " - Open Keyboard connection" + logicalName);
		 
		 // hace varios intentos de reclamar y abrir el teclado
		 int attempts = 0;
		 while (keyboard.getState() == JposConst.JPOS_S_CLOSED) {
			 // controla el máximo de intentetos:
			 if (attempts++ >= 10) {
				 break;
			 }
			 
			 try {
				 if (keyboard.getState() == JposConst.JPOS_S_CLOSED) {
					 keyboard.open(logicalName);
					 keyboard.claim(10000);
					 // Sleep a bit:
					 try {
						 Thread.sleep(1000);
					 } catch (Exception e2) {
						 log.error("Error en espera: ", e2);
					 }
					 keyboard.setDeviceEnabled(true);
					 keyboard.setDataEventEnabled(true);
					 addListener(this);
				 }
			 } catch (JposException e) {
				 log.error(MODULE_NAME + " - Intentando abrir conexión con Teclado...", e);
			 } catch (NoClassDefFoundError re1) {
				 log.error(MODULE_NAME + " - Intentando abrir conexión con teclado...", re1);
			 }
		 }
		 
	}
	 
	 public void closeKeyboard() {
		 try {
			 removeListener(this);
			 keyboard.close();
		 } catch (JposException e) {
			 log.error(MODULE_NAME + " - Intentando cerrar conexión con teclado..." , e);
		 }
	 }
	 
	 public void addListener(DataListener dataListener) {
		 keyboard.addDataListener(dataListener);
	 }
	 
	 public void removeListener(DataListener dataListener) {
		 keyboard.removeDataListener(dataListener);
	 }
	 
	 public String getDato() {
		 return dato;
	 }
	 
	 public void setDato(String dato) {
		 this.dato = dato;
	 }

	public void dataOccurred(DataEvent de) {
		log.info("Evento: " + de.getStatus());
		
	}

}
