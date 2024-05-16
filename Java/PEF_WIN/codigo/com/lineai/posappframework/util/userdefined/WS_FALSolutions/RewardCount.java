package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.Core;
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.ProcessRequest;

/**
 * 
 * @author ferru 10/01/2013 Clase que contiene el acumulado de todos los rewards
 *         con el mismo rewardID
 * 
 */
public class RewardCount
{
  private static Logger log = Logger.getLogger(RewardCount.class);
  private final static String CLASSNAME = "[RewardCount]";

  private boolean incluirMensaje = true;

  /*
   * Necesario para evitar problemas al redondear
   */
  protected double acarreo = 0;
  protected double value = 0;
  protected RewardDescription rwr;

  /**
   * @author edgar.cuesta
   * @param categoria
   *          - Me indica el tipo de reward
   * @param valor
   *          . double con el valor del descuento, un valor inicial
   * @param msg
   *          - descripción del descuento Constructor
   */
  public RewardCount(InfoReward info)
  {
    int categoria = info.getCategory();
    String msg = info.getMensaje();
    String financialRef = info.getFinancingRef();
    double valor = info.getDescuento();
    rwr = new RewardDescription(categoria, msg, financialRef);
    if (Core.tieneDecimales())
    {
      this.value = valor;
      this.acarreo = 0;
    }
    else
    {
      this.value = Math.floor(valor);
      this.acarreo = valor - value;
    }
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "Valor añadido " + valor + "\n" + CLASSNAME + "Valor actual " + value);
//    Log.logDebug(CLASSNAME + "Valor añadido " + valor);
//    Log.logDebug(CLASSNAME + "Valor actual " + value);

  }

  /**
   * @author edgar.cuesta
   * @param valor
   *          - Valor a añadir, se actualiza el valor Suma el valor y el acarreo
   *          del reward
   */
  public void add(InfoReward info)
  {
    double valor = info.getDescuento();
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Se añade el valor..." + valor);
//    Log.logInfo(CLASSNAME + "Se añade el valor..." + valor);
    if (Core.tieneDecimales())
    {
      value += valor;
    }
    else
    {
      long vlrAux = new Double(Math.floor(valor)).longValue();
      double acAux = valor - Math.floor(valor);
      value += vlrAux;
      acarreo += acAux;
    }
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "Nuevo valor de dcto: " + value);
//    Log.logDebug(CLASSNAME + "Nuevo valor de dcto: " + value);
  }

  /**
   * @author edgar.cuesta Devuelve la trama del total para este reward
   * @return Trama de respuesta de la forma 'valor,mensaje'
   */
  public String trama()
  {
    String response = trama(acarreo);
    return response;
  }

  /**
   * @author edgar.cuesta
   * @param ac
   *          - el acarreo que deseo tenga es reward. Ignora el acarreo del obj
   *          Devuelve la trama del total para este reward OJO quitar campo
   *          suma, sólo para prueba
   */
  public String trama(double ac)
  {
    String response = "";
    /*
     * Para ubicar el valor total y mantener separados el value del acarreo
     */
    double vlr = 0;
    String msg = "";
    if (rwr.getCategoria() == 5)
    {
      // double valAux = value + ac;
      double valAux = 0;
      valAux = value + (new Double(Math.round(ac))).longValue();
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "print: " + valAux);
//      Log.logDebug(CLASSNAME + "print: " + valAux);
      msg = rwr.getMsg().concat(" = " + new Double(valAux).longValue());
      vlr = 0;
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "acarreo: " + ac + "\n" + CLASSNAME + "print: " + value);
//      Log.logDebug(CLASSNAME + "acarreo: " + ac);
//      Log.logDebug(CLASSNAME + "print: " + value);
      msg = rwr.getMsg();
      if (Core.tieneDecimales())
      {
        vlr = value + ac;
        double valPod = new BigDecimal(vlr).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        vlr = valPod;
      }
      else
      {
        // double valPod = new Double(vlr);
        vlr = value + (new Double(Math.round(ac))).longValue();
        vlr = vlr + ac;
      }
    }
    if (Core.tieneDecimales())
      vlr = new BigDecimal(vlr).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(ProcessRequest.centCorrec)
        .setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();

    if (incluirMensaje)
      response = new Double(Math.round(vlr)).longValue() + "," + (msg.equals("") ? " " : msg);
    else
      response = new Double(Math.round(vlr)).longValue() + ", ";

    // if(Core.tieneDecimales())
    // vlr = vlr * Double.parseDouble(ProcessRequest.DECIMALES);
    // response = new Double(vlr).longValue() + "," + (msg.equals("") ? " " :
    // msg);
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Respuesta parcial:  " + response);
//    Log.logInfo(CLASSNAME + "Respuesta parcial:  " + response);
    return response;
  }

  /*
   * GETS
   */
  public double getAcarreo()
  {
    return this.acarreo;
  }

  public String getMsg()
  {
    if(log.isInfoEnabled())
      log.info("rwr es null? " + rwr);
//    Log.logInfo("rwr es null? " + rwr);
    return rwr.getMsg();
  }

  /*
   * SETS
   */
  public void setAcarreo(double ac)
  {
    this.acarreo = ac;
  }

  public boolean isIncluirMensaje()
  {
    return incluirMensaje;
  }

  public void setIncluirMensaje(boolean incluirMensajeIn)
  {
    incluirMensaje = incluirMensajeIn;
  }

  public String getCodigoFinanciacion()
  {
    return rwr.getFinancialRef();
  }
  public String getDescription2Instance()
  {
    return this.getDescription2Instance(acarreo);
  }
  public int getCategori()
  {
    return rwr.getCategoria();
  }
  public String getDescription2Instance(double ac)
  {
    if(rwr.getCategoria() == 5)
    {
      double vlr = 0;
      String msg = "";
      double valAux = value + (new Double(Math.round(ac))).longValue();
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "print: " + valAux);
//      Log.logDebug(CLASSNAME + "print: " + valAux);
      msg = rwr.getMsg().concat(" = " + new Double(valAux).longValue());
      return msg;
    }
    else
    {
      return rwr.getMsg();
    }
  }
}
