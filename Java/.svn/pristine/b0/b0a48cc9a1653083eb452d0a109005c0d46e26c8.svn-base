package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.fal.ws.impl.Reward;
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.Core;
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.ProcessRequest;

public class RefundManagement
{
  private static Logger log = Logger.getLogger(RefundManagement.class);
  private static final String NOMBRE_CLASE = "[RefundManagement]";
  private HashMap refunds;
  public RefundManagement()
  {
    refunds = new HashMap();
  }
  /**
   * Simplemente se encarga de sacar los rewards, y almacenarlos
   * @param rewards Vector de rewards al que se le extraeran los datos
   */
  public void extractRefunds(Reward[] rewards)
  {
    if(rewards == null || rewards.length == 0)
    {
      log.warn(NOMBRE_CLASE + "No hubo rewards asociados a la transaccion");
//      Log.logWarning(NOMBRE_CLASE + "No hubo rewards asociados a la transaccion");
      
    }
    else
    {
      for(int i = 0; i<rewards.length; i++)
      {
        processRewards(rewards[i]);
      }
    }
  }
  public void addRewardWithAmount(Reward reward)
  {
    reward.setRewardAmount(0);
    processRewards(reward);
  }
  private void processRewards(Reward reward)
  {
    if(refunds.containsKey(reward.getProductCode()))
    {
      RefundInformation valueAct = (RefundInformation)refunds.get(reward.getProductCode());
      valueAct.addReward(new BigDecimal(reward.getRewardAmount()));
      refunds.put(reward.getProductCode(), valueAct);
    }
    else
    {
      BigDecimal firstValue = new BigDecimal(reward.getRewardAmount());
      if(log.isInfoEnabled())
        log.info(NOMBRE_CLASE + "Creando devolución con " + firstValue);
//      Log.logInfo(NOMBRE_CLASE + "Creando devolución con " + firstValue);
      RefundInformation rfInfo = new RefundInformation(firstValue, reward.getRewardQuantity());
      refunds.put(reward.getProductCode(), rfInfo);
    }
  }
  /**Crea la trama a devolver a BASIC
   * @return trama en formato: ||
   */
  public String trama()
  {
    String response = "999|";
    if(refunds == null || refunds.isEmpty())
    {
      return "999|0";
    }
    else
    {
      Iterator it = refunds.keySet().iterator();
      while(it.hasNext())
      {
        String codArt = (String)it.next();
        RefundInformation rfTemp = (RefundInformation)refunds.get(codArt);
        BigDecimal vlrTemp = rfTemp.getValue();
        if(Core.tieneDecimales())
        {
          vlrTemp = vlrTemp.multiply(ProcessRequest.centCorrec);
        }
        vlrTemp = vlrTemp.abs();
        vlrTemp = vlrTemp.setScale(0, BigDecimal.ROUND_HALF_UP);
        if(log.isInfoEnabled())
          log.info(NOMBRE_CLASE + "Valor art: " + codArt + ":" + vlrTemp);
//        Log.logInfo(NOMBRE_CLASE + "Valor art: " + codArt + ":" + vlrTemp);
        response = response + codArt + "," + vlrTemp.longValue();
        
      }
    }
    return response;
    
  }
}
