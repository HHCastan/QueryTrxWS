package com.lds.terminalutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import com.ibm.OS4690.TerminalApplicationServices;
import com.ibm.OS4690.TerminalStatusData;

/**
 * @author camilo.alvarez
 * 
 */
public class VoucherGenerator {

	public static final String VERSION = "1.2.11";

	private static final String LOG_PREFIX = "[VoucherGenerator]: ";

	private static final String PROPERTIES_CONF_PATH = "/conf/voucherg.pro";

	private static final String VOUCHERGENERATOR_TAG_CONFIG = "VoucherGenerator_Config";

	private String ufparPath;

	private HashMap mapConfig;

	private Properties config;

	private static final String $_REPLACE = "_23str976raro126camilo0358_";

	private static String VOUCHER_FOOT = "VoucherFoot";

	/**
	 * 
	 */
	public VoucherGenerator() {

		System.out.println(LOG_PREFIX + "Version: " + VERSION);
		config = new Properties();

		try {
			config.load(this.getClass().getResourceAsStream(PROPERTIES_CONF_PATH));
		} catch (Throwable e) {
			System.out.println();
			e.printStackTrace();
			System.out.println(LOG_PREFIX + "Error cargando archivo de configuracion " + PROPERTIES_CONF_PATH);
		}
		log("Version: " + VERSION + "\n");
	}

	/**
	 * Genera un archivo de texto con Vauchers, de acuerdo a los parametros
	 * ingresados.
	 * 
	 * @param params
	 *            si la ruta del UFPAR se envia vacia, se toma la ruta
	 *            configurada en el archivo properties. Los TAG a consultar,
	 *            seran los enviados en la trama, con los sufijos especificados
	 *            en el TAG de configuracion, del UFPAR.
	 * 
	 * @Example |R::ADX_IDT1:UFPAR002|VoucherCompra`0071682911`48400`329400`El
	 *          valor de la cuota incluye capital, financiacion, calculada con
	 *          la tasa de interes vigente e IVA por financiacion.`El valor del
	 *          seguro incluye IVA`Aura Mu�oz
	 *          Montoya`CC`21610258`01/nov/14`23903
	 *          `166`1036`1`25105`21CC-577`01/
	 *          oct/14`1`25105`2`577`M`28.9290`21CC
	 *          `25105`0`670600`12760`motivo1;
	 *          fecha1;valor1|motivo2;fecha2;valor2|motivo3;fecha3;valor3|
	 */
	public String generate(String params) {

		log("Iniciando proceso de generacion de Vouchers con los siguientes parametros:\n" + params);

		String[] fullTokens = loadFullTokens(params);
		if (fullTokens == null) {
			return config.getProperty("FAILURE_MESSAGE") + "Error en parametros recibidos.";
		}

		if (!loadConfig(fullTokens[0])) {
			return config.getProperty("FAILURE_MESSAGE") + "Error en archivo de parametros.";
		}

		String[] Lista_ID_Parametros = loadIDParameters();
		if (Lista_ID_Parametros == null) {
			return config.getProperty("FAILURE_MESSAGE") + "Error en archivo de parametros.";
		}

		log("Generando Vouchers..");
		String output = null;
		try {
			output = buildVouchers(fullTokens, Lista_ID_Parametros);
		} catch (Throwable e) {
			System.out.println();
			e.printStackTrace();
			log("Error generando Vouchers " + e.getMessage());
			return config.getProperty("FAILURE_MESSAGE") + "Error generando Vouchers.";
		}
		if (output == null) {
			log("No se Generaron Vouchers.");
			return config.getProperty("FAILURE_MESSAGE") + "No se Generaron Vouchers.";
		}
		
		/*
		 * Los vouchers originales no llevan pie de pagina, solo la copia.
		 */
		String outputCopy = output;
		
		try {
			output = output.replaceAll(VOUCHER_FOOT, "");
		} catch (Exception e1) {
		}
		
		String outputFilename = null;
		try {
			String tokens = mapConfig.get("Archivo_Voucher").toString();
			String[] strings = getTokens(tokens, ",");
			outputFilename = strings[1];
		} catch (Throwable e) {
			System.out.println();
			e.printStackTrace();
			log("Error recuperando nombre del archivo de salida para los Vouchers: " + e.getMessage());
			return config.getProperty("FAILURE_MESSAGE") + "Error escribiendo Vouchers.";
		}

		log("Imprimiendo Vouchers en: " + outputFilename + " Texto:\n" + output);
		final boolean success = printVoucherToFile(output, outputFilename);
		if (success) {
			log("Vouchers impresos exitosamente.");
		}
		/*
		 * Copia de Vouchers
		 */
		try {
			String strCopyEnabled = mapConfig.get("Copia_Voucher").toString();
			boolean copyEnabled = Boolean.valueOf(strCopyEnabled).booleanValue();

			if (copyEnabled) {
				try {
					String tokens = mapConfig.get("Archivo_Voucher_copia").toString();
					String[] strings = getTokens(tokens, ",");
					String backupOutputFilename = strings[1];

//					TODO externalizar String
					outputCopy = outputCopy.replaceAll(VOUCHER_FOOT, "*** COPIA *** |\r\n");
					
					if (printVoucherToFile(outputCopy, backupOutputFilename)) {
//					regs.append("|\r\n");
						log("Copia de Vouchers impresa exitosamente.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					log("Error imprimiendo copia de Vouchers: " + e.getMessage());
				}
			}

		} catch (Exception e) {
//			System.out.println();
//			e.printStackTrace();
			log("No se imprimio copia de Vouchers. Esto se debe a que no esta configurada o a que ocurrio un error.");
		}
		// TODO succes debe depender de la copia?
		if (success) {
			return config.getProperty("SUCCESS_MESSAGE") + outputFilename;
		}

		return config.getProperty("FAILURE_MESSAGE") + "Error en la generacion de Vouchers";
	}

	/**
	 * Carga los ID de los parametros de ejecucion esperados
	 * 
	 * @return
	 */
	private String[] loadIDParameters() {
		String[] Lista_ID_Parametros = null;
		String property = null;
		try {
			log("Obteniendo la lista de los ID de parametros, del arvhivo " + ufparPath);
			property = mapConfig.get("Lista_ID_Parametros").toString();
			Lista_ID_Parametros = getTokens(property, ",");
		} catch (Throwable e1) {
			System.out.println();
			e1.printStackTrace();
			log("Error obteniendo la lista de los ID de parametros con [" + property + "]: " + e1.getMessage());
		}
		if (Lista_ID_Parametros.length == 0) {
			log("No se recuperaron los ID de parametros, del arvhivo " + ufparPath);
			Lista_ID_Parametros = null;
		}
		return Lista_ID_Parametros;
	}

	/**
	 * Carga todos los parametros de ejecucion enviados en la trama
	 * 
	 * @param params
	 * @return
	 */
	private String[] loadFullTokens(String params) {
		String[] fullTokens = null;
		try {
			fullTokens = getTokens(params, config.getProperty("REG_SEPARATOR"));
		} catch (Throwable e) {
			System.out.println();
			e.printStackTrace();
			log("Error creando Tokens con los parametros de ejecucion: " + e.getMessage());
		}

		if (fullTokens.length == 0) {
			log("No se recuperaron Tokens con los parametros de ejecucion.");
			fullTokens = null;
		}
		return fullTokens;
	}

	/**
	 * Carga la configuracion definida en un archivo UFPAR
	 * 
	 * @param ufparPath
	 */
	private boolean loadConfig(String ufparPath) {

		boolean result = false;
		if (ufparPath == null || ufparPath.length() == 0) {
			this.ufparPath = config.getProperty("UFPAR_PATH");
			log("ruta UFPAR obtenida del properties");
		} else {
			this.ufparPath = ufparPath;
			log("ruta UFPAR obtenida de la terminal");
		}

		try {
			mapConfig = loadUfparParametersInMap(ufparPath, VOUCHERGENERATOR_TAG_CONFIG);
			result = true;
		} catch (Throwable e2) {
			System.out.println();
			e2.printStackTrace();
			log("Error cargando el TAG de configuracion. UFPAR=[" + ufparPath + "] TAG=[" + VOUCHERGENERATOR_TAG_CONFIG
					+ "]: " + e2.getMessage());
		}
		return result;
	}

	/**
	 * Carga los parametros de un TAG de un UFPAR en una cadena de texto
	 * 
	 * @param ufparFile
	 *            ruta completa del UFPAR
	 * @param tagName
	 *            nombre del TAG a cargar
	 * @param parameterName
	 *            Opcional. Si se envia null o vacio, se retornan todos los
	 *            parametros del TAG. Sino, se retorna solo el valor del
	 *            parametro enviado.
	 * @return cadena con los parametros del TAG
	 * @throws Throwable
	 */
	private StringBuffer loadUfparParameters(String ufparFile, String tagName, String parameterName) throws Throwable {

		StringBuffer text = new StringBuffer();
		LineNumberReader lnr = null;
		try {
			String line = null;
			lnr = new LineNumberReader(new FileReader(ufparFile));
			line = lnr.readLine();

			while (line != null && !line.equals("[" + tagName + "]")) {
				line = lnr.readLine();
			}
			log("TAG encontrado: [" + line + "]");

			if (line != null) {
				line = lnr.readLine();

				while (line != null && !line.equals("")) {
					int numkey = line.indexOf('=');

					if (numkey > 0) {
						String value = line.substring(numkey + 1, line.length());

						if (parameterName != null && parameterName.length() > 0) {

							String key = line.substring(0, numkey).trim();
							if (key.equals(parameterName)) {
								lnr.close();
								return new StringBuffer(value);
							}
						}
						if (value.trim().equalsIgnoreCase(config.getProperty("END_FLAG"))) {
							break;
						}
						text.append(value);
						text.append("|\r\n");
					}
					line = lnr.readLine();
				}
			}
			lnr.close();
			return text;
		} catch (Throwable ioe) {
			System.out.println();
			ioe.printStackTrace();
			log("Error leyendo el TAG " + tagName + " del archivo " + ufparFile + ": " + ioe.getMessage());
			try {
				lnr.close();
			} catch (Throwable e) {
				throw e;
			}
			throw ioe;
		}
	}

	/**
	 * Carga los parametros de un TAG de un UFPAR en un mapa
	 * 
	 * @param ufparFile
	 *            ruta completa del UFPAR
	 * @param tagName
	 *            nombre del TAG a cargar
	 * @return mapa con los parametros del TAG
	 * @throws Throwable
	 */
	private HashMap loadUfparParametersInMap(String ufparFile, String tagName) throws Throwable {

		log("Cargando parametros de TAG=[" + tagName + "] UFPAR=[" + ufparFile + "]");
		LineNumberReader lnr = null;
		try {
			String line = null;
			HashMap map = new HashMap();
			lnr = new LineNumberReader(new FileReader(ufparFile));
			line = lnr.readLine();
			log("line0=[" + line + "]");

			while (line != null && !line.equals("[" + tagName + "]")) {
				line = lnr.readLine();
				log("line1=[" + line + "]");
			}
			log("TAG encontrado: [" + line + "]");

			if (line != null) {
				line = lnr.readLine();
				log("concatenando lineas...");
				while (line != null && !line.equals("")) {
					log("line2=[" + line + "]");
					int numkey = line.indexOf('=');
					if (numkey > 0) {
						String key = line.substring(0, numkey).trim();
						String value = line.substring(numkey + 1, line.length()).trim();
						map.put(key, value);
					}
					line = lnr.readLine();
				}
			}
			lnr.close();
			return map;
		} catch (Throwable ioe) {
			System.out.println();
			ioe.printStackTrace();
			log("Error leyendo el TAG " + tagName + " del archivo " + ufparFile + ": " + ioe.getMessage());
			try {
				lnr.close();
			} catch (Throwable e) {
				throw e;
			}
			throw ioe;
		}
	}

	/**
	 * Construye el texto de Vouchers
	 * 
	 * @param fullTokens
	 *            parametros enviados de la terminal
	 * @param Lista_ID_Parametros
	 *            ID's de los parametros para reemplazar en la plantilla del
	 *            Voucher
	 * @return Texto de los Vouchers
	 */
	private String buildVouchers(String[] fullTokens, String[] Lista_ID_Parametros) {

		StringBuffer customerVouchers = new StringBuffer();
		StringBuffer storeVouchers = new StringBuffer();
		String paperCutCode = loadPaperCutCode();
		boolean thereCustomerVouchers = false;

		for (int i = 1; i < fullTokens.length; i++) {
			String[] tokens = getTokens(fullTokens[i], config.getProperty("FIELD_SEPARATOR"));

			/* En la primera posicion viene el tipo de Voucher */
			if (Lista_ID_Parametros.length != (tokens.length - 1)) {
				log("El numero de parametros enviados desde la terminal (" + (tokens.length - 1)
						+ "), no corresponde con el numero de parametros definidos en " + ufparPath + " ("
						+ Lista_ID_Parametros.length + ")");
				return null;
			}

			String voucherType = tokens[0];

			/*
			 * Copia Cliente
			 */
			String customerVoucher = replaceParameters(Lista_ID_Parametros, tokens,
					voucherType + config.getProperty("CUSTOMER_VOUCHER_TYPE_SUFFIX"));

			if (customerVoucher != null && customerVoucher.length() > 0) {
				thereCustomerVouchers = true;
				if (i > 1) {
					customerVouchers.append(paperCutCode);
					customerVouchers.append("\n");
				}
				customerVouchers.append(customerVoucher);
				customerVouchers.append(VOUCHER_FOOT);
			}
			/*
			 * Copia Almacen
			 */
			String storeVoucher = replaceParameters(Lista_ID_Parametros, tokens,
					voucherType + config.getProperty("STORE_VOUCHER_TYPE_SUFFIX"));

			if (storeVoucher != null && storeVoucher.length() > 0) {
				if (thereCustomerVouchers || i > 1) {
					storeVouchers.append(paperCutCode);
					storeVouchers.append("\n");
				}
				storeVouchers.append(storeVoucher);
				storeVouchers.append(VOUCHER_FOOT);
			}
		}
		return customerVouchers.append(storeVouchers).toString();
	}

	/**
	 * Recupera el codigo para corte de papel. Si no es posible recuperarlo del
	 * archivo de configuracion, se devuelve "@@ct" por default.
	 * 
	 * @return Codigo para corte de papel.
	 */
	private String loadPaperCutCode() {
		String paperCutCode = null;
		try {
			paperCutCode = mapConfig.get(config.getProperty("PaperCutCodeParameterName")).toString();
		} catch (Throwable e) {
			/* no importa */
		}
		if (paperCutCode == null || paperCutCode.length() == 0) {
			log("buscando el codigo para corte de papel en [" + config.getProperty("TerminalCodesUfparName") + "]");
			try {
				paperCutCode = loadUfparParameters(config.getProperty("TerminalCodesUfparName"),
						config.getProperty("TerminalCodesUfparTag"), config.getProperty("PaperCutCodeParameterName"))
						.toString();

				int index = paperCutCode.indexOf(",");
				if (index != -1) {
					paperCutCode = paperCutCode.substring(index + 1, paperCutCode.length());
				}

			} catch (Throwable e) {
				System.out.println();
				e.printStackTrace();
				log("Error buscando el codigo para corte de papel: " + e.getMessage());
				paperCutCode = "@@ct";
			}
		}
		return paperCutCode;
	}

	/**
	 * Reemplaza los parametros de la plantilla de un Voucher, con los
	 * parametros enviados desde la Terminal.
	 * 
	 * @param Lista_ID_Parametros
	 * @param tokens
	 * @param voucherType
	 */
	private String replaceParameters(String[] Lista_ID_Parametros, String[] tokens, String voucherType) {

		StringBuffer voucherScheme = loadVoucherScheme(voucherType);
		if (voucherScheme == null || voucherScheme.length() == 0) {
			log("Error: no se encontro la plantilla del Voucher [" + voucherType + "]");
			return null;
		}
		String voucher = voucherScheme.toString();
		try {
			voucher = voucher.replaceAll("\\$", $_REPLACE);
		} catch (Exception e1) {
			System.out.println();
			e1.printStackTrace();
			log("Error reemplazando temporalmente el caracter \\$");
		}

		for (int i = 0; i < Lista_ID_Parametros.length; i++) {

			String replace = tokens[i + 1];
			String idParam = Lista_ID_Parametros[i];
			log("Procesando el parametro [" + idParam + "] = [" + replace + "]");

			if (voucher.indexOf($_REPLACE + idParam) != -1) {
				log("Parseando el parametro [" + idParam + "] = [" + replace + "] con formato de moneda");
				try {
					replace = parseCurrency(replace);
					// replace = replace.replaceAll("\\$", $_REPLACE);
				} catch (Exception e) {
					System.out.println();
					e.printStackTrace();
					log("Error aplicando formato de moneda a la siguiente cadena: " + replace + ": " + e.getMessage());
				}
			} else if (idParam.equalsIgnoreCase("@Fecha")) {
				try {
					replace = parseDate(replace, mapConfig.get("Formato_Fecha_Origen").toString(),
							mapConfig.get("Formato_Fecha_Destino").toString());
				} catch (Throwable e) {
					System.out.println();
					e.printStackTrace();
					log("Error parseando el parametro [" + idParam + "] = [" + tokens[i + 1] + "]: " + e.getMessage());
				}
			} else if (idParam.equalsIgnoreCase("@Hora")) {
				try {
					replace = parseDate(tokens[i + 1], mapConfig.get("Formato_Hora_Origen").toString(),
							mapConfig.get("Formato_Hora_Destino").toString());
				} catch (Throwable e) {
					System.out.println();
					e.printStackTrace();
					log("Error parseando el parametro [" + idParam + "] = [" + tokens[i + 1] + "]: " + e.getMessage());
				}
			} else if (idParam.startsWith("#")) {

				try {
					int idx = voucher.indexOf(idParam);

					if (idx == -1) {
						log("No se encontro la tabla " + idParam + " en la plantilla del Voucher:\n" + voucher);
						continue;
					}

					StringBuffer regs = new StringBuffer();
					// voucher = voucher.replaceAll("\\$",
					// "$_REPLACE");
					idx = voucher.indexOf(idParam);
					String regScheme = voucher.substring(idx, voucher.lastIndexOf(idParam) + idParam.length());
					String[] rows = getTokens(replace, "~");
					String resultado = "";
					String regLine = regScheme;
					
					for (int j = 0; j < rows.length; j++) {
						String[] values = getTokens(rows[j], ";");

						for (int k = 0; k < values.length; k++) {
							resultado = resultado.concat(values[k] + "\t");
							//regLine = regLine.replaceFirst(idParam, values[k]);
						}
						resultado = resultado.concat("|\r\n");
					}
					resultado = resultado.substring(0,resultado.length()-1);
					regLine = regLine.replaceFirst(idParam, resultado);
					regs.append(regLine);
//					regs.append("|\r\n");
					idParam = regScheme;
					replace = regs.toString();
				} catch (Throwable e) {
					System.out.println();
					e.printStackTrace();
					log("Error construyendo tabla: " + e.getMessage());
				}
			}
			try {
				log("Reemplazando: [" + idParam + "] con [" + replace + "]");
				voucher = voucher.replaceAll(idParam, replace);
				// voucher = voucher.replaceAll("$_REPLACE", "\\$");
			} catch (Throwable e) {
				System.out.println();
				e.printStackTrace();
				log("Error reemplazando: [" + idParam + "] con [" + replace + "]");
			}
		}
		try {
			voucher = voucher.replaceAll($_REPLACE, "\\$");
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
			log("Error devolviendo el reemplazo del caracter \\$");
		}
		return voucher;
	}

	/**
	 * Carga la plantilla de un Voucher, desde un archivo UFPAR
	 * 
	 * @param tag
	 *            TAG del UFPAR donde se encuentra la plantilla a cargar
	 * 
	 * @return variable que almacena los parametros de un TAG del UFPAR
	 * @throws Exception
	 */
	private StringBuffer loadVoucherScheme(String tag) {

		StringBuffer output = null;

		try {
			log("buscando TAG [" + tag + "]");
			output = loadUfparParameters(ufparPath, tag, null);
		} catch (Throwable e1) {
			System.out.println();
			e1.printStackTrace();
			log("Error leyendo los parametros del TAG [" + tag + "] en el archivo " + ufparPath + ": "
					+ e1.getMessage());
		}

		return output;
	}

	/**
	 * Imprime el texto en el archivo de texto especificados.
	 * 
	 * @param outputText
	 * @param outputFilename
	 * 
	 */
	private boolean printVoucherToFile(String outputText, String outputFilename) {

		BufferedWriter writter = null;
		try {
			writter = new BufferedWriter(new FileWriter(new File(outputFilename)));
		} catch (Throwable e) {
			System.out.println();
			e.printStackTrace();
			log("Error creando el arvhivo [" + outputFilename + "]");
			return false;
		}

		try {
			writter.write(outputText);
			writter.newLine();
			writter.close();
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
			log("Error escribiendo en el arvhivo [" + outputFilename + "]");
			return false;
		}
		return true;
	}

	private String[] getTokens(String str, String delim) {

		StringTokenizer tokenizer = new StringTokenizer(str, delim);

		String tokens[] = new String[tokenizer.countTokens()];
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = tokenizer.nextToken();
		}
		return tokens;
	}

	/**
	 * @param originDate
	 * @param originDateFormat
	 * @param targetDateFormat
	 * @return
	 * @throws ParseException
	 */
	private String parseDate(String originDate, String originDateFormat, String targetDateFormat) throws ParseException {

		log("Parseando: " + originDate + " " + originDateFormat + " " + targetDateFormat);

		SimpleDateFormat format = new SimpleDateFormat(originDateFormat.trim());
		Date date = format.parse(originDate);
		format.applyPattern(targetDateFormat.trim());
		String formatedDate = format.format(date);

		return formatedDate.toUpperCase();
	}

	/**
	 * Logger de la aplicacion
	 * 
	 * @param message
	 */
	private void log(String message) {

		boolean enabled = false;
		boolean logToFile = false;
		BufferedWriter writter = null;

		String outputFilename =config.getProperty("DEBUG_LOG_NAME");
		try {
			enabled = Boolean.valueOf(config.getProperty("LOGGER_ENABLED")).booleanValue();
		} catch (Exception e) {
			/* no importa */
		}
		if (enabled) {
			String date = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
			if(logToFile) {
				try {
					writter = new BufferedWriter(new FileWriter(new File(outputFilename)));
				} catch (Throwable e) {
					System.out.println();
					e.printStackTrace();
					log("Error creando el arvhivo [" + outputFilename + "]");
				}
				try {
					writter.write(message);
					writter.newLine();
					writter.close();
				} catch (IOException e) {
					System.out.println();
					e.printStackTrace();
					log("Error escribiendo en el arvhivo [" + outputFilename + "]");
				}				
			} else
				System.out.print("\n<" + date + "> - " + LOG_PREFIX + message);
		}
	}

	/**
	 * Formatea una cadena de valores numericos, con formato de moneda.
	 * 
	 * @param strMoney
	 *            cadena de valores numericos
	 * @return representacion en formato de moneda, de la cadena especificada.
	 * @throws Exception
	 */
	private String parseCurrency(String strMoney) throws Exception {

		double money = 0;
		try {
			money = Double.parseDouble(strMoney);
		} catch (Exception e) {
			/* No importa */
		}
		DecimalFormat format = new DecimalFormat("###,###,###.##");
		String strCurrencyMoney = format.format(money);
		String monetaryFormat = "";

		try {
			if (TerminalApplicationServices.getTerminalStatus().getMonetaryFormat() == TerminalStatusData.COMMA_CONVENTION) {
				monetaryFormat = ".";
				strCurrencyMoney = strCurrencyMoney.replaceAll(",", monetaryFormat);
			}
			else if (TerminalApplicationServices.getTerminalStatus().getMonetaryFormat() == TerminalStatusData.PERIOD_CONVENTION) {
				monetaryFormat = ",";
				strCurrencyMoney = strCurrencyMoney.replaceAll(".", monetaryFormat);
			}
			else {
				strCurrencyMoney = strCurrencyMoney.replaceAll(",", ".");
			}
			log("Formato monetario del sistema: [" + monetaryFormat + "]");
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
			log("Error obteniendo el formato monetario del sistema: " + e.getMessage());
			strCurrencyMoney = strCurrencyMoney.replaceAll(",", ".");
		}

		return strCurrencyMoney;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		DecimalFormat format = new DecimalFormat("###,###,###.##");
//		double money = 1000;
//		String strCurrencyMoney = format.format(money);
//		System.out.println(strCurrencyMoney);
		
		VoucherGenerator voucherG = new VoucherGenerator();
//		String idParam = "s:/proyectos/llamado de funciones/UFPAR010|VoucherConsultaInventario`BRASIER`7703794143412`ACTIVO`MILE GIRL` ` ` ` ` ` `;ALMACEN;INICIAL;COMPRAS;VENTAS;FINAL~PARQUE;1.00;0.00;0.00;1.00~BOLIVAR;1.00;0.00;0.00;1.00~ITAGUI;1.00;0.00;0.00;1.00~BELLO;1.00;0.00;0.00;1.00~ARMENIA;1.00;0.00;0.00;1.00~IBAGUE;1.00;0.00;0.00;1.00~SINCELEJO;1.00;0.00;0.00;1.00~VILLAVICENCIO;1.00;0.00;0.00;1.00~PIEDECUESTA;1.00;0.00;0.00;1.00~TOTAL;;9.00;0.00;0.00;9.00`0|";
		String idParam = "s:/proyectos/llamado de funciones/UFPAR010|VoucherConsultaObligaciones`BLANCA ELIZABETH GRAJALES GALLEGO`---7317`SALDO MEFIA  = 0`PAGO MINIMO  = 0` ` ` ` ` ` `;MODALIDAD;FECHA;VALOR;SALDO;VENCIDO~CRDITO PASEATA;20150821;231912;19326;19326~CREDITO PERSONAL;20150314;539504;41294;41294~SEGURO CREDITO;20150314;95453;5157;5157~CTA CTE ESPECIAL;20160114;512136;384102;384102~SEGURO CREDITO E;20160114;129048;96786;96786~CREDITO PERSONAL;20160114;351444;169877;169877~SEGURO CREDITO;20160114;38762;18996;18996~TOTAL;;;1898259;735538;735538`0|";
		System.out.println(voucherG.generate(idParam));

		try {
			if (idParam.startsWith($_REPLACE + "@")) {
				final VoucherGenerator gen = new VoucherGenerator();
				System.out.println(gen.parseCurrency("00000862"));
				System.out.println(gen.parseCurrency("000008620"));
				System.out.println(gen.parseCurrency("0"));
				System.out.println(gen.parseCurrency("0000"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// String strMoney = "$@";
		//
		// double money = 1001236868735d;
		// NumberFormat formatter = NumberFormat.getCurrencyInstance();
		// System.out.println(formatter.format(money));
		//
		// DecimalFormat formatter2 = new DecimalFormat("$###,###,###.##");
		// System.out.println(formatter2.format(money));

		/*
		 * 
		 */

		// String str =
		// "lfjiauh#TablaFinanciacion : #TablaFinanciacion : $#TablaFinanciacionldzignaodg";
		// String table =
		// "#TablaFinanciacion : #TablaFinanciacion : $#TablaFinanciacionldzignaodg";
		// String replacement = "Consumo de PAR 18/09/14 18/ago/14 $350\n" +
		// "21CC-802 03/oct/14  $922\n"
		// + "21CC-803 03/oct/14  $922\n" + "21CC-1226 07/oct/14 $921\n" +
		// "21CC-1229 07/oct/14 $921\n"
		// + "21CC-1230 07/oct/14 $921\n" + "21CC-1470 09/oct/14 $614\n" +
		// "21CC-1474 09/oct/14 $614\n"
		// + "21CC-1476 09/oct/14 $614";
		//
		// str = str.replaceAll("\\$", "23str976raro126camilo0358");
		// replacement = replacement.replaceAll("\\$",
		// "23str976raro126camilo0358");
		// table = table.replaceAll("\\$", "23str976raro126camilo0358");
		// str = str.replaceAll(table, replacement);
		// str = str.replaceAll("23str976raro126camilo0358", "\\$");
		//
		// System.out.println(str);

		/*
		 * 
		 */

		// Pattern p = Pattern.compile(table);
		// Matcher m = p.matcher(str);
		// StringBuffer buff = new StringBuffer();
		// while (m.find()) {
		// m.appendReplacement(buff, replacement);
		// }
		// m.appendTail(buff);
		// System.out.println(buff);

		// try {
		// VoucherGenerator voucherGenerator = new VoucherGenerator();
		// System.out.println("Voucher:\n"
		// + voucherGenerator.loadUfparParameters("ufpar953.txt",
		// "VoucherCompra_copiaAlmacen", null));
		// System.out.println("Voucher:\n"
		// + voucherGenerator.loadUfparParameters("ufpar953.txt",
		// "VoucherCompra_copiaCliente", null));
		// } catch (Throwable e1) {
		// e1.printStackTrace();
		// }
		/*
		 * 
		 */
		// String regex = "@Fecha";
		// String src = "Texto de @prueba: @Fecha, Fin texto de prueba";
		// String src2 = src.replaceAll(regex, "Fec\\$a: 5-Sep-2014");
		// System.out.println(src2);
		/*
		 * 
		 */
		// String param = "140107153013";
		// SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		// try {
		// Date date = format.parse(param);
		// format.applyPattern("MMM dd, yyyy HH:mm:ss");
		// System.out.println(format.format(date).toUpperCase());
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
	}
}