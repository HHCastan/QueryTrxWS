package com.linea.posappEnginePromotions.cargaPropiedades;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.linea.posappEnginePromotions.Voucher.Voucher;
import com.linea.posappEnginePromotions.contenedores.ContenedorAbstract;

/**
 * @author edgar.cuesta Clase que es un creador de instancias de almacenes, y
 *         que es a quien se solicitan las propiedades
 */
public class CargadorPropiedades
{
  private static final String NOMBRE_CLASE = "[CargadorPropiedades]";
  private Properties almacenes;
  private static Logger log = Logger.getLogger(CargadorPropiedades.class);
  private static Logger errorLog = Logger.getLogger("error." + CargadorPropiedades.class.getName());
  /** HHC 20180809: Esta variable se setea en falso o verdadero dependiendo del ambiente para el cual se compile */
  private static final boolean isOS4690 = false;

  /**
   * Constructor
   */
  public CargadorPropiedades()
  {
    almacenes = new Properties();
    Properties pro = new Properties();
    int i = 0;
    try
    {
      // HashSet hs = new HashSet();
      pro.load(Voucher.class
        .getResourceAsStream("/com/linea/posappEnginePromotions/cargaPropiedades/propiedades/cargaContenedores.pro"));
      // Se verifican los id, uno a uno, hasta que halla alguno que no exista
      // existe = pro.containsKey("" + indAux);
      Enumeration keys = pro.propertyNames();
      while (keys.hasMoreElements())
      {
        String keyAux = (String) keys.nextElement();
        if (log.isDebugEnabled())
          log.debug(NOMBRE_CLASE + "Id en el map " + keyAux);
        // Log.logDebug(NOMBRE_CLASE + "Id en el map " + keyAux );
        Class aInstanciar = Class.forName(pro.getProperty(keyAux));
        if (log.isInfoEnabled())
          log.info(NOMBRE_CLASE + "Se procede a instanciar la clase" + aInstanciar.getName());
        // Log.logDebug(NOMBRE_CLASE + "Se procede a instanciar la clase" +
        // aInstanciar.getName());
        aInstanciar.getDeclaredConstructor(null);
        Object objetoCreado = aInstanciar.newInstance();
        if (log.isInfoEnabled())
          log.info(NOMBRE_CLASE + "Objeto creado, se ingresa al map");
        // Log.logDebug(NOMBRE_CLASE + "Objeto creado, se ingresa al map");
        almacenes.put(keyAux, objetoCreado);
        i++;
      }
      if (log.isInfoEnabled())
        log.info(NOMBRE_CLASE + "Se han creado todos los almacenes");
      // Log.logDebug(NOMBRE_CLASE + "Se han creado todos los almacenes");
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
    catch (ClassNotFoundException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
    catch (NoSuchMethodException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
    catch (SecurityException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
    catch (InstantiationException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
    catch (IllegalAccessException e)
    {
      // TODO Auto-generated catch block
      errorLog.error("Error: " + e.getClass().getName() + ":" + e.getMessage(), e);

    }
  }

  /**
   * @param i
   *          Posición en la lista del almacen del que extraeré la propiedad
   * @param clave
   *          La clave (llave) gracias a la cual acceder al valor de la
   *          propiedad. Cada almacens debe tener un documento con las claves
   * @return El valor de la propiedad solicitada o un mensaje 300 en caso de no
   *         encontrarse la propiedad
   */
  public String extraerPropiedad(String id, String clave)
  {
    ContenedorAbstract contenedor = (ContenedorAbstract) almacenes.get(id);
    if (log.isInfoEnabled())
      log.info(NOMBRE_CLASE + "Contenedor de tipo: " + contenedor.getClass().getName());
    // Log.logDebug(NOMBRE_CLASE + "Contenedor de tipo: " +
    // contenedor.getClass().getName());
    return contenedor.extraerPropiedad(clave);
  }

  /**
   * @param parametros
   *          La trama con los valores separados por |, debe ir de la forma
   *          "2|IP", donde el valor númerico representa la posición en la
   *          lista, y el otro valor la clave, sólo debe haber un par id - clave
   * @return El valor de la propiedad solicitada o un mensaje 300 en caso de no
   *         encontrarse la propiedad
   */
  public String execute(String parametros)
  {
    StringTokenizer param = new StringTokenizer(parametros, "|");
    int i = 0;
    String id = "0";
    String clave = "";
    while (param.hasMoreTokens())
    {
      if (i == 0)
        id = param.nextToken();
      else
        clave = param.nextToken();
    }
    return extraerPropiedad(id, clave);

  }

  /**
   * Donde se indica a cada almacen que llene su HashMap
   */
  public void cargarPropiedades()
  {
    Set keys = almacenes.keySet();
    Iterator it = keys.iterator();
    while (it.hasNext())
    {
      String next = (String) it.next();
      if (log.isInfoEnabled())
        log.info(NOMBRE_CLASE + "Almacen con id " + next);
      // Log.logDebug(NOMBRE_CLASE + "Almacen con id " + next);
      ContenedorAbstract contenedor = (ContenedorAbstract) almacenes.get(next);
      if (isOS4690)
    	  contenedor.cargaPropiedades();
      else
    	  contenedor.cargaPropiedadesWIN();
    }
    if (log.isInfoEnabled())
      log.info(NOMBRE_CLASE + "Finalizo carga de propiedades");
    // Log.logDebug(NOMBRE_CLASE + "Finalizo carga de propiedades");
  }

  /**
   * Metodo que devuelve todos los posibles almacenes creados hasta el momento.
   */
  public Set getCargadores()
  {
    return almacenes.keySet();
  }

  /**
   * Devolver el Contenedor de manera completa, sólo usar si se desea manejar
   * administradores para los almacenes. TODO Crear una forma de administrar el
   * orden de los id's
   */
  public ContenedorAbstract getContenedorEspecifico(String clave)
  {
    return (ContenedorAbstract) almacenes.get(clave);
  }
}
