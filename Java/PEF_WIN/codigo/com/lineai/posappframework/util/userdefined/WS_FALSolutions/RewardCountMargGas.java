package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.Core;
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.ProcessRequest;


public class RewardCountMargGas extends RewardCount
{
  private static Logger log = Logger.getLogger(RewardCountMargGas.class);
  public double sumaMargen = 0;
  public static final String CLASSNAME = "[RewardCountMarGas]";
//  private double acarreo = 0;
  public RewardCountMargGas(InfoReward info)
  {
    super(info);
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Se crear Reward con Margen para id: " + info.getRewardId());
//    Log.logInfo(CLASSNAME + "Se crear Reward con Margen para id: " + info.getRewardId());
    if(info.getFinancingRef()== null || info.getFinancingRef().equals("0"))
    {
      double valor = 0;
      if(Core.tieneDecimales())
      {
        valor = info.getDescuento();
      }
      else
      {
        valor = Math.floor(info.getDescuento());        
      }
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Valor añadido en el constructor: " + valor);
//      Log.logDebug(CLASSNAME + "Valor añadido en el constructor: " + valor);
      sumaMargen += valor;
    }
   
  }
  public void add(InfoReward info)
  {
    super.add(info);
    if(info.getFinancingRef()== null || info.getFinancingRef().equals("0"))
    {
      double value = Math.floor(info.getDescuento());
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Se procede a añadire el valor de: " + value);
//      Log.logDebug(CLASSNAME + "Se procede a añadire el valor de: " + value);
      sumaMargen += value;
      if(log.isInfoEnabled())
        log.info(CLASSNAME + "Valor parcial al margen: " + sumaMargen);
//      Log.logInfo(CLASSNAME + "Valor parcial al margen: " + sumaMargen);
    }
  }
  public String trama()
  {
    return trama(acarreo);
  }
  public String trama(double ac)
  {
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "acarreo: " + ac);
//    Log.logDebug(CLASSNAME + "acarreo: " + ac);
    long suma = 0;
    BigDecimal respSum;
    String respPartial = super.trama(ac);
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Suma Margen sin acarreo: " + sumaMargen);
//    Log.logInfo(CLASSNAME + "Suma Margen sin acarreo: " + sumaMargen);
    if(Core.tieneDecimales())
    {
      respSum = new BigDecimal(sumaMargen + ac).setScale(2,BigDecimal.ROUND_HALF_UP).multiply(ProcessRequest.centCorrec).setScale(0, BigDecimal.ROUND_HALF_UP);
      if(log.isInfoEnabled())
        log.info(CLASSNAME + "Suma Margen: " + respSum);
//      Log.logInfo(CLASSNAME + "Suma Margen: " + respSum);
    }
    else
    {
      respSum = new BigDecimal(sumaMargen + ac).setScale(0, BigDecimal.ROUND_HALF_UP);
    }
    String response = respPartial;
    suma = respSum.longValue();
    if(respPartial == null || respPartial.length() > 0 || respPartial.indexOf(',') > 0)
    {
      response = respPartial.substring(0, respPartial.indexOf(','));
      response = response.concat("," + suma);
      response = response.concat(respPartial.substring(respPartial.indexOf(',')));
    }
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Respuesta parcial : " + response);
//    Log.logInfo(CLASSNAME + "Respuesta parcial : " + response);
    return response;
    
  }
}
