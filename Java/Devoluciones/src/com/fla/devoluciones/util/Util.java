package com.fla.devoluciones.util;

import java.awt.Component;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.lang.StringUtils;

public class Util {
	private static Properties properties = null;

	public static Logger logger = null;

	public static Logger getLogger() {
		if (logger == null)
			initLogger();
		return logger;
	}

	public static Properties getProperties() {
		if (properties == null)
			loadProperties();
		return properties;
	}

	private static void initLogger() {
		try {
			logger = Logger.getLogger("devoluciones");
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("/properties/devoluciones4j.properties"));
			PropertyConfigurator.configure(pro);
		} catch (Throwable e) {

		}
	}

	public static void loadProperties() {
		properties = new Properties();

		try {
			properties.load(Util.class.getResourceAsStream("/properties/devoluciones.properties"));
			// log.debug("Archivo de propiedades cargado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	/**
	 * Rutina para pintar un mensaje de dialogo en la pantalla
	 * 
	 * @param stMessage
	 * @param dialogo
	 * @param tipo
	 */
	public static void okDialog(final String stMessage, final JFrame dialogo, final int tipo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog((Component) dialogo, stMessage, "Mensaje", tipo);
			}
		});
	}

	/**
	 * Rutina para pintar un dialogo de SI o NO
	 * 
	 * @param stMessage
	 * @param dialogo
	 * @param tipo
	 * @param location
	 * @param options2
	 * @return
	 */

	public static int sigaPareMessage(String stMessage, JDialog dialogo, int tipo, Object[] options) {
		return JOptionPane.showOptionDialog((Component) dialogo, stMessage, "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
				tipo, null, options, options[0]);
	}

	/**
	 * Rutina para rellenar con ceros a la izquierda
	 */
	public static String zeroPad(String stNumber, int len) {
		String result = StringUtils.leftPad(stNumber, len, "0");
		result = result.substring(result.length() - len, result.length());
		return result;
	}

}
