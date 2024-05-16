package com.fla.consultaSaldos.util;

import java.awt.Component;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fla.consultaSaldos.principal.Inicio;

public class Util {
	private static Properties properties = null;

	public static Logger logger = null;

	public Util() {
	}

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
			logger = Logger.getLogger("consultaSaldos");
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("/properties/consSaldos4j.properties"));
			PropertyConfigurator.configure(pro);
//			PropertyConfigurator.configure("/consSaldos4j.properties");
		} catch (Throwable e) {

		}
	}

	public static void loadProperties() {
		properties = new Properties();
		
		try {
			properties.load(Inicio.class.getResourceAsStream("/properties/consultaSaldos.properties"));
//				log.debug("Archivo de propiedades cargado correctamente");
		}
		catch (IOException e) {
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
	 * Rutina para rellenar de ceros a la izquierda
	 */
	public static String zeroPad(String stNumber, int len) {
		String result = StringUtils.leftPad(stNumber, len, "0");
		result = result.substring(result.length() - len, result.length());
		return result;
	}

	public void loadLogConfig(){
		Properties l4jPro = new Properties();
		try {
			l4jPro.load(this.getClass().getResourceAsStream("/consSaldos4j.properteis"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(l4jPro);
	}

	/**
	 * Rutina para formatear un numero con decimales y miles
	 * 
	 * @param number
	 * @param decimals
	 * @return
	 */
	public static String moneyFormat(String number, int decimals) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(decimals);
		return "$ " + nf.format(Integer.parseInt(number));
	}

	/**
	 * Rutina para formatear un numero con decimales y miles
	 * 
	 * @param number
	 * @param decimals
	 * @return
	 */
	public static String dateFormat(String date) {
		DateFormat df = DateFormat.getDateInstance();
		DateFormat df2 = new SimpleDateFormat("ddMMyyyy");
		Date fecha = null;
		try {
			fecha = df2.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return (fecha == null ? "" : df.format(fecha));
	}

}
