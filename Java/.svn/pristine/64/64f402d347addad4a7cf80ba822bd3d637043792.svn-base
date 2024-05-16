package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

import java.math.BigDecimal;

import org.apache.log4j.Logger;



public class RefundInformation
{
  private static Logger log = Logger.getLogger(RefundInformation.class);
  private BigDecimal value;
  private int quantity;
  public RefundInformation(BigDecimal value, int quantity)
  {
    this.value = value;
    this.quantity = quantity;
  }
  public void addReward(BigDecimal nValue)
  {
    if(log.isDebugEnabled())
      log.debug("[RefundInformation]Se han añadido " + nValue);
//    Log.logDebug("[RefundInformation]Se han añadido " + nValue);
    value = value.add(nValue);
    if(log.isInfoEnabled())
      log.info("[RefundInformation]total " + value);
//    Log.logInfo("[RefundInformation]total " + value);
  }
  public String trama()
  {
    return quantity + "," + value.longValue();
  }
  public BigDecimal getValue()
  {
    return value;
  }
  public int getQuantity()
  {
    return this.quantity;
  }

}
