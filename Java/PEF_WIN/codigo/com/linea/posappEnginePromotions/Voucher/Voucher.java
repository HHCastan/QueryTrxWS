/*
 * Class: com.linea.posappEnginePromotions.voucher
 * 
 * Client: Almatex
 * 
 * Deployment: \PEF\PEF.jar
 * 
 * Module information: Escritura de Voucher
 * 
 * Brief summary: Se encarga de padear los mensajes recibido en el tag de coupons, y escribirlos a uun archivo
 * en un formato espec�fico (38 car�cteres por l�nea, primeras l�enas fechas, luego mensajes, y por �ltimo el 
 * c�digo del voucher) 
 *
 * Copyright
 * 
 */
package com.linea.posappEnginePromotions.Voucher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.linea.posappEnginePromotions.contenedores.ContenedorPropUFPAR;
//<<<<<<< Voucher.java
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.Core;

/**
 * 
 * @author edgar.cuesta
 * @version 1.2.0.0
 * 
 */
public class Voucher
{
  /*
   * variable que define la longitud de la tirilla donde se imprime la
   * información de los vouchers
   */
  private static Logger log = Logger.getLogger(Voucher.class);
  private static Logger errorLog = Logger.getLogger("error." + Voucher.class.getName());
  private static int wide;
  // Ruta a la que se escribira
  private static String path;
  // Archivo al que se va a escribir, y el de respaldo
  private static File file;
  private static File back;
  // Writers, para escribir "eficientemente" a disco
  private static FileWriter flwr;
  private static FileWriter flwrBck;
  private static BufferedWriter bfwr;
  private static BufferedWriter bfwrBck;
  // Capricho, para poder "padear" bien el String
  private static int indVoucher;
  private static boolean respaldo = false;
//<<<<<<< Voucher.java
  private static String response = "";
  private static String barCode = "@bar";
  private static String cutPaper = "@cut";
  private static String toWrite = "";

  // TODO Hacer el parámetro que apunta al archivo del ufpar modificable
  // SuperMaxi
   private static String paramFile = "R::UFPAR:189";
  // Almatex
//  private static final String paramFile = "R::UFPAR:001";
   private static String respTemp = "";

  private static final String CLASSNAME = "[Voucher]";

  /**
   * Constructor por defecto
   * 
   * @author edgar.cuesta
   * 
   */
  public Voucher() 
  {
    
  }

  /**
   * Genera las rutas a los archivos y los deja listos para escritura
   * 
   * @author edgar.cuesta
   * 
   */
  public static void init()
  {
    wide = 38;
    /*
     * edgar.cuesta 
     * Se mantiene, para poder leer si se desea escribir o no el voucher de
     * de respaldo
     */
    Properties ufpar = new Properties();
    try
    { 
      int respaldoTmp;
      ufpar.load(Voucher.class.getResourceAsStream("/com/linea/posappEnginePromotions/Voucher/Properties/prop.pro"));
      respaldoTmp = Integer.parseInt((String)ufpar.get("respaldo"));
      if(respaldoTmp != 0)
        respaldo = true;
    }
    catch (IOException e1)
    {
      errorLog.error("Exception " + e1.getClass().getName() + ":" + e1.getMessage(), e1);
      
    }
    /*
     * edgar.cuesta
     * 23-07-2013
     * Para probar, si el cargador de propiedades es capaz de extraer los valores
     * me doy por bien servido
     */
     path = Core.extraerPropiedad("2", ContenedorPropUFPAR.VOUCHER_FILE);
     barCode = Core.extraerPropiedad("2", ContenedorPropUFPAR.BAR_CODE);
     cutPaper = Core.extraerPropiedad("2", ContenedorPropUFPAR.CUT_PAPER);
  }

  /**
   * Devuelve el valor del ancho de la tirilla a imprimir, se recomienda usar
   * solo con fines de verificación
   * 
   * @author edgar.cuesta
   * @return wide ancho, en número de caracteres deseado se impriman en el
   *         voucher
   */
  public static int getWide()
  {
    return Voucher.wide;
  }

  /**
   * Se extrae el path a donde se escriben el archivo de Voucher, y el de respaldo
   * @return Path a donde se imprimiran el archivo de Voucher, y el de respaldo
   */
  public static String getPath()
  {
    return Voucher.path;
  }

  /**
   * Se modifica el ancho de línea del voucher
   * @param width Ancho de cada línea del voucher
   */
  public static void setWide(int width)
  {
    Voucher.wide = width;
  }

  /**
   * Modifica el path
   * @param path
   *          el path de la ruta del archivo del voucher, puede ser variable
   *          lógica
   */
  public static void setPath(String path)
  {
    Voucher.path = path;
  }

//  /**
//   * author edgar.cuesta
//   * 
//   * @param voucher
//   *          - String a escribir en el archivo de texto del voucher, antes
//   *          recibía todo el voucher, ahora sólo recibe un fragmento El string
//   *          puede también ser un salto de línea, toda la lógica del código de
//   *          barras, y los saltos de líneas (y los cortes) ahora se aplica a
//   *          nivel superior
//   */
//  // public static void setVoucher(String voucher, boolean hasMore) {
//  public static void setVoucher(String voucher)
//  {
//    String aEscribir = "";
//    if (voucher.toLowerCase().equals("null"))
//      voucher = "";
//    try
//    {
//      indVoucher = 0;
//      response = new ArrayList();
//      
//      aEscribir = padearVoucher(aEscribir, voucher);
//      toWrite = toWrite.concat(aEscribir);
//      Log.logDebug(CLASSNAME + "Se va a escribir a texto " + aEscribir);
////      bfwr.write(aEscribir);
//      Log.logDebug(CLASSNAME + " Ubicacion voucher: " + Voucher.path);
//    }
//    catch (Exception e)
//    {
//      Log.logError(CLASSNAME + " Exception: " + e.getMessage());
//      e.printStackTrace();
//    }
//  }
  /**
   * Método para imprimir el voucher a disco, revisar si es conveniente seguir 
   * BufferedWriter, o mudar a FileWriter
   * 
   */
  public static void printVoucher()
  {
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Se procede a imprimir el voucher en " + Voucher.path);
      
//    Log.logInfo(CLASSNAME + "Se procede a imprimir el voucher en " + Voucher.path);
    if (bfwr == null)
    {
      log.warn(CLASSNAME + "Buffer de escritura no inicializado, favor invocar primero el método open");
//      Log.logWarning(CLASSNAME + "Buffer de escritura no inicializado, favor invocar primero el método open");
    }
    else
    {
      try
      {
        if(log.isDebugEnabled())
          log.debug(CLASSNAME + "Escribiendo Voucher");
//        Log.logDebug(CLASSNAME + "Escribiendo Voucher");
        bfwr.write(response);
        bfwr.newLine();
        if (respaldo && (bfwrBck != null))
        {
          if(log.isDebugEnabled())
            log.debug(CLASSNAME + "Se procede a escribir respaldo");
//          Log.logDebug(CLASSNAME + "Se procede a escribir respaldo");
          bfwrBck.write(response);
          bfwrBck.newLine();
        }
        response = "";
      }
      catch (IOException e)
      {
        // TODO Auto-generated catch block
        errorLog.error(CLASSNAME + "Exception de Entrada/Salida " + e.getClass().getName() + ":" + e.getMessage());
//        Log.logError(CLASSNAME + "Exception de Entrada/Salida " + e.getClass().getName() + ":" + e.getMessage());
        
      }
      catch (Exception e)
      {
        // TODO Auto-generated catch block
        errorLog.error(CLASSNAME + "Exception " + e.getClass().getName() + ":" + e.getMessage());
//        Log.logError(CLASSNAME + "Exception de Entrada/Salida " + e.getClass().getName() + ":" + e.getMessage(
        
      }
    }
  }

  // Borra el archivo del path
  /**
   * Se borra el archivo de Voucher
   * TODO una bandera, para borrar el archivo de respaldo, preferiblemente parametrizable
   */
//  public static void delete(boolean respaldo)
  public static void delete()
  {
    if(log!= null && log.isInfoEnabled())
      log.info(CLASSNAME + "Tratando de borrar el archivo de Voucher");
//    Log.logInfo(CLASSNAME + "Tratando de borrar el archivo de Voucher");
    if(Voucher.path != null)
    {
      File fl = new File(Voucher.path);
      if (fl.exists())
      {
        if (!fl.delete())
        {
          // throw new
          // Exception("No se pudo borrar el archivo "+path+" verifique que no lo est� usando");
          if(log!= null && log.isEnabledFor(Priority.WARN))
            log.warn(CLASSNAME + "No se pudo borrar el archivo " + path + " verifique que no lo este usando");
//          Log.logError(CLASSNAME + "No se pudo borrar el archivo " + path + " verifique que no lo est� usando");
        }
      }
    }
    else
    {
      if(log != null && log.isEnabledFor(Priority.WARN))
        log.warn(CLASSNAME + "Ruta no ha sido determinada");
//      Log.logWarning(CLASSNAME + "Ruta no ha sido determinada");
      
    }
    
    // Me parte el Voucher en Strings de 38 caracteres m�s o menos
  }
  /**
   * Método encargado de la apertura del archivo, y de los bufferes, para
   * iniciar la escritura
   * 
   * @throws IOException
   *           ver BufferedWriter y FileWriter (Constructores)
   * @autor edgar.cuesta
   * @date 11/12/2012
   */
  public static void openFile() throws IOException
  {
    boolean existe = false;
    boolean existeBack = false;
    file = new File(path);
    String pathBCK = "";
    if(path.indexOf('.') != -1)
    {
      pathBCK = Voucher.path.substring(0, Voucher.path.lastIndexOf("."));
    }
    else
    {
      pathBCK = path;
//      path = path.concat(".TXT");
    }
    if (respaldo)
    {
      back = new File(pathBCK + ".BAK");
//      back = new File("R::C:BAKV.TXT");
      if(log != null && log.isDebugEnabled())
        log.debug(CLASSNAME + "path del archivo de respaldo: " + back.getAbsolutePath());
//      Log.logDebug(CLASSNAME + "path del archivo de respaldo: " + back.getAbsolutePath());
    }
    if(log!=null && log.isDebugEnabled())
      log.debug(CLASSNAME + "Creando bufferes...");
//    Log.logDebug(CLASSNAME + "Creando bufferes...");
    if (!file.exists())
    {
      existe = file.createNewFile();
    }
    else
      existe = true;
    if (existe)
    {
      flwr = new FileWriter(file);
      bfwr = new BufferedWriter(flwr);
    }
    else
    {
      if(log != null && log.isEnabledFor(Priority.WARN))
        log.warn(CLASSNAME + "No pudo generarse el archivo " + path);
//      Log.logError(CLASSNAME + "No pudo generarse el archivo " + path);
    }
    if (respaldo)
    {
      if (!back.exists())
      {
        existeBack = back.createNewFile();
      }
      else
        existeBack = true;

      if (existeBack)
      {
        flwrBck = new FileWriter(back);
        bfwrBck = new BufferedWriter(flwrBck);
        if(log!= null && log.isDebugEnabled())
          log.debug(CLASSNAME + "Abierto Buffer para respaldo");
//          Log.logDebug(CLASSNAME + "Abierto Buffer para respaldo");
        
      }
      else
      {
        if(log!= null && log.isEnabledFor(Priority.WARN))
          log.warn(CLASSNAME + "No pudo generarse el archivo " + pathBCK + ".BCK");
//        Log.logWarning(CLASSNAME + "No pudo generarse el archivo " + pathBCK + ".BCK");
      }
    }
    
   
  }
  /**
   * Método que cierra los archivos, y los bufferes de escritura
   * 
   * @throws IOException Preblemas de lectura/escritura del archivo
   *           @see BufferedWriter 
   *           @see FileWriter 
   * @autor edgar.cuesta
   * @date 11/12/2012
   */
  public static void closeFile() throws IOException
  {
    if(log != null && log.isInfoEnabled())
      log.info(CLASSNAME + "Cerrando Bufferes");
//    Log.logInfo(CLASSNAME + "Cerrando Bufferes");
    if (bfwr != null)
    {
      bfwr.flush();
      bfwr.close();
      flwr.close();
    }
    if (bfwrBck != null)
    {
      bfwrBck.flush();
      bfwrBck.close();
      flwrBck.close();
    }

  }
  /**
   * @throws IOException Problemas al cerrar el archivo
   *           @see BufferedWriter
   * @autor edgar.cuesta
   * @date - 11/12/2012 Se encarga de añadir una nueva línea a los buffers, creo
   *       que el @cut, todavía puede agregarse en el setVoucher
   */
  public static void newLine() throws IOException
  {
//<<<<<<< Voucher.java
    if (bfwr != null)
      bfwr.newLine();
    if(respaldo)
    {
      if (bfwrBck != null)
        bfwrBck.newLine();
    }

  }
  public static String getBarCode()
  {
    return barCode;
  }

  public static void setBarCode(String barCode)
  {
    Voucher.barCode = barCode;
  }

  public static String getCutPaper()
  {
    return cutPaper;
  }

  public static void setCutPaper(String cutPaper)
  {
    Voucher.cutPaper = cutPaper;
  }
  public static void flush() throws IOException
  {
    
    if (bfwr != null)
    {
      bfwr.write(toWrite);
      if(respaldo)
      {
        if(bfwrBck != null)
        {
          bfwrBck.write(toWrite);
        }
      }
    }
  }
  public static void flush(String aEscribir) throws IOException
  {
    if (bfwr != null)
    {
      if(log!= null && log.isInfoEnabled())
        log.info(CLASSNAME + "Se procede a escribir Voucher");
//        Log.logInfo(CLASSNAME + "Se procede a escribir Voucher");
      bfwr.write(aEscribir);
      bfwr.flush();
      if(log != null && log.isInfoEnabled())
        log.info(CLASSNAME + "Voucher escrito");
//      Log.logInfo(CLASSNAME + "Voucher escrito");
      if(respaldo)
      {
        if(bfwrBck != null)
        {
          if(log!= null && log.isDebugEnabled())
            log.debug(CLASSNAME + "Se procede a escribir Respaldo en ");
//          Log.logDebug(CLASSNAME + "Se procede a escribir Respaldo en ");
          bfwrBck.write(aEscribir);
          bfwrBck.flush();
          if(log != null && log.isDebugEnabled())
            log.debug(CLASSNAME + "Respaldo escrito");
//          Log.logDebug(CLASSNAME + "Respaldo escrito");
        }
      }
    }
  }

}
