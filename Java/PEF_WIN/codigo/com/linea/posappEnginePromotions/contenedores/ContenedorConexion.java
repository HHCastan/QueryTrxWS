package com.linea.posappEnginePromotions.contenedores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ibm.OS4690.FlexosException;
import com.ibm.OS4690.TerminalApplicationServices;
import com.lineai.posappframework.xmlwrappers.actors.userdefined.WS_FALSolution.FALWrapper;

public class ContenedorConexion implements ContenedorAbstract
{

  private static Logger log = Logger.getLogger(ContenedorConexion.class);
  private static Logger errorLog = Logger.getLogger(ContenedorConexion.class.getName());
  private HashMap datosConexion;
  private static final String MODULE_NAME = "[ContenedorConexion]";
  // ¿Se trabaja con Mensajes por Reward o no?
  public static final String REWARD_MESSAGES = "rwrMsg";
  // ip del controlador
  public static final String IP_HOST = "iphost";
  // Ip del central (marcado con atributo
  public static final String IP_CENTRAL = "ipCentral";
  public static final String CENTRAL_PORT = "centralPort";
  public static final String CENTRAL_PATH = "centralPath";
  // A donde debe apuntar Terminal Stand Alone para consultar al WS
  public static final String TOMCAT_SERVER = "TomcatServer";
  // IP loopback, que usa T/C para verse a si misma
  public static final String PE_PRIMARY = "primary";
  public static final String PRIMARY_PATH = "primaryPath";
  public static final String PRIMARY_PORT = "primaryPort";
  public static final String RETRASO_OPT = "retrasoSecond";

  // IP que apunta al servidor central (en teoría)
  public static final String PE_SECONDARY = "secondary";
  public static final String SECONDARY_PATH = "secondaryPath";
  public static final String SECONDARY_PORT = "secondaryPort";
  // Por si se tiene más de un serividor de respaldo
  public static final String MAX_IP_ADICIONALES = "max";
  public static final String RETRASO = "retraso";

  private static final String HOST_FILE = "R::HOSTS";
  // Para debug
  private static final String NOMBRE_CLASE = "[ContenedorConexion]";
  
  // Propiedades para Windows:
  private static Properties properties = null; 

  public ContenedorConexion()
  {
    datosConexion = new HashMap();
  }

  public void cargaPropiedadesWIN() {
	properties = new Properties();
		
	try {
		properties.load(ContenedorConexion.class.getResourceAsStream("/com/linea/posappEnginePromotions/cargaPropiedades/propiedades/pefWIN.pro"));
	}
	catch (IOException e) {
        errorLog.error("[ContenedorConexion] Error: " + e.getClass().getName() + ":" + e.getMessage(), e);
	}

	String ipHost = properties.getProperty("PEPRIMARY");
    String primary = properties.getProperty("PEPRIMARY");
    String secondary = properties.getProperty("PESECUNDARY");
    String tomcatServer = com.fla.cotizador.vista.Ventana.sTomcatServer;
    
    FALWrapper xmlWrapper = new FALWrapper();
    String[][] conexion = xmlWrapper.getConexion();
    String retraso = conexion[0][3];
    datosConexion.put(REWARD_MESSAGES, String.valueOf(xmlWrapper.isRewardTrx()));
    datosConexion.put(RETRASO, retraso);
    int numerosNormales = 0;
    if (xmlWrapper.isPePrimary())
    {
      log.debug("[ContenedorConexion]Adiciona la direccion del principal");
      // Log.logDebug("[ContenedorConexion]Adiciona la direccion del principal");
      datosConexion.put(PE_PRIMARY, primary);
      numerosNormales++;
    }
    if (xmlWrapper.isPeSecondary())
    {
      log.debug("[ContenedorConexion]Adiciona la direccion de respaldo");
      // Log.logDebug("[ContenedorConexion]Adiciona la direccion de respaldo");
      datosConexion.put(PE_SECONDARY, secondary);
      numerosNormales++;
    }
    int max = conexion.length - numerosNormales;
    if (log.isInfoEnabled())
      log.info(NOMBRE_CLASE + "IP's Adicionales " + max);
    // Log.logInfo(NOMBRE_CLASE + "IP's Adicionales " + max);
    datosConexion.put(MAX_IP_ADICIONALES, "" + max);
    for (int i = 0; i < conexion.length; i++)
    {
      if (conexion[i][0].equals("PESecundary"))
      {
        String pathSecondary = conexion[i][2];
        String portSecondary = conexion[i][1];
        String retrasoOpt = conexion[i][3];
        if (retrasoOpt != null && !retrasoOpt.equals(""))
        {
          datosConexion.put(RETRASO_OPT, retrasoOpt);
          if (log.isDebugEnabled())
            log.debug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
          // Log.logDebug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
        }
        datosConexion.put(SECONDARY_PATH, pathSecondary);
        datosConexion.put(SECONDARY_PORT, portSecondary);
        if (log.isInfoEnabled())
        {
          log.info(NOMBRE_CLASE + "Puerto secondary " + portSecondary);
          log.info(NOMBRE_CLASE + "Ruta secondary " + pathSecondary);
        }

        // Log.logInfo(NOMBRE_CLASE + "Puerto secondary " + portSecondary);
        // Log.logInfo(NOMBRE_CLASE + "Ruta secondary " + pathSecondary);
      }
      else if (conexion[i][0].equals("PEPrimary"))
      {
        String pathPrimary = conexion[i][2];
        String portPrimary = conexion[i][1];
        datosConexion.put(PRIMARY_PATH, pathPrimary);
        datosConexion.put(PRIMARY_PORT, portPrimary);
        if (log.isInfoEnabled())
        {
          log.info(NOMBRE_CLASE + "Puerto secondary " + portPrimary);
          log.info(NOMBRE_CLASE + "Ruta secondary " + pathPrimary);
        }
        // Log.logInfo(NOMBRE_CLASE + "Puerto primary " + portPrimary);
        // Log.logInfo(NOMBRE_CLASE + "Ruta primary " + pathPrimary);//
      }
      else
      {
        String ipAux = conexion[i][0];
        String pathAux = conexion[i][2];
        String portAux = conexion[i][1];
        String retrasoOpt = conexion[i][3];
        if (retrasoOpt != null && !retrasoOpt.equals(""))
        {
          datosConexion.put(RETRASO_OPT, retrasoOpt);
          if(log.isDebugEnabled())
          {
            log.debug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
          }
//          Log.logDebug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
        }
        int newIndex = 0;
        datosConexion.put("IP" + newIndex, ipAux);
        datosConexion.put("PATH" + newIndex, pathAux);
        datosConexion.put("PORT" + newIndex, portAux);
        if(log.isInfoEnabled())
        {
          log.info(NOMBRE_CLASE + "IP # " + newIndex + ":" + ipAux);
          log.info(NOMBRE_CLASE + "Port # " + newIndex + ":" + portAux);
          log.info(NOMBRE_CLASE + "Path # " + newIndex + ":" + pathAux);
        }
//        Log.logDebug(NOMBRE_CLASE + "IP # " + newIndex + ":" + ipAux);
//        Log.logDebug(NOMBRE_CLASE + "Port # " + newIndex + ":" + portAux);
//        Log.logDebug(NOMBRE_CLASE + "Path # " + newIndex + ":" + pathAux);
        newIndex++;
      }
    }
    // Ingresan propiedades al HashMap
    datosConexion.put(IP_HOST, ipHost);
    datosConexion.put(TOMCAT_SERVER, tomcatServer);
    String centralCon[] = xmlWrapper.getCentral();
    if (centralCon[0].equals("PEPrimary"))
    {
      datosConexion.put(IP_CENTRAL, ipHost);
      if(log.isDebugEnabled())
        log.debug("[ContenedorConexion]IP Central: " + ipHost);
//      Log.logDebug("[ContenedorConexion]IP Central: " + ipHost);
    }
    else if (centralCon[0].equals("PESecundary"))
    {
      datosConexion.put(IP_CENTRAL, secondary);
      if(log.isInfoEnabled())
        log.info("[ContenedorConexion]IP Central: " + secondary);
//      Log.logDebug("[ContenedorConexion]IP Central: " + secondary);
    }
    else
    {
      datosConexion.put(IP_CENTRAL, centralCon[0]);
      if(log.isInfoEnabled())
        log.info("[ContenedorConexion]IP Central: " + centralCon[0]);
//      Log.logDebug("[ContenedorConexion]IP Central: " + centralCon[0]);
    }
    datosConexion.put(CENTRAL_PORT, centralCon[1]);
    datosConexion.put(CENTRAL_PATH, centralCon[2]);
    if(log.isInfoEnabled())
    {
      log.info("[ContenedorConexion]port Central: " + centralCon[1]);
//    Log.logInfo("[ContenedorConexion]port Central: " + centralCon[1]);
      log.info("[ContenedorConexion]path Central: " + centralCon[2]);
    }    
  }

  public void cargaPropiedades()
  {
    String stControlerID = "";
    try
    {
      stControlerID = TerminalApplicationServices.getTerminalStatus().getStoreControllerId();
      // Se extraen propiedades de archivo de host
      String ipHost = getControllerIPAddress(stControlerID);
      String primary = getControllerIPAddress("PEPRIMARY");
      String secondary = getControllerIPAddress("PESECUNDARY");
      String tomcatServer = getControllerIPAddress("TOMCATSERVER");
      if (log.isInfoEnabled())
      {
        log.info(NOMBRE_CLASE + "IP del controlador " + ipHost);
        log.info(NOMBRE_CLASE + "IP Primary " + primary);
        log.info(NOMBRE_CLASE + "IP Secondary " + secondary);
        log.info(NOMBRE_CLASE + "IP Ubicacion Tomcat al que debe " + "ir el Terminal " + tomcatServer);
      }
      // Log.logInfo(NOMBRE_CLASE + "IP del controlador " + ipHost);
      // Log.logInfo();
      // Log.logInfo(NOMBRE_CLASE + "IP Secondary " + secondary);
      // Log.logInfo(NOMBRE_CLASE + "IP Ubicacion Tomcat al que debe " +
      // "ir el Terminal " + tomcatServer);
      // FALWrapper
      FALWrapper xmlWrapper = new FALWrapper();
      String[][] conexion = xmlWrapper.getConexion();
      String retraso = conexion[0][3];
      datosConexion.put(REWARD_MESSAGES, String.valueOf(xmlWrapper.isRewardTrx()));
      datosConexion.put(RETRASO, retraso);
      int numerosNormales = 0;
      if (xmlWrapper.isPePrimary())
      {
        log.debug("[ContenedorConexion]Adiciona la direccion del principal");
        // Log.logDebug("[ContenedorConexion]Adiciona la direccion del principal");
        datosConexion.put(PE_PRIMARY, primary);
        numerosNormales++;
      }
      if (xmlWrapper.isPeSecondary())
      {
        log.debug("[ContenedorConexion]Adiciona la direccion de respaldo");
        // Log.logDebug("[ContenedorConexion]Adiciona la direccion de respaldo");
        datosConexion.put(PE_SECONDARY, secondary);
        numerosNormales++;
      }
      int max = conexion.length - numerosNormales;
      if (log.isInfoEnabled())
        log.info(NOMBRE_CLASE + "IP's Adicionales " + max);
      // Log.logInfo(NOMBRE_CLASE + "IP's Adicionales " + max);
      datosConexion.put(MAX_IP_ADICIONALES, "" + max);
      for (int i = 0; i < conexion.length; i++)
      {
        if (conexion[i][0].equals("PESecundary"))
        {
          String pathSecondary = conexion[i][2];
          String portSecondary = conexion[i][1];
          String retrasoOpt = conexion[i][3];
          if (retrasoOpt != null && !retrasoOpt.equals(""))
          {
            datosConexion.put(RETRASO_OPT, retrasoOpt);
            if (log.isDebugEnabled())
              log.debug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
            // Log.logDebug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
          }
          datosConexion.put(SECONDARY_PATH, pathSecondary);
          datosConexion.put(SECONDARY_PORT, portSecondary);
          if (log.isInfoEnabled())
          {
            log.info(NOMBRE_CLASE + "Puerto secondary " + portSecondary);
            log.info(NOMBRE_CLASE + "Ruta secondary " + pathSecondary);
          }

          // Log.logInfo(NOMBRE_CLASE + "Puerto secondary " + portSecondary);
          // Log.logInfo(NOMBRE_CLASE + "Ruta secondary " + pathSecondary);
        }
        else if (conexion[i][0].equals("PEPrimary"))
        {
          String pathPrimary = conexion[i][2];
          String portPrimary = conexion[i][1];
          datosConexion.put(PRIMARY_PATH, pathPrimary);
          datosConexion.put(PRIMARY_PORT, portPrimary);
          if (log.isInfoEnabled())
          {
            log.info(NOMBRE_CLASE + "Puerto secondary " + portPrimary);
            log.info(NOMBRE_CLASE + "Ruta secondary " + pathPrimary);
          }
          // Log.logInfo(NOMBRE_CLASE + "Puerto primary " + portPrimary);
          // Log.logInfo(NOMBRE_CLASE + "Ruta primary " + pathPrimary);//
        }
        else
        {
          String ipAux = conexion[i][0];
          String pathAux = conexion[i][2];
          String portAux = conexion[i][1];
          String retrasoOpt = conexion[i][3];
          if (retrasoOpt != null && !retrasoOpt.equals(""))
          {
            datosConexion.put(RETRASO_OPT, retrasoOpt);
            if(log.isDebugEnabled())
            {
              log.debug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
            }
//            Log.logDebug(NOMBRE_CLASE + "Retraso Adicional " + retrasoOpt);
          }
          int newIndex = 0;
          datosConexion.put("IP" + newIndex, ipAux);
          datosConexion.put("PATH" + newIndex, pathAux);
          datosConexion.put("PORT" + newIndex, portAux);
          if(log.isInfoEnabled())
          {
            log.info(NOMBRE_CLASE + "IP # " + newIndex + ":" + ipAux);
            log.info(NOMBRE_CLASE + "Port # " + newIndex + ":" + portAux);
            log.info(NOMBRE_CLASE + "Path # " + newIndex + ":" + pathAux);
          }
//          Log.logDebug(NOMBRE_CLASE + "IP # " + newIndex + ":" + ipAux);
//          Log.logDebug(NOMBRE_CLASE + "Port # " + newIndex + ":" + portAux);
//          Log.logDebug(NOMBRE_CLASE + "Path # " + newIndex + ":" + pathAux);
          newIndex++;
        }
      }
      // Ingresan propiedades al HashMap
      datosConexion.put(IP_HOST, ipHost);
      datosConexion.put(TOMCAT_SERVER, tomcatServer);
      String centralCon[] = xmlWrapper.getCentral();
      if (centralCon[0].equals("PEPrimary"))
      {
        datosConexion.put(IP_CENTRAL, ipHost);
        if(log.isDebugEnabled())
          log.debug("[ContenedorConexion]IP Central: " + ipHost);
//        Log.logDebug("[ContenedorConexion]IP Central: " + ipHost);
      }
      else if (centralCon[0].equals("PESecundary"))
      {
        datosConexion.put(IP_CENTRAL, secondary);
        if(log.isInfoEnabled())
          log.info("[ContenedorConexion]IP Central: " + secondary);
//        Log.logDebug("[ContenedorConexion]IP Central: " + secondary);
      }
      else
      {
        datosConexion.put(IP_CENTRAL, centralCon[0]);
        if(log.isInfoEnabled())
          log.info("[ContenedorConexion]IP Central: " + centralCon[0]);
//        Log.logDebug("[ContenedorConexion]IP Central: " + centralCon[0]);
      }
      datosConexion.put(CENTRAL_PORT, centralCon[1]);
      datosConexion.put(CENTRAL_PATH, centralCon[2]);
      if(log.isInfoEnabled())
      {
        log.info("[ContenedorConexion]port Central: " + centralCon[1]);
//      Log.logInfo("[ContenedorConexion]port Central: " + centralCon[1]);
        log.info("[ContenedorConexion]path Central: " + centralCon[2]);
      }
      
//      Log.logInfo("[ContenedorConexion]path Central: " + centralCon[2]);
    }
    catch (FlexosException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("[ContenedorConexion] Error: " + e.getClass().getName() + ":" + e.getMessage(), e);
      
    }

  }

  /**
   * Rutina que evalua un string y retorna la primera posicion de un espacio o
   * un tabulador, debe ir en LIBASEII-Util
   * 
   * @param string
   *          string evaluar
   * @return posicion del primer espacio o tabulador
   * @author hcastaneda
   */
  private static int indexOfTabOrSpace(String string)
  {
    int spaceIndex = string.indexOf(' ');
    int tabIndex = string.indexOf('\u0009');

    if ((spaceIndex == -1) && (tabIndex == -1))
    {
      return -1;
    }

    if ((spaceIndex == -1) && (tabIndex != -1))
    {
      return tabIndex;
    }

    if ((spaceIndex != -1) && (tabIndex == -1))
    {
      return spaceIndex;
    }

    if (spaceIndex < tabIndex)
    {
      return spaceIndex;
    }
    else
    {
      return tabIndex;
    }
  }

  /**
   * Rutina para obtener la direccion IP del controlador especificado en el
   * argumento recibe como parametro el ID del controlador, debe ir en
   * LIBASEII-Util
   * 
   * @param hostName
   *          nombre del contrador
   * @return Direccion IP del controlador solicitado
   * @author hcastaneda
   */
  public static String getControllerIPAddress(String hostName)
  {
    if(log.isInfoEnabled())
      log.info(MODULE_NAME + "Archivo host a buscar: " + hostName);
//    Log.logDebug(MODULE_NAME + "Archivo host a buscar: " + hostName);
    String stIPAddress = "";
    String stNodeName = "";
    String hostFileName = "R::ADX_SDT1/ADXHSIHF.DAT";
    File hostFile = new File(hostFileName);
    try
    {
      FileInputStream fis = new FileInputStream(hostFile);
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);
      String aLine = null;
      while ((aLine = br.readLine()) != null)
      {
        //Eliminar comentarios
        if(aLine.indexOf("#") != -1)
        {
          if(aLine.indexOf('#') == 0)
            continue;
          else
          {
            String[] comentadas = aLine.split("#");
            aLine = comentadas[0];
          }
        }
        // Obtiene la IP
        int spaceIndex = indexOfTabOrSpace(aLine);
        if (spaceIndex == -1)
        {
          // linea invalida, no se procesa
          continue;
        }
        stIPAddress = aLine.substring(0, spaceIndex);
        // Obtiene el hostname
        String stFiller = aLine.substring(spaceIndex + 1).trim();
        spaceIndex = indexOfTabOrSpace(stFiller);
        if (spaceIndex == -1)
        {
          stNodeName = stFiller;
        }
        else
        {
          stNodeName = stFiller.substring(0, spaceIndex);
        }
        if(log.isDebugEnabled())
          log.debug(MODULE_NAME + "stNodeName");
//        Log.logDebug(MODULE_NAME + "stNodeName");
        if (hostName.toUpperCase().compareTo(stNodeName.toUpperCase()) == 0)
        {
          return stIPAddress;
        }
      }
    }
    catch (Exception e)
    {
      errorLog.error(MODULE_NAME + "Error Procesando archivo ADXHSIHF.DAT" + e.getMessage(),e);
//      Log.logError(MODULE_NAME + "Error Procesando archivo ADXHSIHF.DAT" + e.getMessage());
    }
    return null;
  }

  public String extraerPropiedad(String clave)
  {
    // Log.logDebug("[ContenedorConexion]" + this.toString());
    return (String) datosConexion.get(clave);
  }

  public String toString()
  {
    if (datosConexion != null)
    {
      return datosConexion.toString();
    }
    else
    {
      return "null";
    }
  }
}