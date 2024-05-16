package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

import org.apache.log4j.Logger;

/**
 * 
 * @author ferru Clase que contiene el mensaje y la categoria
 */
public class RewardDescription
{
  /*
   * Por si quiero hacer logs
   */
  private static Logger log = Logger.getLogger(RewardDescription.class);

  private final static String CLASSNAME = "[RewardDescription]";
  private String msg;
  private int categoria;
  private String financialRef;

  /*
   * Constructor
   */
  public RewardDescription(int cat, String msg, String financialRef)
  {
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "msg: " + msg + ", cat " + cat);
    // Log.logInfo(CLASSNAME + "msg: " + msg + ", cat " + cat);
    this.setCategoria(cat);
    this.setMsg(msg);
    this.setFinancialRef(financialRef);
  }

  /*
   * GETS
   */
  public String getMsg()
  {
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "msg: " + msg);
//    Log.logInfo(CLASSNAME + "msg: " + msg);
    return msg;
  }

  public int getCategoria()
  {
    return categoria;
  }

  /*
   * SETS
   */
  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public void setCategoria(int categoria)
  {
    this.categoria = categoria;
  }

  public String getFinancialRef()
  {
    return financialRef;
  }

  public void setFinancialRef(String financialRef)
  {
    this.financialRef = financialRef;
  }
}
