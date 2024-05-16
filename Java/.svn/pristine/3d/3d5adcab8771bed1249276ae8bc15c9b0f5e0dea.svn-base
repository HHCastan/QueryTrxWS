package co.com.flamingo.canopus.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import co.com.flamingo.canopus.principal.Core;

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
			logger = Logger.getLogger("cotizadorFlamingo");
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("/properties/canopus4j.properties"));
			PropertyConfigurator.configure(pro);
		} catch (Throwable e) {

		}
	}

	public static void loadProperties() {
		properties = new Properties();

		try {
			properties.load(Core.class.getResourceAsStream("/properties/canopus.properties"));
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
	 * Rutina para pintar una tabla en la pantalla
	 * 
	 * @param table
	 * @param dialogo
	 * @param titulo
	 */
	public static void gridDialog(final JTable table, final JFrame dialogo, final String titulo, int widths[]) {
		int dialogWidth = 0;
		int dialogHeight = (table.getRowCount() + 2) * 30;
		Font fontBold = new Font("SansSerif", Font.BOLD, 20);
		Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

		// configura el ancho de las columnas:
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < widths.length; i++) {
			if (i < columnModel.getColumnCount()) {
				columnModel.getColumn(i).setMaxWidth(widths[i]);
				dialogWidth += widths[i];
			} else
				break;
		}
		table.setFont(fontPlain);
		table.getTableHeader().setFont(fontBold);
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		JDialog dlg = new JDialog(dialogo);
		dlg.setModal(true);
		dlg.setLocation(dialogo.getLocation());
		dlg.setTitle(titulo);
		dlg.add(new JScrollPane(table));
		dlg.setPreferredSize(new Dimension(dialogWidth, dialogHeight));
		dlg.pack();
		dlg.setVisible(true);
	}


	/**
	 * Rutina para rellenar con ceros a la izquierda
	 */
	public static String zeroPad(String stNumber, int len) {
		String result = StringUtils.leftPad(stNumber, len, "0");
		result = result.substring(result.length() - len, result.length());
		return result;
	}

	public void loadLogConfig() {
		Properties l4jPro = new Properties();
		try {
			l4jPro.load(this.getClass().getResourceAsStream("/consSaldos4j.properteis"));
		} catch (IOException e) {
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

		try {
			// Con las siguiente dos líneas limpia el número de puntos y comas y
			// luego quita los decimales
			double dNumber = Double.parseDouble(number);
			number = String.format("%.0f", dNumber);

			if (number.replaceAll("\\s", "").isEmpty())
				number = "0";
			return "$ " + nf.format(Integer.parseInt(number));
		} catch (NumberFormatException e) {
			return "$ 0";
		}
	}

	/**
	 * Rutina para formatear un numero con decimales y miles
	 * 
	 * @param number
	 * @param decimals
	 * @return
	 */
	public static String removeMoneyFormat(String FormatedNumber) {
		String unformatedNumber = null;
		if (FormatedNumber == "")
			return null;
		// Quita los puntos del número formateado
		unformatedNumber = FormatedNumber.replaceAll("\\.", "");
		// Quita el signo $ al principio del número formateado
		if (unformatedNumber.charAt(0) == '$')
			unformatedNumber = unformatedNumber.substring(1, unformatedNumber.length());
		// Quita los espacios del número formateado
		unformatedNumber = unformatedNumber.replaceAll(" ", "");
		return unformatedNumber;

	}

	/**
	 * Rutina para formatear la fecha en ddMMyyy
	 * 
	 * @param date
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
	 * Rutina para obtener la hora actual en formato hh:mm AM/PM
	 * 
	 * @param
	 * @return
	 */
	public static String getDateTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	/**
	 * Rutina para convertir XMLGregorianCalendar en fecha formateada
	 * 
	 * @param xc
	 * @return fecha en formato MM/dd/yyyy hh:mm
	 */
	public static String convertXmlGregorianToString(XMLGregorianCalendar xc) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm");

		GregorianCalendar gCalendar = xc.toGregorianCalendar();

		// Converted to date object
		Date date = gCalendar.getTime();

		// Formatted to String value
		String dateString = df.format(date);

		return dateString;
	}

	/**
	 * Rutina para sumar dos valores formateados en Strings Ejemplo:
	 * sumaFormateados("$ 100.250", "$439.100", '+'
	 * 
	 * @param valor1, valor2, signo
	 * @return valor1 + valor2
	 */
	public static String sumaFormateados(String val1, String val2, char signo) {
		String respuesta = null;
		// Quita espacios, signos de moneda y separadores de miles:
		String v1 = val1.replace(" ", "").replace("$", "").replace(".", "");
		String v2 = val2.replace(" ", "").replace("$", "").replace(".", "");
		// Valida los dígitos
		if (!isNumeric(v1) || !isNumeric(v2)) {
			return "$ 0";
		}

		if (signo == '+') {
			respuesta = Integer.toString(Integer.parseInt(v1) + Integer.parseInt(v2));
		} else {
			respuesta = Integer.toString(Integer.parseInt(v1) - Integer.parseInt(v2));
		}
		return moneyFormat(respuesta, 0);
	}

	public static String getToken(String tramaPEF, int i, String separador) {
		String[] st = tramaPEF.split(separador);
		return st[i].trim();
	}


	private static boolean textHasContent(String aText) {
		return aText != null && aText.trim().length() > 0;
	}



}
