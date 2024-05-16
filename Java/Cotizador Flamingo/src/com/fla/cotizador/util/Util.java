package com.fla.cotizador.util;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.fla.cotizador.Version;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.principal.Inicio;
import com.fla.cotizador.vista.VirtualNumPad;
import com.fla.cotizador.servicio.DBServiceImplementation;

public class Util {
	private static Properties properties = null;
	private static Properties propertiesDB = null;

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

	public static Properties getPropertiesDB() {
		if (propertiesDB == null)
			loadPropertiesDB();
		return propertiesDB;
	}

	private static void initLogger() {
		try {
			String sUser = "_" + System.getProperty("user.name");
			System.setProperty("logfilename", sUser);
			logger = Logger.getLogger("cotizadorFlamingo");
			
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("/properties/cotizador4j.properties"));
			PropertyConfigurator.configure(pro);
		} catch (Throwable e) {

		}
	}

	public static void loadProperties() {
		properties = new Properties();

		try {
			properties.load(Inicio.class.getResourceAsStream("/properties/cotizador.properties"));
			logger.debug("Archivo de propiedades cargado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadPropertiesDB() {
		propertiesDB = new Properties();
		DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
		propertiesDB = dbServiceImpl.getPropertiesDB();
		logger.debug("BD Propiedades cargada correctamente");
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

	public static void imageDialog(final JFrame dialogo, String sIcon) {
		final ImageIcon icon = new ImageIcon(Util.class.getResource(sIcon));
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog((Component) dialogo, null, "About Cotizador", JOptionPane.INFORMATION_MESSAGE, icon);
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
		int dialogHeight = 700; //(table.getRowCount() + 5) * 22;
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
	 * Rutina para solicitar un dato en una vetnana emergente
	 */
	public static String inputNumeric(JFrame ventana) {
		/** Para mostrar un popup con el teclado numérico */
		VirtualNumPad kp = new VirtualNumPad(ventana);
		kp.setLocationRelativeTo(ventana);
		kp.setVisible(true);
		return (kp.getValue());
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
		// Quita las comas del número formateado
		unformatedNumber = unformatedNumber.replaceAll(",", "");
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
		if ( (val1.isEmpty()) || (val2.isEmpty()) ) {
			return "$ 0";
		}
		// Quita espacios, signos de moneda y separadores de miles:
		String v1 = val1.replace(" ", "").replace("$", "").replace(".", "").replace(",", "");
		String v2 = val2.replace(" ", "").replace("$", "").replace(".", "").replace(",", "");
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
	
	/**
	 * rutina para calcular el valor total de un producto
	 * @param producto
	 * @return cantidad x valor en formato de cifra
	 */
	public static String getTotalItem(Producto producto) {
		String respuesta = null;
		int cantidad = producto.getQuantity();
		String sValor = producto.getItemPrice();
		sValor = sValor.replace(" ", "");
		sValor = sValor.replace("$", "");
		sValor = sValor.replace(".", "");
		sValor = sValor.replace(",", "");
		int iValor = Integer.parseInt(sValor);
		respuesta = Integer.toString(iValor * cantidad);
		return moneyFormat(respuesta, 0);
	}
	
	public static String getTotalItem(String valor, int cantidad) {
		return Integer.toString(Integer.parseInt(removeMoneyFormat(valor)) * cantidad);
	}

	public static String getToken(String tramaPEF, int i, String separador) {
		String[] st = tramaPEF.split(separador);
		return st[i].trim();
	}

	/**
	 * isValidEmailAddress() Valida el formato de correo
	 * 
	 * @param aEmailAddress
	 * @return
	 */
	public static boolean isValidEmailAddress(String aEmailAddress) {
		if (aEmailAddress == null)
			return false;
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(aEmailAddress);
			if (!hasNameAndDomain(aEmailAddress)) {
				result = false;
			}
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	private static boolean hasNameAndDomain(String aEmailAddress) {
		String[] tokens = aEmailAddress.split("@");
		return tokens.length == 2 && Util.textHasContent(tokens[0]) && Util.textHasContent(tokens[1]);
	}

	private static boolean textHasContent(String aText) {
		return aText != null && aText.trim().length() > 0;
	}

	/**
	 * Rutina para eliminar el dígito de verificación de una EAN-13 EAN-8 UPC-A
	 * UPC-E
	 * 
	 * @param codigo
	 * @return Si tiene el dígito, devuelve el código sin este, de lo contrario,
	 *         devuelve el mismo dato de entrada
	 */
	public static String quitaCheckDigit(String codigo) {
		// Se le quitan los ceros a la izquierda
		codigo = codigo.replaceFirst("^0*", "");

		// Ahora identifica el tipo de código de barras según su longitud:
		int l = codigo.length();
		switch (l) {
		case 13: // EAN13 completo
			if (codigo.length() > 6 && codigo.startsWith("99"))
				return codigo;
			return codigo.substring(0, codigo.length() - 1);
		case 6: // UPC-E sin dígito de chequeo
			return codigo;
		case 7: // EAN-8 sin dígito de chequeo o UPC-E con dígito de chequeo
			if (validaUPCE(codigo))
				return codigo.substring(0, codigo.length() - 1);
			return codigo;
		case 8: // EAN-8 con dígito de chequeo
			return codigo.substring(0, codigo.length() - 1);
		case 10: // UPC-A sin dígito de chequeo
			return codigo;
		case 11: // UPC-A sin dígito de chequeo ni cero al inicio
			return codigo;
		case 12:
			if (codigo.length() > 6 && codigo.startsWith("99"))
				return codigo;
			if ( (codigo.charAt(0) == '0') || (codigo.charAt(0) == '1') ) // UPC-A completo
				if (validaUPCA(codigo)) // UPC-A que no inicia por cero
					return codigo.substring(0, codigo.length() - 1);
//				return codigo;
			else // EAN-13 sin dígito de chequeo
				return codigo;
		default:
			return codigo;
		}
	}

	private static boolean validaUPCA(String codigo) {
		if (codigo.length() == 11) 
			codigo = "0" + codigo;
		if (codigo.length() != 12)
			return false;
		long base = Long.parseLong(codigo.substring(0, codigo.length() - 1));
		int checkDigit = Integer.parseInt(codigo.substring(11));
		if (checkDigit == getCheckDigitUPC(base))
			return true;
		return false;
	}

	private static boolean validaUPCE(String codigo) {
		if (codigo.length() == 6) 
			codigo = "0" + codigo;
		if (codigo.length() != 7)
			return false;
		long base = Long.parseLong(codigo.substring(0, codigo.length() - 1));
		int checkDigit = Integer.parseInt(codigo.substring(6));
		if (checkDigit == getCheckDigitUPC(base))
			return true;
		return false;
	}
	
	public static String getCompleteEAN13(String firstTwelveDigits) {
	     char[] charDigits = firstTwelveDigits.toCharArray();
	     int[] ean13 =
	     {
	        1, 3
	     };
	     int sum = 0;
	     for(int i = 0; i < charDigits.length; i++)
	     {
	         sum += Character.getNumericValue(charDigits[i]) * ean13[i % 2];
	     }
	     int checksum = 10 - sum % 10;

	     if(checksum == 10)
	         checksum = 0;
	     
	     return firstTwelveDigits + String.valueOf(checksum);
	}

	public static int getCheckDigitUPC(long num) {
		int odd_sum = 0, even_sum = 0, big_sum;
		boolean odd = true;

		while (num != 0) {
			if (odd) {
				odd_sum += num % 10;
				odd = false;
			} else {
				even_sum += num % 10;
				odd = true;
			}
			num = (num - num % 10) / 10; // reduce number
		}

		odd_sum *= 3; // sum of odd number multiplied by 3
		big_sum = odd_sum + even_sum; // add both numbers together
		return (10 - big_sum % 10) % 10; // return the sum of the numbers % 10
	}

	/**
	 * Rutina para saber si un bit específico está encendido
	 * 
	 * @parameters n: Número, k: Bit a evaluar
	 * 
	 */
	public static boolean isBitOn(int n, int k) {
		if ((n & (1 << (k - 1))) < 1)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
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

	public static Producto setPaperCoupon(String stPaperCoupon) {
		Producto producto = new Producto();
		producto.setItemCode(stPaperCoupon);
		producto.setItemDesc("CUPÓN IMPRESO");
		producto.setItemPrice("0");
		producto.setDepto("0");
		return producto;
	}

	/**
	 * Obtener lista de artículos del clipboard
	 */
	public static List<String> getProductosFromClipboard() {
		List<String> productList = new ArrayList<>();
		BufferedReader bufReader = new BufferedReader(new StringReader(getClipBoard()));
		String line = null;
		try {
			while ((line = bufReader.readLine()) != null) {
				if (isNumeric(line))
					productList.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;

	}

	/**
	 * Obtener el texto contentido en el clipboard del sistema
	 */
	public static String getClipBoard() {
		try {
			return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * tienePermiso: Rutina para verificar si un perfil tiene permiso de acceso a
	 * una opción
	 * 
	 * @param bitToCheck
	 * @return true or false
	 */
	public static boolean tienePermiso(int bitToCheck, Usuario usuario) {
		// Inicializa una variable BitSet con el bit de la opción
		BitSet bitSetOpcion = new BitSet(32);
		bitSetOpcion.set(bitToCheck);
		// Inicializa una variable BitSet con el perfile del usuario:
		BitSet bitSetUsuario = BitSet.valueOf(new long[] { usuario.getOpcionesPerfil() });
//		bitSetUsuario.flip(23); // prueba apagando un bit HHC Borrar
		if (bitSetUsuario.intersects(bitSetOpcion)) // Si el bit coincide
			return true;
		return false;
	}
	
	public static boolean isBitSetOn(int bitToCheck, int number) {
		if ((bitToCheck & (1L << number)) != 0)
			return true;
		return false;
	}
	
	/**
	 * Evalúa una tabla de productos y retorna true si hay mezcla de eventos
	 * Tiene en cuenta los eventos comodin para no evaluarlos
	 * @param modeloPR
	 * @return
	 */
	public static boolean isMixEvents(ProductosTableModel modeloPR) {
		int antEvent = 0;
		/** Servicio para conexion con bases de datos */
		DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
		String eventosComodin = dbServiceImpl.getEventosFinancieros();

		for (int a = 0; a < modeloPR.getRowCount(); a++) {
			Producto producto =  (Producto) modeloPR.getRowProduct(a);
			int eventoProducto = producto.getEventoFenix();
			if (antEvent != eventoProducto) {
				if (!esComodin(eventoProducto, eventosComodin))
					if (a != 0) { // El primer artículo no se compara 
						if ((antEvent + eventoProducto) / 2 != antEvent)
							return true; // hay mezcla de ventos
					} else 
						antEvent = eventoProducto;
			} else if (!esComodin(eventoProducto, eventosComodin))
				antEvent = eventoProducto;
		}
		return false; // Si llega hasta acá es porque no hay mezcla de eventos
	}
	
	public static boolean esComodin(int evento, String eventosComodin) {
		StringTokenizer st = new StringTokenizer(eventosComodin, ",");
		while (st.hasMoreElements())
			if (evento == (int) Integer.parseInt((String) st.nextElement()))
				return true;
		return false;
	}

	   /**
     * Copy a file from source to destination.
     *
     * @param source
     *        the source
     * @param destination
     *        the destination
     * @return True if succeeded , False if not
     */
    public static boolean copy(String source , String destination) {
        boolean succeess = true;
        InputStream origen;

        try {
        	origen = new FileInputStream(source);
            Files.copy(origen, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            origen.close();
        } catch (IOException ex) {
            logger.log(Level.WARN, "", ex);
            succeess = false;
        }
        return succeess;
    }
    
	public static void backupFile(String fileName) {
		String fileBak = fileName.substring(0, fileName.length() - 3).concat("BAK");
		Util.copy(fileName, fileBak);
	}
	
    public static Image getLogoFlamingo() {
    	Image img = null;
		try {
			img = Image.getInstance(Util.class.getResource("/images/LogoFlamingo.png"));
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return img;
    }

	public static Image getLogoSisteCredito() {
    	Image img = null;
		try {
			img = Image.getInstance(Util.class.getResource("/images/LogoSisteCredito.PNG"));
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return img;
	}

	public static boolean compareFiles(String file1, String file2) {
		boolean respuesta = true;
		try {
			FileChannel ch1 = new RandomAccessFile(file1, "r").getChannel();
			FileChannel ch2 = new RandomAccessFile(file2, "r").getChannel();
			if (ch1.size() != ch2.size()) {
				respuesta = false;
			}

			long size = ch1.size();
	        ByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, size);
	        ByteBuffer m2 = ch2.map(FileChannel.MapMode.READ_ONLY, 0L, size);
	        for (int pos = 0; pos < size; pos++) {
	            if (m1.get(pos) != m2.get(pos)) {
	                System.out.println("Files differ at position " + pos);
					respuesta = false;
	            }
	        }
			ch1.close();
			ch2.close();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public static String ofuscarCorreo(String correo) {
		int a = correo.indexOf("@");
		char[] correoChars = correo.toCharArray();
		correoChars[a - 1] = '_';
		correoChars[a - 2] = '_';
		correoChars[a - 3] = '_';
		correoChars[a + 1] = '_';
		correoChars[a + 2] = '_';
		return String.valueOf(correoChars);
	}

	public static int ComparaFormateados(String valor1, String valor2) {
		int respuesta;
		int iVlr1 = Integer.parseInt(removeMoneyFormat(valor1));
		int iVlr2 = Integer.parseInt(removeMoneyFormat(valor2));
		respuesta = iVlr1 - iVlr2;
		return respuesta;
	}

	public static boolean isValidVersion() {
		Properties propDB = Util.getPropertiesDB();
		String lastVersion = propDB.getProperty("COTIZADOR.lastVersion");
		if(lastVersion.compareTo(Version.getVersionNumber()) > 0 )
			return false;
		else
			return true;
	}
	
	public static ArrayList<String> getTaxesProperty() {
		Properties propDB = Util.getPropertiesDB();
		ArrayList<String> taxes = new ArrayList<String>();
		StringTokenizer  taxesProperty = new StringTokenizer(propDB.getProperty("COTIZADOR.arrTaxes"), ",");
		while (taxesProperty.hasMoreTokens())
			taxes.add(taxesProperty.nextToken());
		return taxes;
	}
	
	public static String getTarifaIVA(int indicat1) {
		String tarifa = null;
		ArrayList<String> taxes = getTaxesProperty();
		if(isBitSetOn(indicat1,7)) {
			tarifa = taxes.get(0);
		} else if (isBitSetOn(indicat1,6)) {
			tarifa = taxes.get(1);
		} else if (isBitSetOn(indicat1,5)) {
			tarifa = taxes.get(2);
		} else if (isBitSetOn(indicat1,4)) {
			tarifa = taxes.get(3);
		}
		return tarifa;
	}
	
}
