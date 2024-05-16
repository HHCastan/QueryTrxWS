package com.linea.posappEnginePromotions.contenedores;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.linea.posappEnginePromotions.Voucher.Voucher;
import com.linea.sig.util.PropertiesFiles;
import com.linea.sig.util.Tokens;

public class ContenedorPropUFPAR implements ContenedorAbstract
{
  private static Logger log = Logger.getLogger(ContenedorPropUFPAR.class);
  private static Logger errorLog = Logger.getLogger("error." + ContenedorPropUFPAR.class);
  private HashMap datosUFPAR;
  private static String UFPARPath;
  private static final String CLASSNAME = "[ContenedorPropUFPAR]";
  // COnstantes de claves
  public static final String CUT_PAPER = "cut";
  public static final String BAR_CODE = "bar";
  public static final String VOUCHER_FILE = "pathVoucher";
  public static final String REWARD_ID_AUTH = "rwIDAuth";

  public ContenedorPropUFPAR()
  {
    datosUFPAR = new HashMap();
    Properties pro = new Properties();
    try
    {
      pro.load(Voucher.class.getResourceAsStream("/com/linea/posappEnginePromotions/Voucher/Properties/prop.pro"));
      UFPARPath = (String) pro.getProperty("UFPAR");
      if (UFPARPath == null || UFPARPath.equals(""))
      {
        UFPARPath = "R::UPPAR:001";
      }
      if (log.isDebugEnabled())
        log.debug(CLASSNAME + "UFPAR : " + UFPARPath);
      // Log.logDebug(CLASSNAME + "UFPAR : " + UFPARPath);
    }
    catch (IOException e)
    {
      errorLog.error("Exception: " + e.getClass().getName() + ":" + e.getMessage(),e);
      
    }
  }

  public void cargaPropiedades()
  {
    PropertiesFiles file = new PropertiesFiles(new File(UFPARPath));
    String path = "";
    String barCode = "";
    String cutPaper = "";
    String authRId = "";
    try
    {
      Vector vec = Tokens.createTokens(file.getKeyFile("Voucher_Name", "[LOYALTY]"), ",", false);
      if (vec.size() >= 2)
      {

        path = (String) vec.get(1);
        if(log.isInfoEnabled())
        {
          log.info(CLASSNAME + "Ruta escritura Voucher: " + path);
        }
//        Log.logInfo(CLASSNAME + "Ruta escritura Voucher: " + path);
        datosUFPAR.put(VOUCHER_FILE, path);
      }
      vec = Tokens.createTokens(file.getKeyFile("Receipt_BarCode", "[LOYALTY]"), ",", false);
      if (vec.size() >= 2)
      {
        barCode = (String) vec.get(1);
        if(log.isInfoEnabled())
          log.info(CLASSNAME + "Codigo para indicar impresión Codigo de barras: " + barCode);
//        Log.logInfo(CLASSNAME + "Codigo para indicar impresión Codigo de barras: " + barCode);
        datosUFPAR.put(BAR_CODE, barCode);
      }
      vec = Tokens.createTokens(file.getKeyFile("Receipt_CutPaper", "[LOYALTY]"), ",", false);
      if (vec.size() >= 2)
      {
        cutPaper = (String) vec.get(1);
        datosUFPAR.put(CUT_PAPER, cutPaper);
        if(log.isInfoEnabled())
          log.info(CLASSNAME + "Indica que se debe cortar el papel: " + cutPaper);
//        Log.logInfo(CLASSNAME + "Indica que se debe cortar el papel: " + cutPaper);
      }
      vec = Tokens.createTokens(file.getKeyFile("Reward Id. Authorized", "[LOYALTY]"), ",", false);
      if (vec.size() >= 2)
      {
        authRId = (String) vec.get(1);
        datosUFPAR.put(REWARD_ID_AUTH, authRId);
//        Log.logInfo(CLASSNAME + "Lista de rewards referentes a bonos especiales " + authRId);
        if(log.isInfoEnabled())
          log.info(CLASSNAME + "Lista de rewards referentes a bonos especiales " + authRId);
      }
      file.close();
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      
      errorLog.error(CLASSNAME + "Error: " + e.getClass().getName() + ":" + e.getMessage(), e);
//      Log.logError(CLASSNAME + "Error: " + e.getMessage());
    }
  }

  public String extraerPropiedad(String clave)
  {
    return (String) datosUFPAR.get(clave);
  }

  public String toString()
  {
    return datosUFPAR.toString();
  }

public void cargaPropiedadesWIN() {
	// TODO Auto-generated method stub
	
}

}
