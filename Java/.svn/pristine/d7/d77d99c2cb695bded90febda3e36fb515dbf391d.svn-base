package com.lineai.posappframework.PEF.userdefined.WS_FALSolutions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.BitSet;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ibm.OS4690.FlexosException;
import com.ibm.OS4690.TerminalApplicationServices;
import com.ibm.OS4690.TerminalStatusData;
import com.linea.posappEnginePromotions.Voucher.Voucher;
import com.linea.posappEnginePromotions.cargaPropiedades.CargadorPropiedades;
import com.linea.posappEnginePromotions.contenedores.ContenedorConexion;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.Instancia;
import com.lineai.posappframework.xmlwrappers.actors.userdefined.WS_FALSolution.FALWrapper;

public class Core
{
  private static final String DESCRIPTION = "Actor de conexion con WS de FAL Solutions";
  private static BitSet flags = new BitSet(2);
  private static final String VERSION = "1.4.5.3";
  private static FALWrapper xmlWrapper;
  private static final String ACTOR_NAME = "[WS_FALSolutionsActor] - ";
  private static final String MODULE_NAME = "[PosappEnginePromotions]";
  private static String stControlerID = "";
  private static String host;
  private static String tomcatServer;
  private static String[][] conexion;
  private static CargadorPropiedades loader;
  private static Logger log = null; 
  private static Logger errorLog = null;
  private static final boolean isOS4690 = false;

  public Core()
  {

    /*
     * Para entorno gráfico
     */
    
    try
    {
      confLogger();
      
    }
    catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch(Exception e)
    {
      
    }
    // Log.iniTerminal();
    log = Logger.getLogger(Core.class);
    errorLog = Logger.getLogger("error." + Core.class.getName());
	cargarPropiedades();
    if (log.isInfoEnabled())
      log.info(MODULE_NAME + "Iniciando Core PEF Version:" + VERSION);
    // Log.logInfo(MODULE_NAME + "Iniciando Core PEF Version:" + VERSION);
    Voucher.init();
    /*
     * edgar.cuesta Se cargan los "contenedores". Que extraen la información de
     * archivos ya sea de configuración del sistema (UFPAR), o de java (archivos
     * properties y xml)
     */

    Core.prueba();
  }

  public static String execute(String msg) throws RemoteException
  {
    msg = sSTrim(msg, " ");
    if (msg.lastIndexOf('|') == msg.length() - 1)
    {
      msg = msg.substring(0, msg.lastIndexOf('|'));
    }
    String Response = "";
    try
    {
      if (log.isInfoEnabled())
        log.info(MODULE_NAME + "<Iniciando Execute> - msg: " + msg);
      // Log.logInfo(MODULE_NAME + "<Iniciando Execute> - msg: " + msg);
      String[] stMessageIN = sSplit(msg, "|");
      ProcessRequest process = new ProcessRequest();
      Response = process.getResponse(stMessageIN);
    }
    catch (Throwable t)
    {
      // System.out.println("Lanzado un throwable Core");
      errorLog.error(MODULE_NAME + "Error al ejecutar el mensaje: " + t.getClass().getName() + ":" + t.getMessage(), t);
      // Log.logError(MODULE_NAME + "Error al ejecutar el mensaje: " +
      // t.getMessage());
      // t.printStackTrace();
    }
    return Response;
  }

  public static String[] sSplit(String msg, String separador)
  {
    char cmsg[] = msg.toCharArray();
    int cont = 0;
    for (int i = 0; i < cmsg.length; i++)
      if (separador.equals(cmsg[i] + ""))
        cont++;
    // System.out.println(cont);
    String split[] = new String[cont + 1];
    for (int i = 0; i < cont + 1; i++)
      split[i] = "";
    cont = 0;
    for (int i = 0; i < cmsg.length; i++)
      if (!separador.equals(cmsg[i] + ""))
        split[cont] += cmsg[i];
      else
        cont++;

    return split;
  }

  public static String sSTrim(String msg, String quitar)
  {
    char cmsg[] = msg.toCharArray();
    String trim = "";
    for (int i = 0; i < cmsg.length; i++)
      if (!quitar.equals(cmsg[i] + ""))
        trim += cmsg[i];

    return trim;
  }

  public static void main(String arg[])
  {

    // System.out.println(System.getProperty("config.home"));
    // System.setProperty("config.home", "mi conf");
    // System.out.println(System.getProperty("config.home"));

    // AddLibraries.init();
    // Voucher.init();
    // Voucher.setPath("C:/Users/edgar.cuesta/vouchers.txt");
    // new Log().init();
    new Core();
    // DeviceManager.setDeviceRegistrationComplete();
    // System.out.println("Iniciando Core\n");
    // xmlWrapper = new FALWrapper();
    // conexion = xmlWrapper.getConexion();
    // xmlWrapper = null;

    // Casos de prueba
    // String msg1=
    // "1|0000000123|COP|9999999999999999999|00001|001|20120427|000000001|130000";
    // String msg1=
    // "1|0000000123|COP|3000010000100000022|00001|001|20120508|000000001|111000";
    // String msg1=
    // "1|0000000123|COP|3000012000010000006|00001|001|20120508|000000001|111300";
    // String msg1 =
    // "1|0000000123|COP|3000012000010000006|0100|001|20120516|29|175548";
    // String msg1 =
    // "1|0000000123|COP|3000012000010000006|0100|001|20120517|25|151718";
    // String msg1 = "1|0000000123|COP|79277288|0100|001|20120604|4|144317";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120604|4|144317";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120605|31|160833";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120605|31|160833";
    // String msg1 = "1|0000000123|COP|2775975|0100|001|20120607|55|172539";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120613|2|090507";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120613|2|093007";
    // String msg1 = "1|0000000123|COP|8346590|0100|001|20120613|4|100705";
    // String msg1 = "1|0000000123|COP|354339|0100|001|20120613|14|113730";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120620|2|091523";
    // String msg1 = "1|0000000123|COP|355724|0100|001|20120622|12|151415";
    // String msg1 = "1|0000000123|COP|21385014|0100|001|2775975|12|112315";
    String msg1 = "1|0000000123|COP|3482114|0061|001|20120808|17|092729";
    // String msg1 =
    // "1|0000000123|COP|70089323|0100|001|20120619|30|142045";
    // String msg1 = "1|0000000123|COP|1456978|0100|001|20120613|10|101641";
    // String msg1=
    // "1|0000000123|COP|3000010000100000020|00100|001|20120502|000000001|115000";
    // String msg1=
    // "1|0000000123|COP|3000010000100000005|00001|001|20120425|000000001|130000";
    // String msg1=
    // "1|0000000123|COP|3000012000100000024|00001|001|20120425|000000001|130000";

    // String msg2
    // ="0|10|1,,1,10000,0|1,,2,10000,0|1,,3,10000,0|1,,4,10000,0|1,,5,10000,0";
    // String msg2 ="0|10|1,,6,10000,0|1,,7,10000,0|1,,8,10000,0";
    // String msg2 =
    // "0|10|3,,9,10000,0|2,,3,200000,0|1,,1,50000,0|1,,2,300000,0|1,,4,7000000,0|1,,5,20000,0|1,,6,100000,0|1,,7,150000,0|2,,8,60000,0";
    // String msg2 = "0|10|2,,1,200000,0";
    // String msg2 =
    // "0|0000000123|1,565,770326095321,31900,0|1,565,770326095313,11900,0";
    // String msg2 =
    // "0|0000000123|1,565,770326095321,31900,1|1,565,770326095313,11900,1|1,565,770326095306,11900,0|1,565,770326095309,11900,0";
    // String msg2 =
    // "0|0000000123|1,565,770326095321,31900,1|1,565,770326095313,11955,1|2,565,770326095306,21913,0|2,565,770326095309,9,0";
    // String msg2 =
    // "0|0000000123|2,565,770326095309,0000011900,0|1,565,770326095313,0000011900,1|1,565,770326095306,0000011900,0";
    // String msg2 = "0|0000000123|1,533,770328449541,0000007950,0";
    // String msg2 =
    // "0|0000000123|1,533,770328449541,0000007950,0|4500,565,770326095306,0000011900,0";
    // String msg2 =
    // "0|0000000123|1,0,770236095313,10000,0|1,0,770326095306,0000011900,0|1,0,770326095309,0000013900,0|1,0,770326095321,000009900,0";
    // String msg2 =
    // "0|0000000123|1,0,9,0000013900,0|1,0,3,10000,0|1,0,770236095313,10000,0|1,0,770326095306,0000011900,0|1,0,770326095309,0000013900,0|1,0,770326095321,000009900,0";
    // String msg2 =
    // "0|0000000123|1,0,750617692201,0000007950,0|1,0,770152042342,0000009950,0|2,0,770328449541,0000040000,0|3,0,770158496092,0000020000,0";
    // String msg2 =
    // "0|0000000123|1,565,770326095309,0000011900,0|1,565,770326095313,0000011900,1|1,565,770326095306,0000011900,0";
    // String msg2 =
    // "0|0000000123|10,565,770326095306,0000011900,0|";//0,0,9910000000041,20000,v";
    // String msg2 = "0|0000000123|10,565,770326087150,0000111900,0";
    // String msg2 =
    // "0|0000000123|2,565,770170103518,000038100,0|1,565,770328796526,000011900,0|1,565,9910000000027,0002000000,v";
    String msg2 = "0|0000000123|10,145,770147901337,0000014900,0";
    // String msg2 = "0|0000000123|1,565,770326095306,0000011900,0";
    // String msg2 = "0|10|4,,9,10000,0";
    // String msg2 =
    // "0|10|1,,9,10000,0|2,,9,10000,0|3,,9,10000,0|4,,9,10000,0";
    // String msg2 = "0|10|1,,1,10000,0|1,,2,10000,0|1,,3,10000,0";
    // String msg2 = "0|10|1,,770326095309,10000,0";

    // String msg3 = "2|10|1100,400000";
    // String msg3 = "2|11,000000065339|11,000000065339";
    // String msg3 = "2|11,67600|";
    // String msg3 = "2|11,60000";
    // String msg3 = "2|54,30000";//52,20000
    // String msg3 = "2|11,53550000";
    // String msg3 = "2|11,12000";
    String msg3 = "2|11,149000";
    // String msg6 = "2|11,12000|";

    // String msg5 = "2|11,12000|";

    String msg4 = "3";

    try
    {
      // for(;;)
      // {
      System.out.println("r Cliente: " + execute(msg1));
      System.out.println("r Item: " + execute(msg2));
      // System.out.println("r Item: " + execute(msg5));
      System.out.println("r Pay: " + execute(msg3));
      // System.out.println("r Pay: " + execute(msg6));
      System.out.println("r EOT: " + execute(msg4));
      // Pruebas que no tienen que ver directamente con FAL
      // Double dp = new Double(34.1);
      // System.out.println(dp.intValue());
      // String msgFinal = "Hola,Chao,H,LoquesedeLaGana";
      // System.out.println(msgFinal.replace(',',' ' ));

    }
    catch (RemoteException e)
    {

      // System.out.println("error:" + e.getMessage());
      // e.printStackTrace();
    }
    catch (Exception e)
    {
      // System.out.println("error: "+e.getMessage());
      // e.printStackTrace();
    }

  }

  public static boolean isTerminal()
  {
    return flags.get(1);
  }

  public static String getHost()
  {
    return host;
  }

  public static void setHost(String host)
  {
    Core.host = host;
  }

  public static void setTomcatServer(String ts)
  {
    Core.tomcatServer = ts;
  }

  public static String getTomcatServer()
  {
    return tomcatServer;
  }

  public String getVersion()
  {
    // TODO Auto-generated method stub
    return VERSION;
  }

  /**
   * @author edgar.cuesta Primera consulta al ws, para que los tiempos de
   *         espera, sean "menores"
   * 
   */
  public static void prueba()
  {
    if (log.isInfoEnabled())
      log.info(MODULE_NAME + "Iniciando prueba...");
    // Log.logInfo(MODULE_NAME + "Iniciando prueba...");
    String store = "0001";
    if (isOS4690) {
	    try
	    {
	      store = TerminalApplicationServices.getTerminalStatus().getStoreNumber();
	    }
	    catch (FlexosException e1)
	    {
	      errorLog.error(MODULE_NAME + "Error: " + e1.getClass().getName() + ":" + e1.getMessage(), e1);
	      // Log.logError(MODULE_NAME + "Error: " + e1.getClass().getName() + ":" +
	      // e1.getMessage());
	      // TODO Auto-generated catch block
	    }
    }
    // String msg1 = "1|0000000123|COP|9999999999999999999|" + store
    // +"|001|20120808|17|092729";
    String msg1 = "1| | |9999999999999999999|" + store + "|001|20130207| |092729";
    // String msg1 = "1|0112847014|COP|9|0072|002|20130226|21|194656";
    // String msg2 = "0|0112847014|1,566,770147922482,0000017900,0";
    // String msg3 = "0|0112847014|1,566,770147922482,0000017900,0";
    // String msg4 = "2|12,17900";
    // String msg5 = "3";
    try
    {
      String rta = Core.execute(msg1);
      if (log.isDebugEnabled())
        log.debug(MODULE_NAME + "consulta prueba: " + Core.execute(msg1));
      // Log.logDebug(MODULE_NAME + "consulta prueba: " + Core.execute(msg1));
      // Log.logDebug(MODULE_NAME + "consulta prueba: " + Core.execute(msg2));
      // Log.logDebug(MODULE_NAME + "consulta prueba: " + Core.execute(msg3));
      // Log.logDebug(MODULE_NAME + "consulta prueba: " + Core.execute(msg4));
      // Log.logDebug(MODULE_NAME + "consulta prueba: " + Core.execute(msg5));

    }
    catch (RemoteException e)
    {
      // TODO Auto-generated catch block
      errorLog.error(MODULE_NAME + "Error en consulta de prueba", e);
      // Log.logError(MODULE_NAME + "Error en consulta de prueba");
      // StackTraceElement pilaError[] = e.getStackTrace();
      // Log.logError(MODULE_NAME + "Exception: " + e.getClass().getName() + ":"
      // + e.getMessage());
      // for (int i = 0; i < pilaError.length; i++)
      // {
      // Log.logError("\t" + MODULE_NAME + "Exception en: " +
      // pilaError[0].getClassName() + " en el M�todo: "
      // + pilaError[0].getMethodName() + " linea " +
      // pilaError[0].getLineNumber());
      //
      // }

    }
    /*
     * Se eliminan las referencias a los baskets de prueba
     */
    finally
    {
      Instancia.b = null;
      Instancia.bpay = null;
      if (log.isInfoEnabled())
        log.info(MODULE_NAME + "Fin de prueba...");
      // Log.logInfo(MODULE_NAME + "Fin de prueba...");
    }

  }

  public static boolean tieneDecimales()
  {
    return flags.get(0);
  }

  /**
     * 
     */
  public static String extraerPropiedad(String id, String clave)
  {
    return loader.extraerPropiedad(id, clave);

  }

  public static void cargarPropiedades()
  {
    flags.clear();
    if (loader == null)
    {
      loader = new CargadorPropiedades();

    }
    if (log.isDebugEnabled())
      log.debug(ACTOR_NAME + "Se llama a la carga de propiedades");
    // Log.logDebug(ACTOR_NAME + "Se llama a la carga de propiedades");
    loader.cargarPropiedades();
    host = loader.extraerPropiedad("1", ContenedorConexion.IP_HOST);
    tomcatServer = loader.extraerPropiedad("1", ContenedorConexion.TOMCAT_SERVER);
    if (isOS4690) {
	    try
	    {
	      if (log.isInfoEnabled())
	      {
	        log.info(MODULE_NAME + "IP controlador: " + host);
	        log.info(MODULE_NAME + "Tomcat Server: " + tomcatServer);
	        log.info(MODULE_NAME + TerminalApplicationServices.getTerminalStatus().getNumberOfDigitsAfterDecimal() + ", "
	          + TerminalStatusData.TWO_SIGNIFICANT_DIGITS);
	      }
	      // Log.logInfo(MODULE_NAME + "IP controlador: " + host);
	      // Log.logInfo(MODULE_NAME + "Tomcat Server: " + tomcatServer);
	      // Log.logInfo(MODULE_NAME +
	      // TerminalApplicationServices.getTerminalStatus().getNumberOfDigitsAfterDecimal()
	      // + ", " + TerminalStatusData.TWO_SIGNIFICANT_DIGITS);
	      // Si tiene decimales la posición 0
	      // if(TerminalApplicationServices.getTerminalStatus().getNumberOfDigitsAfterDecimal()
	      // == TerminalStatusData.TWO_SIGNIFICANT_DIGITS)
	      if (TerminalApplicationServices.getTerminalStatus().getNumberOfDigitsAfterDecimal() == TerminalStatusData.TWO_SIGNIFICANT_DIGITS)
	      {
	        if (log.isInfoEnabled())
	          log.info(ACTOR_NAME + "La terminal tiene dos digitos decimales");
	        // Log.logInfo(ACTOR_NAME + "La terminal tiene dos digitos decimales");
	        flags.set(0);
	      }
	      // Si es de tipo terminal posicison uno del bitSet
	      if (TerminalApplicationServices.getTerminalStatus().getApplicationEnvironment() == TerminalStatusData.TERMINAL)
	      {
	        flags.set(1);
	        if (log.isDebugEnabled())
	          log.debug(MODULE_NAME + "Es de tipo terminal");
	        // Log.logDebug(MODULE_NAME + "Es de tipo terminal");
	      }
	    }
	    catch (FlexosException e)
	    {
	      errorLog.error(
	          MODULE_NAME + "Error al extrayendo propiedad de terminal: " + e.getClass().getName() + ":" + e.getMessage(),
	          e);
	      
	    }
    }
  }

  private void confLogger() throws FileNotFoundException, IOException
  {
    String logger = "R::PEFLOG:pctl";
    String loggerError = "R::PEFLOG:perr";
    String extension = ".log";
    String terminal = "001";
    if (isOS4690) {
	    try
	    {
	      terminal = TerminalApplicationServices.getTerminalStatus().getTerminalNumber();
	    }
	    catch (FlexosException e1)
	    {
	      e1.printStackTrace();
	    }
    } else {
        logger = "S:/tmp/pctl";
        loggerError = "S:/tmp/perr";
    }
    System.setProperty("pef.log", logger + terminal + extension);
    System.setProperty("pefErr.log", loggerError + terminal + extension);
    System.setProperty("pef.terminal", terminal);
    Properties properties = new Properties();
    properties.load(this.getClass().getResourceAsStream(
      "/com/linea/posappEnginePromotions/cargaPropiedades/propiedades/log4j.pro"));
    PropertyConfigurator.configure(properties);
  }
}