package com.lineai.posappframework.xmlwrappers.actors.userdefined.WS_FALSolution;

import java.util.BitSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class FALWrapper
{
    private static Logger log = Logger.getLogger(FALWrapper.class);
    private static Logger errorLog = Logger.getLogger("error." + FALWrapper.class.getName());
    private String[][] conexion; // ip,port,ruta ,timeout ---- asi estan
    // en la matriz
    private BitSet flags = new BitSet(3);
    private String[] central = new String[4];
    private Document doc = null;
    private static final String class_name = "[FALWrapper]";
  
    public FALWrapper()
    {
      flags.clear();
      if(log.isDebugEnabled())
        log.debug(class_name + "Iniciando FalWrapper");
//      Log.logDebug(class_name + "Iniciando FalWrapper");
      SAXBuilder sxbld = new SAXBuilder();
      if(log.isDebugEnabled())
        log.debug(class_name + "SaXBuilder creado bien");
//      Log.logDebug(class_name + "SaXBuilder creado bien");
      try
      {
        this.doc = sxbld.build(this.getClass().getResourceAsStream("/xml/WS_FALSolutions.xml"));
        initParams();
      }
      catch (JDOMException e)
      {
        errorLog.error("Exception: " + e.getClass().getName() + ":" + e.getMessage(), e); 
      }
    }
  
    protected void initParams()
    {
      if(log.isDebugEnabled())
        log.debug(class_name + "Leyendo parametros");
//      Log.logDebug(class_name + "Leyendo parametros");
  
      Element root = doc.getRootElement();
      
  
      // CARGA DE PARAMETROS PARA EL WEB SERVICE
  
      Element Element_WS = root.getChild("WS");
      Element rwrMsg = Element_WS.getChild("mensajeTrx");
      if(rwrMsg != null)
      {
        String rwrMsgVal = rwrMsg.getAttributeValue("enable");
        if(rwrMsgVal!= null && !rwrMsgVal.trim().equals("") && !rwrMsgVal.trim().equals("0"))
        {
          //O para Mensajes por Reward, si está el tag...pasa a trabajar mensajes por Transacción
          flags.flip(0);
        }
        if(log.isDebugEnabled())
          log.debug(class_name + "Se escriben Mensajes de Reward?" + flags.get(0));
//        Log.logDebug(class_name + "Se escriben Mensajes de Reward?" + flags.get(0));
      }
//      Log.logDebug(class_name + "Leyendo parametros - WS: " + Element_WS);
      Element Element_IP = Element_WS.getChild("IP");
//      Log.logDebug(class_name + "Leyendo parametros - IP: " + Element_IP);
      Element Element_P = Element_IP.getChild("P");
//      Log.logDebug(class_name + "Leyendo parametros - P: " + Element_P);
      List Element_A = Element_IP.getChildren("A");
//      Log.logDebug(class_name + "Leyendo parametros - A: " + Element_A);
      if(log.isDebugEnabled())
        log.debug(class_name + "Leyendo parametros - WS: " + Element_WS + "\n"
           + class_name + "Leyendo parametros - IP: " + Element_IP + "\n"
           + class_name + "Leyendo parametros - P: " + Element_P + "\n"
            + class_name + "Leyendo parametros - A: " + Element_A);
  
      this.conexion = new String[Element_A.size() + 1][4];
      if (Element_P == null)
      {
        this.conexion[0][0] = "0.0.0.0";
        this.conexion[0][1] = "80";
        this.conexion[0][2] = "/thing/thing";
        this.conexion[0][3] = "15";
      }
      else
      {
        if(Element_P.getAttribute("central") != null)
        {
          central[0] = Element_P.getAttributeValue("value");
          central[1] = Element_P.getAttributeValue("port");
          central[2] = Element_P.getAttributeValue("ruta");
          central[3] = Element_P.getAttributeValue("timeout"); 
        }
        this.conexion[0][0] = Element_P.getAttributeValue("value");
        if(this.conexion[0][0].equals("PEPrimary"))
        {
          //Valor en posición 1 para determinad si se es el Primary
          if(log.isDebugEnabled())
            log.debug(class_name + "Hallado Principal");
//          Log.logDebug(class_name + "Hallado Principal");
          flags.flip(1);
        }
        else if (this.conexion[0][0].equals("PESecundary"))
        {
          if(log.isDebugEnabled())
            log.debug(class_name + "Hallado Secundario");
//          Log.logDebug(class_name + "Hallado Secundario");
          //Secondary en el indice 2
          flags.flip(2);
        }
        this.conexion[0][1] = Element_P.getAttributeValue("port");
        this.conexion[0][2] = Element_P.getAttributeValue("ruta");
        this.conexion[0][3] = Element_P.getAttributeValue("timeout");
      }
  
      for (int i = 0; i < Element_A.size(); i++)
      {
        Element A = (Element) Element_A.get(i);
        if(A.getAttribute("central") != null)
        {
          central[0] = A.getAttributeValue("value");
          central[1] = A.getAttributeValue("port");
          central[2] = A.getAttributeValue("ruta");
          central[3] = A.getAttributeValue("timeout"); 
        }
        if(log.isDebugEnabled())
          log.debug("IP Respaldo # " + i);
//        Log.logDebug("IP Respaldo # " + i);
        
        this.conexion[i + 1][0] = A.getAttributeValue("value");
        //Posición 1 para Primary
        if( !flags.get(1) && this.conexion[i+1][0].equals("PEPrimary") )
          flags.flip(1);
        //Posición 2 de flags para Secondary
        if( !flags.get(2) && this.conexion[i+1][0].equals("PESecundary") )
        {
          if(log.isDebugEnabled())
            log.debug(class_name + "Hallado Secundario");
//          Log.logDebug(class_name + "Hallado Secundario");
          flags.flip(2);
        }
//        Log.logDebug(class_name + "Valor: " + this.conexion[i + 1][0]);
        this.conexion[i + 1][1] = A.getAttributeValue("port");
//        Log.logDebug(class_name + "Puerto: " + this.conexion[i + 1][1]);
        this.conexion[i + 1][2] = A.getAttributeValue("ruta");
//        Log.logDebug(class_name + "Ruta: " + this.conexion[i + 1][2]);
        this.conexion[i + 1][3] = A.getAttributeValue("timeout");
//        Log.logDebug(class_name + "TiempoEspera: " + this.conexion[i + 1][3]);
        if(log.isDebugEnabled())
          log.debug(class_name + "Valor: " + this.conexion[i + 1][0] + "\n"
            + class_name + "Puerto: " + this.conexion[i + 1][1] + "\n"
            + class_name + "Ruta: " + this.conexion[i + 1][2] + "\n"
            + class_name + "TiempoEspera: " + this.conexion[i + 1][3] + "\n"
            + class_name + "Fin Leyendo parametros ");
      }
//      Log.logDebug(class_name + "Fin Leyendo parametros ");
    }
  
    public String[][] getConexion()
    {
      if(log.isDebugEnabled())
        log.debug(class_name + "Retornando conexion ");
//      Log.logDebug(class_name + "Retornando conexion ");
      return conexion;
    }
    public String[] getCentral()
    {
      if(log.isDebugEnabled())
        log.debug(class_name + "Retornando conexion central ");
//      Log.logDebug(class_name + "Retornando conexion central ");
      return central;
    }
    //Cero para el BitSet...para los mensajes de Reward
    public boolean isRewardTrx()
    {
      return flags.get(0);
    }

    public void setTrxRewards(boolean rewardMessages)
    {
      flags.set(0, rewardMessages);
    }
    public boolean isPePrimary()
    {
      return flags.get(1);
    }
    public boolean isPeSecondary()
    {
      return flags.get(2);
    }
}
