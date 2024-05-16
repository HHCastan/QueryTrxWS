package com.lineai.posappframework.util.userdefined.WS_FALSolutions.validator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.linea.posappEnginePromotions.contenedores.ContenedorPropUFPAR;
import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.Core;


public class WeirdDiscountManager
{
  private static Logger log = Logger.getLogger(WeirdDiscountManager.class);
  private HashMap discounts;
  private HashSet rwIdVal;
  private HashSet used;
  private static final String CLASSNAME = "[WDM]";
  public WeirdDiscountManager()
  {
    discounts =new HashMap();
    rwIdVal = new HashSet();
    used = new HashSet();
    String stringRID = Core.extraerPropiedad("2", ContenedorPropUFPAR.REWARD_ID_AUTH);
    StringTokenizer rewardsID = new StringTokenizer(stringRID, ":");
    while(rewardsID.hasMoreElements())
    {
      if(log.isDebugEnabled())
        log.debug("[WDM]Faltan " + rewardsID.countTokens() + " Descuentos raros");
//      Log.logDebug("[WDM]Faltan " + rewardsID.countTokens() + " Descuentos raros");
      rwIdVal.add(rewardsID.nextToken().trim());
    }
  }
  /**
   * Se encarga de ir modificando el monto de los rewardID's correspondientes
   * a los ubicados en el UFPAR asociados con bonos especiales
   * @param RewardID ID del descuento a modificar el valor
   * @param value Valor a añadir (se maneja como BigInteger para procesamiento de 
   *        decimales
   */
  public void modifyReward(String rewardID, BigDecimal value)
  {
    if(log.isInfoEnabled())
      log.info("[WDM]Modificando Valor Reward con " + value);
//    Log.logInfo("[WDM]Modificando Valor Reward con " + value);
    /*
     * edgar.cuesta
     * Seria bueno probar el used.add como condición del if, en vez
     * de realizar el containKey. solo por curiosidad realizar una prueba
     * de rendimiento
     */
//    used.add(rewardID);
    
    if(discounts.containsKey(rewardID.trim()))
    {
      BigDecimal toModify = (BigDecimal)discounts.get(rewardID.trim());
      if(log.isInfoEnabled())
        log.info(CLASSNAME + "Valor anterior" + toModify);
//      Log.logDebug(CLASSNAME + "Valor anterior" + toModify);
      toModify = toModify.add(value);  
      
      discounts.put(rewardID.trim(), toModify);
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Valor nuevo" + toModify);
//      Log.logDebug(CLASSNAME + "Valor nuevo" + toModify);
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Sebe de insertar el valor del reward");
//      Log.logDebug(CLASSNAME + "Sebe de insertar el valor del reward");
      discounts.put(rewardID.trim(), value);
    }
  }
  public boolean isAWeirdDiscount(String RewardID)
  {
    if (this.rwIdVal.contains(RewardID))
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Yo soy: " + this + "\n" + CLASSNAME + "¿Descuento ya usado?" + used.contains(RewardID));
//      Log.logDebug(CLASSNAME + "Yo soy: " + this);
//      Log.logDebug(CLASSNAME + "¿Descuento ya usado?" + used.contains(RewardID));
      return true;
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "No es de tipo Bono Especial");
//      Log.logDebug(CLASSNAME + "No es de tipo Bono Especial");
      return false;
    }
  }
  public Iterator getRewardsId()
  {
    return rwIdVal.iterator();
  }
  public BigDecimal getValue(String rewardId)
  {
    return (BigDecimal)discounts.get(rewardId.trim());
  }
  /**
   * @param rewardId Reward a insertar
   * @return devuelve verdadero si el reward no ha sido usado, y falso 
   *            si ha sido usado, o si no es un descuento de tipo
   *            de "bono especial"
   */
  public boolean isUsedWeirdDiscount(String rewardId)
  {
    boolean response = false;
    if(rwIdVal.contains(rewardId))
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Se procede a añadir el descuento que ha sido usado");
//      Log.logDebug(CLASSNAME + "Se procede a añadir el descuento que ha sido usado");
      return used.contains(rewardId);
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "El Reward a modificar no es un descuento"
        + " al que se apliquen bonos especiales");
//      Log.logDebug(CLASSNAME + "El Reward a modificar no es un descuento"
//        + " al que se apliquen bonos especiales");
    }
    return response;
  }
  public String toString()
  {
    return "{"+used+","+rwIdVal + ","+discounts+"}";
  }
  public void emptyRewards()
  {
    discounts = new HashMap();
  }
  public boolean usedWeirdDiscount(String rewardId)
  {
//    boolean response = false;
    if(rwIdVal.contains(rewardId))
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Se procede a añadir el descuento que ha sido usado");
//      Log.logDebug(CLASSNAME + "Se procede a añadir el descuento que ha sido usado");
      return used.add(rewardId);
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "El Reward a modificar no es un descuento"
        + " al que se apliquen bonos especiales");
//      Log.logDebug(CLASSNAME + "El Reward a modificar no es un descuento"
//        + " al que se apliquen bonos especiales");
    }
    return false;
  }
  public boolean deleteFromUsed(String rewardId)
  {
    if(rwIdVal.contains(rewardId))
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Se procede a eliminar Reward de usados");
//      Log.logDebug(CLASSNAME + "Se procede a eliminar Reward de usados");
      return used.remove(rewardId);
    }
    else
    {
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Id no es de tipo bono especial");
//      Log.logDebug(CLASSNAME + "Id no es de tipo bono especial");
      return false;
    }
  }
  
 
	
	//reinicializa los descuentos especiales
	public void limpiarDescuentosEspecialesUsados()
	{		
		this.used     = new HashSet();
	}
	public void limpiarTotalesDescuentosEspeciales()
	{
		this.discounts= new HashMap();
	}
}
