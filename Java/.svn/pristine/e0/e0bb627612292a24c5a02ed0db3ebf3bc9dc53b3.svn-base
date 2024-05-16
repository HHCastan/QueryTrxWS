package co.com.flamingo.sincronizadorClientes.util;

import java.awt.Component;
import java.awt.Cursor;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Util {
	private static Properties properties = null;
	public static Logger logger = null;

	public static Logger getLogger() {
		if (logger == null)
			initLogger();
		return logger;
	}

	private static void initLogger() {
		try {
			logger = Logger.getLogger("remoteCommand");
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("/config/sincronizadorClientes4j.properties"));
			PropertyConfigurator.configure(pro);
		} catch (Throwable e) {

		}
	}

	public static Properties getProperties() {
		if (properties == null)
			loadProperties();
		return properties;
	}

	public static void loadProperties() {
		properties = new Properties();

		try {
			properties.load(Util.class.getResourceAsStream("/config/sincronizadorClientes.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * Sets cursor for specified component to Wait cursor
	 */
	public static void startWaitCursor(JComponent component) {
		RootPaneContainer root = (RootPaneContainer) component.getTopLevelAncestor();
		root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		root.getGlassPane().setVisible(true);
	}

	/**
	 * Sets cursor for specified component to Normal cursor
	 */
	public static void stopWaitCursor(JComponent component) {
		RootPaneContainer root = (RootPaneContainer) component.getTopLevelAncestor();
		root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		root.getGlassPane().setVisible(true);
	}

	public static String getToken(String tramaPEF, int i, String separador) {
		String[] st = tramaPEF.split(separador);
		return st[i].trim();
	}

	/**
	 * Rutina para obtener la hora actual en formato hh:mm AM/PM
	 * 
	 * @param
	 * @return
	 */
	public static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm a");
		LocalDateTime now = LocalDateTime.now();
		String stHora = (String) dtf.format(now);
		return stHora;
	}

	/**
	 * Rutina para obtener la fecha actual en formato AAAA/MM/DD
	 * 
	 * @param
	 * @return
	 */
	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String stFecha = (String) dtf.format(localDate);
		return stFecha;
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
