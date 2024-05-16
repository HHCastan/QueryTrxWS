package com.fgo.gui.tools.stuffs;

import java.awt.Component;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ibm.OS4690.FlexosException;
import com.ibm.OS4690.TerminalApplicationServices;
import lineai.base.exceptions.HostConnectionException;
import lineai.base.exceptions.ReceiveResponseException;
import lineai.base.exceptions.SendRequestException;
import lineai.base.exceptions.SocketConnectionException;
import lineai.base.provider.FuncionProvider;
import lineai.base.util.MaosFrame;

/**
 * Clase que contiene varios metodos de utilidad para la aplicacion.
 * 
 * @author hcastaneda
 * 
 */
public class Util {

	public Util() {
	}

	public static Logger logger;

	public static Logger getLogger() {
		if (logger == null)
			initLogger();
		return logger;
	}

	private static void initLogger() {
		try {
			logger = Logger.getLogger("SIG");
			Properties pro = new Properties();
			pro.load(Util.class.getResourceAsStream("SigLogger.pro"));
			PropertyConfigurator.configure(pro);
		} catch (Throwable e) {

		}

	}

	/**
	 * 
	 * @param file
	 * @param tag
	 * @return
	 */

	private static Properties properties;

	private static LineNumberReader lnr;

	public static final int RIGHT = 0;

	public static final int LEFT = 1;

	private static int timeOut = 1000 * 10;

	public static Properties LoadParameters(String file, String tag) {
		String line = null;
		properties = new Properties();
		lnr = null;

		try {
			lnr = new LineNumberReader(new FileReader(file));
			line = lnr.readLine();
			while (line != null) {
				if (proccesLine(line, tag))
					break;
				line = lnr.readLine();
			}

			lnr.close();
		} catch (Exception ioe) {
			try {
				lnr.close();
			} catch (Exception e) {
			}
			return null;
		}
		return properties;
	}

	/**
	 * 
	 * @param line
	 * @param tag
	 * @return
	 * @throws Exception
	 */
	private static boolean proccesLine(String line, String tag) throws Exception {
		if (!line.equals(tag) || line == null || line.equals(""))
			return false;

		line = lnr.readLine();

		while (line != null && !line.equals("")) {
			int numkey = line.indexOf('=');
			if (numkey > 0) {
				String key = line.substring(0, numkey).trim();
				String value = line.substring(numkey + 1, line.length()).trim();
				properties.setProperty(key, value);
			}
			line = lnr.readLine();
		}
		return true;
	}

	// ******************
	public static String pad(String text, int size, int just, char ch) {
		if (text.length() > size) {
			while (text.charAt(0) == ch) {
				text = text.substring(1, text.length());
			}
		}

		if (text == null || text.length() == size || (just != Util.LEFT && just != Util.RIGHT))
			return text;

		for (int i = text.length(); i < size; i++) {
			if (just == Util.RIGHT) {
				text = ch + text;
			} else if (just == Util.LEFT) {
				text = text + ch;
			}
		}
		return text;
	}

	public static String sendMsg(String request, String host, int port, int timeOut)
			throws lineai.base.exceptions.HostConnectionException, SendRequestException,
			lineai.base.exceptions.ReceiveResponseException, SocketConnectionException {
		StringBuffer response = new StringBuffer();
		Socket socket = null;
		OutputStream output = null;
		InputStream input = null;

		try {
			socket = new Socket(host, port);
			socket.setSoTimeout(timeOut);
		} catch (UnknownHostException e) {
			closeSocket(socket, input, output);
			okDialog("Error de Conexion con Controlador de tienda", null, JOptionPane.ERROR_MESSAGE);
		} catch (ConnectException e) {
			closeSocket(socket, input, output);
			okDialog("Error de Conexion con Controlador de tienda", null, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			closeSocket(socket, input, output);
			okDialog("Error abriendo el puerto de comunicaciones", null, JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			closeSocket(socket, input, output);
			okDialog("Error Consultando art�culo", null, JOptionPane.ERROR_MESSAGE);
		}

		try {
			output = socket.getOutputStream();
			output.write(request.getBytes());
		} catch (IOException e) {
			closeSocket(socket, input, output);
			throw new SendRequestException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			closeSocket(socket, input, output);
			throw new SendRequestException(e.getMessage(), e.getCause());
		}

		byte[] by = new byte[1024];
		try {
			input = socket.getInputStream();
			int i = -1;
			while ((i = input.read(by)) != -1) {
				String str = new String(by, 0, i);
				response.append(str);
			}
		} catch (IOException e) {
			closeSocket(socket, input, output);
			throw new lineai.base.exceptions.ReceiveResponseException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			closeSocket(socket, input, output);
			throw new lineai.base.exceptions.ReceiveResponseException(e.getMessage(), e.getCause());
		}

		closeSocket(socket, input, output);
		String str = response.toString().trim();
		return str;
	}

	/**
	 * 
	 * @param socket
	 * @param input
	 * @param output
	 */
	private static void closeSocket(Socket socket, InputStream input, OutputStream output) {
		try {
			socket.close();
		} catch (Exception e) {
		}
		try {
			input.close();
		} catch (Exception e) {
		}
		try {
			output.close();
		} catch (Exception e) {
		}
	}


	public static void getKey() {
		String platform = System.getProperty("os.name").toLowerCase();
		if (platform.equals("ibm 4690 os") || platform.startsWith("ibm 4690") || platform.startsWith("ibm")) {
			try {
				// ControllerApplicationServices.getStoreControllerIDForTerminal(
				// arg0)
				TerminalApplicationServices.setTermJavaKeysToAwt();
				TerminalApplicationServices.switchToJavaScreen();
			} catch (FlexosException e) {
			}
		}
	}

	public static void returnKey() {
		String platform = System.getProperty("os.name").toLowerCase();
		if (platform.equals("ibm 4690 os") || platform.startsWith("ibm 4690") || platform.startsWith("ibm")) {
			try {
				TerminalApplicationServices.setTermJavaKeysToJavaPOS();
				TerminalApplicationServices.switchToJavaScreen();
			} catch (FlexosException e) {
			}
		}
	}

	public static boolean estaEnEamitemr(String stItemcode) {
		String header = MaosFrame.getHeaderStandard();
		stItemcode = "|" + FuncionProvider.pad(stItemcode + ",0," + 12 + ",izq") + "|";
		MaosFrame maos = new MaosFrame(header, stItemcode);
		maos.setFrameType("10");
		String response = "";
		// String stHostIP = FuncionProvider.getUfparProperty("R::UFPAR:001,");
		try {
			response = Util.sendMsg(maos.toString(), "10.101.33.40", 2500, timeOut).trim();
		} catch (HostConnectionException e) {
			e.printStackTrace();
		} catch (SendRequestException e) {
			e.printStackTrace();
		} catch (ReceiveResponseException e) {
			e.printStackTrace();
		} catch (SocketConnectionException e) {
			e.printStackTrace();
		}

		if (response == null) {
			return false;
		}

		if (response.substring(13, 15).compareTo("99") == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rutina para validar si el codigo ingresado es numerico
	 * 
	 * @param stItemcode
	 * @return
	 * @author hcastaneda
	 */
	public static boolean esNumerico(String stItemcode) {
		stItemcode = stItemcode.trim();
		try {
			Long.parseLong(stItemcode);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Rutina para pintar un mensaje de dialogo en la pantalla
	 * 
	 * @param stMessage
	 * @param dialogo
	 * @param tipo
	 */
	public static void okDialog(final String stMessage, final JDialog dialogo, final int tipo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog((Component) dialogo, stMessage, "Mensaje", tipo);
			}
		});
	}

	/**
	 * Rutina para pintar un dialogo de opciones para continuar con el reescaneo
	 * 
	 * @param stMessage
	 * @param dialogo
	 * @param tipo
	 * @param options2
	 * @return
	 */
	public static int sigaPareMessage(String stMessage, JDialog dialogo, int tipo, Object[] options) {
		return JOptionPane.showOptionDialog((Component) dialogo, stMessage, "Mensaje",
				JOptionPane.YES_NO_CANCEL_OPTION, tipo, null, options, options[0]);
	}

	/**
	 * Rutina para formatear un numero con decimales y miles
	 * 
	 * @param number
	 * @param fix
	 * @param size
	 * @return
	 */
	public static String numberFormat(String number, char fix, int size) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(0);
		String formatedNumber = nf.format(Integer.parseInt(number));

		while (formatedNumber.length() < size)
			formatedNumber = fix + formatedNumber;
		return formatedNumber;
	}



	/**
	 * Rutina que recibe como parametro un c�digo UPC-E, lo expande a UPC-A y los devuelve como respuesta
	 * 
	 * @param input
	 * @return
	 * @author hcastaneda
	 */
	public static String expandUPC_E(String input) {
		String expanded_code = input;
		String manufacturer_code = "";
		String product_code = "";
		if ((input.length() > 6) && (input.length() <= 8)) {
			if (((input.length() == 7) && (input.charAt(0) == '0'))
					|| ((input.length() == 8) && (input.charAt(0) == '0'))) {
				logger.debug("BORRAR - HHC - Codigo leido: [" + input + "]");
				if (input.length() == 7) {
					input = input.substring(0, 7);
				}
				if (input.length() == 8) {
					input = input.substring(1, 8);
				}

				char lastdigit = input.charAt(5);
				switch (lastdigit) {
				case '0':
				case '1':
				case '2':
					manufacturer_code = input.substring(0, 2) + input.charAt(5) + "00";
					product_code = "00" + input.substring(2, 5);
					break;
				case '3':
					manufacturer_code = input.substring(0, 3) + "00";
					product_code = "000" + input.substring(3, 5);
					break;
				case '4':
					manufacturer_code = input.substring(0, 4) + "0";
					product_code = "0000" + input.charAt(4);
					break;
				default:
					manufacturer_code = input.substring(0, 5);
					product_code = "0000" + input.charAt(5);
					break;
				}
				expanded_code = "0" + manufacturer_code + product_code;

				// Simula un digito de chequeo arbitrario que luego se elimina
				// expanded_code = expanded_code + '0';
			}
		}
		return expanded_code;
	}

}