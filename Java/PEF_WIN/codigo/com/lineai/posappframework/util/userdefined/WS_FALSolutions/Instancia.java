package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

// import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.fal.ws.impl.BasketRequest;
import com.fal.ws.impl.LineItem;
import com.fal.ws.impl.RewardsResponse;

public class Instancia
{
  public static int cursor = 0;
  public static ArrayList respuesta = new ArrayList();

  private static final String CLASSNAME = "[Instancia]";
  private static Logger log = Logger.getLogger(Instancia.class);

  // ultima respuesta de loyalty

  public static Vector InfoRewardsItem;
  private static String cuponesItem;
  private static RewardsResponse ultimaRespuestaLoyalty;
  private static RewardsResponse penUltimaRespuestaLoyalty;

  private static Vector InfoRewardsPay;
  private static String cuponesPay;

  // Info Reward de las opciones 0
  private static Vector InfoRewardsItem0;
  private static boolean isCampanhas = false;

  public static BasketRequest b;
  public static BasketRequest bpay;

  private static final String class_name = "[Instancia]";

  private static double decimal;
  static
  {
    InfoRewardsItem = new Vector();
    InfoRewardsItem0 = new Vector();
    InfoRewardsPay = new Vector();
    ultimaRespuestaLoyalty = null;
    log = Logger.getLogger(Instancia.class);
  }

  // Gets
  public static InfoReward getInfoRewarItem(int index) throws ArrayIndexOutOfBoundsException, NullPointerException
  {
    // System.out.println("index: " + index);
    if(log.isDebugEnabled())
      log.debug(class_name + "index: " + index);
//    Log.logDebug(class_name + "index: " + index);
    if (InfoRewardsItem == null || index > InfoRewardsItem.size())
      return null;
    else
      return (InfoReward) InfoRewardsItem.get(index);
  }

  public static InfoReward getInfoRewarItem0(int index) throws ArrayIndexOutOfBoundsException, NullPointerException
  {
    if(log.isDebugEnabled())
      log.debug(class_name + "index: " + index);
//    Log.logDebug(class_name + "index: " + index);
    if (InfoRewardsItem0 == null || index > InfoRewardsItem0.size())
      return null;
    else
      return (InfoReward) InfoRewardsItem0.get(index);
  }

  public static InfoReward getInfoRewarPay(int index)
  {
    return (InfoReward) InfoRewardsPay.get(index);
  }

  public static String getCupones()
  {
    return cuponesItem + cuponesPay;
  }

  public static String getInfo()
  {
    String response = "";

    InfoReward info;

    if (InfoRewardsPay != null)
    {
      for (int i = 0; i < InfoRewardsPay.size(); i++)
      {
        info = (InfoReward) InfoRewardsPay.get(i);
        if (i == InfoRewardsPay.size() - 1)
          response = response + info.getInfo();
        else
          response = response + info.getInfo() + "~";
        // System.out.println("Solo payment: " + response);

      }
    }

    response += "|";
    if (InfoRewardsItem != null)
    {
      for (int i = 0; i < InfoRewardsItem.size(); i++)
      {
        info = (InfoReward) InfoRewardsItem.get(i);
        if (i == InfoRewardsItem.size() - 1)
          response = response + info.getInfo();
        else
          response = response + info.getInfo() + "~";
        // System.out.println("payment+item: " + response);
      }
    }
    response += "|";
    if (InfoRewardsItem0 != null)
    {
      for (int i = 0; i < InfoRewardsItem0.size(); i++)
      {
        info = (InfoReward) InfoRewardsItem0.get(i);
        if (i == InfoRewardsItem0.size() - 1)
          response = response + info.getInfo();
        else
          response = response + info.getInfo() + "~";
        // System.out.println("payment+item0: " + response);
      }
    }
    return response;
  }

  // Limpian los vectores
  public static void reStartVectorItem()
  {
    InfoRewardsItem = null;
    System.gc();
  }

  public static void reStartVectorItem0()
  {
    InfoRewardsItem0 = null;
    System.gc();
  }

  public static void reStartVectorPay()
  {
    InfoRewardsPay = null;
    System.gc();
  }

  public static void reStartCuponItem()
  {
    cuponesItem = "";
    System.gc();
  }

  public static void reStartCuponPay()
  {
    cuponesPay = "";
    System.gc();
  }

  // Sets
  public static void setElementOfVectorItem(InfoReward info)
  {
    if (InfoRewardsItem != null)
    {
      if(log.isDebugEnabled())
        log.debug(class_name + "Tama&ntilde;o infoRewardsIte antes: " + InfoRewardsItem.size()
          + "\n\tA&ntilde;adiendo infoReward con id: " + info.getRewardId());
      InfoRewardsItem.add(info);
      if(log.isDebugEnabled())
        log.debug(class_name + "Tama&ntilde;o infoRewardsIte despues: " + InfoRewardsItem.size()
          + "\nElementos posicion 1 " + ((InfoReward) InfoRewardsItem.get(1)).getRewardId()
          + "Tama&ntilde;o infoRewardsIte despues2: " + InfoRewardsItem.size());
//      Log.logDebug("Tama�o infoRewardsIte despues: " + InfoRewardsItem.size());
//      Log.logDebug("Elementos posicion 1 " + ((InfoReward) InfoRewardsItem.get(1)).getRewardId());
//      Log.logDebug("Tama�o infoRewardsIte despues2: " + InfoRewardsItem.size());
    }
    else
    {
      InfoRewardsItem = new Vector();
      InfoRewardsItem.add(info);
    }
  }

  public static void setElementOfVectorItem0(InfoReward info)
  {
    if (InfoRewardsItem0 != null)
      InfoRewardsItem0.add(info);
    else
    {
      InfoRewardsItem0 = new Vector();
      InfoRewardsItem0.add(info);
    }
  }

  public static void setElementOfVectorPay(InfoReward info)
  {

    if (InfoRewardsPay != null)
      InfoRewardsPay.add(info);
    else
    {
      InfoRewardsPay = new Vector();
      InfoRewardsPay.add(info);
    }
  }

  public static void setCuponItem(String cupon)
  {
    cuponesItem = cuponesItem + cupon + "~";
  }

  public static void setCuponPay(String cupon)
  {
    cuponesPay = cuponesPay + cupon + "~";
  }

  public static void setCuponPayFin(String cupon)
  {
    cuponesPay = cuponesPay + cupon;
  }

  public static String consolidado()
  {
    Instancia.isCampanhas = false;
    StringBuffer consolidado = new StringBuffer();
    sacaX(InfoRewardsItem);
    // ponderaDescuento(InfoRewardsItem0);
    ponderaDescuento(InfoRewardsPay);
    
    consolidado.append(getConsolidado());
    consolidado.append('|');
    
//    sacaX(InfoRewardsItem0);
  //Esto existía antes, ya no es necesario
//    consolidado += getConsolidado() + "|";
//    sacaX(InfoRewardsPay);
//    consolidado += getConsolidado() + "|";
    consolidado.append(consolidadoCampanhas());

    return consolidado.toString();
  }
  /*
   * OJO quitar suma
   */
  public static String consolidadoItem(int suma)
  {
    Instancia.isCampanhas = false;
    String consolidado = "";
    sacaX(InfoRewardsItem);
    consolidado += getConsolidado();
    // Nota: el incluir mensaje no debería ser una variable estática, y debería
    // manejarse internamente por reward
    // He retirado ese código de este método, añadiéndolo al getConsolidado,
    // donde ya diferenciaba entre descuentos
    // Por artículos y descuentos por campañas
    return consolidado;
  }

  /*
   * OJO quitar suma luego de prueba
   */
  public static String acumuladoItem0()
  {
    Instancia.isCampanhas = false;
    // Leer comentario en consolidado item
    String consolidado = "";
    sacaX(InfoRewardsItem0);
    consolidado += getTotalAcumulado();
    return consolidado;

  }
  /*
   * OJO Quitar suma
   */
  public static String consolidadoCampanhas()
  {
    // System.out.println("item");
    // System.out.println(InfoRewardsItem.size());
    StringBuffer consolidado = new StringBuffer();
    if(log.isDebugEnabled())
      log.debug(class_name + "Sacando InfoRewardItem");
//    Log.logDebug(class_name + "Sacando InfoRewardItem");
    sacaCampanhas(InfoRewardsItem);
    // System.out.println("pay");
    if(log.isDebugEnabled())
      log.debug(class_name + "Sacando InfoRewardPay");
//    Log.logDebug(class_name + "Sacando InfoRewardPay");
    sacaCampanhas(InfoRewardsPay);
    // System.out.println("item0");
    if(log.isDebugEnabled())
      log.debug(class_name + "Sacando InfoRewardItem0");
//    Log.logDebug(class_name + "Sacando InfoRewardItem0");
    sacaCampanhas(InfoRewardsItem0);
    Instancia.isCampanhas = true;
    consolidado.append(getDesc());
    consolidado.append('|');
    consolidado.append(getConsolidado());
    return consolidado.toString();
  }

  private static void sacaCampanhas(Vector infoRewards)
  {
    InfoReward info;
    // for (int i = 0; i < infoRewards.size(); i++) {
    /*
     * edgar.cuesta 15/07/2013 -> Por cuestiones de eficicencia, se elimina el
     * comportamiento, donde el ciclo termina mediante el lanzamiento de una
     * excepción
     */
    if (infoRewards != null)
    {
      if(log.isDebugEnabled())
        log.debug(class_name + "Tama&ntilde;o del Vector(SacaCampanhas): " + infoRewards.size());
//      Log.logDebug(class_name + "Tama�o del Vector(SacaCampanhas): " + infoRewards.size());
      for (int i = 0; i < infoRewards.size(); i++)
      {
        info = (InfoReward) infoRewards.get(i);
        // i++;
        if (info != null)
        {
          addRewardID(info.getRewardId(), info, false);
          // addRewardID(info);
          if(log.isDebugEnabled())
            log.debug("Indice campanas: " + i);
//          Log.logDebug("Indice campanas: " + i);
        }
        else
        {
          // sw = false;
          log.warn(class_name + "no hay mas campanhas");
//          Log.logDebug(class_name + "no hay mas campanhas");
        }
      }
    }

  }

  private static void sacaX(Vector infoRewards)
  {
    /*
     * edgar.cuesta 31/08/2012-> Cambio que permite separar el tipo de reward,
     * para que no se acumulen (suman) entre s�. Los rewards de categor�a 5,
     * solo son enviados a BASIC, en la trama de campa�as 15/07/2013 -> Por
     * cuestiones de eficicencia, se elimina el comportamiento, donde el ciclo
     * termina mediante el lanzamiento de una excepción
     */
    if (infoRewards != null)
    {
      InfoReward info;
      for (int i = 0; i < infoRewards.size(); i++)
      {
        info = (InfoReward) infoRewards.get(i);
        if (info != null)
        {
          if(log.isInfoEnabled())
            log.info(class_name + "ID reward: " + info.getRewardId());
//          Log.logInfo(class_name + "ID reward: " + info.getRewardId());
          if (info.getCategory() == 2)
            addRewardID(info.getProductCode(), info, true);
        }
        else
        {
          // sw = false;
          if(log.isDebugEnabled())
            log.debug(class_name + "no hay mas X\n" + class_name + "Tamanno del Vector(SacaX): " + infoRewards.size());
//          Log.logDebug(class_name + "no hay mas X");
//          Log.logDebug(class_name + "Tamanno del Vector(SacaX): " + infoRewards.size());
        }
      }
    }
  }

  private static HashMap rewardID;

  // private static HashMap rewardIDM;
  // private static HashMap acarreoID;

  private static void addRewardID(String id, InfoReward info, boolean margen)
  {
    if (info == null)
    {
      log.warn(class_name + "InfoReward Null, revisar");
//      Log.logError(class_name + "InfoReward Null, revisar");
    }
    else
    {
      String msg = info.getMensaje();
      if (msg == null)
      {
        msg = "";
      }
      if(log.isDebugEnabled())
        log.debug(class_name + "id en addRewardID: " + id + "\n" + class_name + "mensaje en addRewardID: " + msg);
//      Log.logDebug(class_name + "id en addRewardID: " + id);
//      Log.logDebug(class_name + "mensaje en addRewardID: " + msg);
      RewardCount rwc = null;
      if (msg.length() > 29)
        msg = msg.substring(0, 28);
      if (rewardID == null)
      {
        rewardID = new HashMap();
        if (margen)
        {
          rwc = new RewardCountMargGas(info);
        }
        else
        {
          rwc = new RewardCount(info);
        }
        rewardID.put(id, rwc);
      }
      else
      {
        rwc = (RewardCount) rewardID.get(id);
        if (rwc == null)
        {
          if (margen)
          {
            rwc = new RewardCountMargGas(info);
          }
          else
          {
            rwc = new RewardCount(info);
          }
          rewardID.put(id, rwc);
        }
        else
        {
          rwc.add(info);
          rewardID.put(id, rwc);
        }
      }
    }
  }
  /*
   * OJO, quitar suma luego de prueba
   */
  private static String getConsolidado()
  {
    if(log.isInfoEnabled())
      log.info(class_name + "Sacando consolidado");
//    Log.logInfo(class_name + "Sacando consolidado");
    // Double acarr = new Double(0);
    double acarr = 0;
    StringBuffer response = new StringBuffer();
    if (rewardID == null)
      return response.toString();
    Object ID[] = rewardID.keySet().toArray();
    for (int i = 0; i < ID.length; i++)
    {
      if(log.isInfoEnabled())
        log.info(class_name + "Sacando rwc para ID " + ID[i]);
//      Log.logInfo(class_name + "Sacando rwc para ID " + ID[i]);
      RewardCount rwc = (RewardCount) rewardID.get(ID[i]);
      if(log.isDebugEnabled())
        log.debug(class_name + "Sacado rww");
//      Log.logDebug(class_name + "Sacado rww");
      String msg;
      // String msg = (String) rewardIDM.get(ID[i]);
      if (rwc == null)
        msg = " ";
      else
      {
        if(log.isDebugEnabled())
          log.debug(class_name + "Sacando msg para ID " + ID[i]);
//        Log.logDebug(class_name + "Sacando msg para ID " + ID[i]);
        msg = rwc.getMsg();
        if(log.isDebugEnabled())
          log.debug(class_name + "Sacado msg");
//        Log.logDebug(class_name + "Sacado msg");
        if (msg == null)
          msg = " ";
        String fin = rwc.getCodigoFinanciacion();
        if (fin == null || fin.trim().equals(""))
        {
          fin = "0";
        }
        if (i < ID.length - 1)
        {
          /*
           * edgar.cuesta Si viene de sacacampanhas, entonces se a�ade el
           * acarreo a la variable print sino, el acarreo se acumula, para
           * a�adirlo al �ltimo valor de ID (en este caso product code)
           * 04/09/2012
           */
          if (!Instancia.isCampanhas)
          {
            // Con esto evito la descripción de artículos por artículos, campo
            // demás inútil
            rwc.setIncluirMensaje(false);
            if(log.isDebugEnabled())
              log.debug(class_name + "XXXXXXXXXX");
//            Log.logDebug(class_name + "XXXXXXXXXX");
            acarr += rwc.getAcarreo();
            response.append((String) ID[i]);
            response.append(',');
            response.append(rwc.trama(0));
            response.append('~');
          }
          else
          {
            if(log.isDebugEnabled())
              log.debug(class_name + "Campanhas");
//            Log.logDebug(class_name + "Campanhas");
            // Almatex
            // response += (String) ID[i] + "," + rwc.trama() + "~"; //"," + fin
            // Supermaxi y Flamingo
            
            response.append((String) ID[i]);
            response.append(',');
            response.append(rwc.trama());
            response.append(',');
            response.append(fin);
            response.append('~');
          }
        }
        else
        {
          if (Instancia.isCampanhas)
          {
            response.append((String) ID[i]);
            response.append(',');
            response.append(rwc.trama());
            response.append(',');
            response.append(fin);
          }
          else
          {
            rwc.setIncluirMensaje(false);
            acarr += rwc.getAcarreo();
            if(log.isDebugEnabled())
              log.debug(CLASSNAME + "Acarreo en instancia: " + acarr);
//            Log.logDebug(CLASSNAME + "Acarreo en instancia: " + acarr);
            response.append((String) ID[i]);
            response.append(',');
            response.append(rwc.trama(acarr));
          }
        }
      }
    }
    rewardID = null;
    if(log.isInfoEnabled())
      log.info(class_name + "Resumen a devolver: " + response);
//    Log.logInfo(class_name + "Resumen a devolver: " + response);
    return response.toString();
  }

  // no de campañas
  /*
   * OJO, quitar suma, luego de prueba
   */
  public static String getTotalAcumulado()
  {
    if(log.isInfoEnabled())
      log.info(class_name + "Sacando total acumulado de descuentos");
//    Log.logInfo(class_name + "Sacando total acumulado de descuentos");

    BigInteger total = new BigInteger("0");
    String response = "";

    if (rewardID == null)
      return response;

    Object ID[] = rewardID.keySet().toArray();
    for (int i = 0; i < ID.length; i++)
    {
      if(log.isInfoEnabled())
        log.info(class_name + "Sacando rwc para ID " + ID[i]);
//      Log.logInfo(class_name + "Sacando rwc para ID " + ID[i]);
      RewardCount rwc = (RewardCount) rewardID.get(ID[i]);

      if (rwc == null)
        return "";
      else
      {
        if(log.isDebugEnabled())
          log.debug(class_name + "Sacando msg para ID " + ID[i]);
//        Log.logDebug(class_name + "Sacando msg para ID " + ID[i]);
        // total += rwc.getAcarreo();
        total = new BigInteger(rwc.trama()).add(total); // tota += total

      }

    }
    rewardID = null;
    if(log.isInfoEnabled())
      log.info(class_name + "Total " + total);
//    Log.logInfo(class_name + "Total " + total);
    return total + "";
  }

  public static void ponderaDescuento(Vector inf)
  {
    if (inf == null)
      return;
    decimal = 0;
    Vector infoReward = inf;
    if (rewardID == null)
    {
      rewardID = new HashMap();
      // rewardIDM = new HashMap();
      // acarreoID = new HashMap();
    }
    double sum = 0;
    HashMap des = new HashMap();
    LineItem item[] = b.getTicket().getLineItems().getLineItem();
    for (int i = 0; i < item.length; i++)
    {
      // if (!item[i].isNonDiscountable()) {
      if (!item[i].isNonDiscountable())
      {
        double costo = item[i].getProductPrice();
        sum += costo;
        if(log.isDebugEnabled())
          log.debug(class_name + "Entro con costo: " + costo + " hasta ahora el acumulado: " + sum);
//        Log.logDebug(class_name + "Entro con costo: " + costo + " hasta ahora el acumulado: " + sum);
        des.put(item[i].getProductCode(), new Double(costo));
      }
    }
    Object l[] = des.keySet().toArray();
    long correccion = 0;
    for (int j = 0; j < infoReward.size(); j++)
    {
      InfoReward info = (InfoReward) infoReward.get(j);
      double d0 = info.getDescuento();
      /*
       * edgar.cuesta No se suman en los beneficios los reward de categor�as
       * diferentes a dos 31/08/2012
       */
      if (info.getCategory() == 2)
      {
        for (int i = 0; i < l.length; i++)
        {
          if(log.isDebugEnabled())
            log.debug(class_name + "ID: " + l[i]);
//          Log.logDebug(class_name + "ID: " + l[i]);
          Double d = (Double) rewardID.get(l[i]);
          Double dp = new Double((d0 / sum) * (Double.parseDouble(des.get(l[i]).toString())));
          if(log.isDebugEnabled())
            log.debug(class_name + "Este es d: " + d + "\n"
               + class_name + "Este es dp: " + dp + "\n"
               + class_name + "Este es d0: " + d0 + "\n"
               + class_name + "Este es sum: " + sum);
//          Log.logDebug(class_name + "Este es d: " + d);
//          Log.logDebug(class_name + "Este es dp: " + dp);
//          Log.logDebug(class_name + "Este es d0: " + d0);
//          Log.logDebug(class_name + "Este es sum: " + sum);
          int dAdd = 0;//
          if (d == null)
          {

            // rewardID.put(l[i], dp);
            double d_dp = dp.doubleValue();// d.doubleValue();
            dAdd = (new Double(d_dp)).intValue();
            decimal += d_dp - (double) dAdd;
            if(log.isDebugEnabled())
              log.debug(class_name + "Decimal 1: " + decimal);
//            Log.logDebug(class_name + "Decimal 1: " + decimal);
          }
          else
          {
            double d_dp = dp.doubleValue() + d.doubleValue();
            dAdd = (new Double(d_dp)).intValue();
            decimal += d_dp - (double) dAdd;
            if(log.isDebugEnabled())
              log.debug(class_name + "Decimal 1: " + decimal + "\n"
                + class_name + "Este es d entero: " + d.intValue() + "\n"
                + class_name + "esta es la suma de dp y d: " + dAdd + "\n"
                + class_name + "valor final de d: " + dAdd);
//            Log.logDebug(class_name + "Decimal 1: " + decimal);
//            Log.logDebug(class_name + "Este es d entero: " + d.intValue());
//            Log.logDebug(class_name + "esta es la suma de dp y d: " + dAdd);
//            Log.logDebug(class_name + "valor final de d: " + dAdd);

          }
          if (i == l.length - 1)
          {
            if(log.isDebugEnabled())
              log.debug(class_name + "Decimal: " + decimal);
//            Log.logDebug(class_name + "Decimal: " + decimal);
            correccion = Math.round(decimal);
            if(log.isDebugEnabled())
              log.debug(class_name + "Correccion: " + correccion);
//            Log.logDebug(class_name + "Correccion: " + correccion);
            dAdd += correccion;
          }
          rewardID.put(l[i], new Double(dAdd));
        }
      }
    }
  }

  public int getTamannoInfoRewardsItem()
  {
    return InfoRewardsItem.size();
  }

  // public int correccion(Double precio, Double totalD)
  // {
  //
  // }

  public static RewardsResponse getUltimaRespuesta()
  {
    return ultimaRespuestaLoyalty;
  }

  public static void setUltimaRespuesta(RewardsResponse ultimaRespuesta)
  {
    // Para la corrección que querían, machetazo en toda regla, se almacenan las
    // dos
    // últimas respuestas dadas por Loyalty, para evitar problemas, el almacen
    // de la
    // penúltima respuesta se maneja desde el set de la última
    if (ultimaRespuestaLoyalty != null)
    {
      if(log.isDebugEnabled())
        log.debug("[Instancia]" + ultimaRespuestaLoyalty.getCoupons());
//      Log.logDebug("[Instancia]" + ultimaRespuestaLoyalty.getCoupons());
      if (ultimaRespuestaLoyalty.getCoupons() != null && ultimaRespuestaLoyalty.getCoupons().getCoupon() != null
        && ultimaRespuestaLoyalty.getCoupons().getCoupon().length != 0)
      {
        if(log.isDebugEnabled())
          log.debug("[Instancia]" + ultimaRespuestaLoyalty.getCoupons().getCoupon()[0].getId());
//        Log.logDebug("[Instancia]" + ultimaRespuestaLoyalty.getCoupons().getCoupon()[0].getId());
      }
        setPenUltimaRespuestaLoyalty(ultimaRespuestaLoyalty);
    }
    ultimaRespuestaLoyalty = ultimaRespuesta;
  }

  public static RewardsResponse getPenUltimaRespuestaLoyalty()
  {
    return penUltimaRespuestaLoyalty;
  }

  public static void setPenUltimaRespuestaLoyalty(RewardsResponse penUltimaRespuestaLoyalty)
  {
    Instancia.penUltimaRespuestaLoyalty = penUltimaRespuestaLoyalty;
  }

  public static int getCursor()
  {
    return cursor;
  }

  public static String getRta()
  {
    String response = "";
    if (cursor < respuesta.size())
    {
      response = (String) respuesta.get(cursor);
      cursor++;
      if (cursor == respuesta.size())
      {
        cursor = 0;
      }
    }
    else
    {
      response = "400|Ya se llego a la ultima respuesta";
      cursor = 0;
    }
    return response;
  }

  public static void addRta(String resp)
  {
    respuesta.add(resp);
  }

  public static void restartRta()
  {
    respuesta = new ArrayList();
  }
  public static String getDesc()
  {
    StringBuffer response = new StringBuffer();
    if(rewardID != null && rewardID.keySet() != null && !rewardID.keySet().isEmpty())
    {
      Object ID[] = rewardID.keySet().toArray();
      for (int i = 0; i < ID.length; i++)
      {
        RewardCount rwc = (RewardCount) rewardID.get(ID[i]);
        if(rwc.getCategori() == 5)
        {
          if(log.isInfoEnabled())
            log.info(class_name + "Sacando mensajes para " + ID[i]);
//          Log.logInfo(class_name + "Sacando mensajes para " + ID[i]);
          if(log.isDebugEnabled())
            log.debug(class_name + "Se añade el mensaje");
//          Log.logDebug(class_name + "Se añade el mensaje");
          response.append(rwc.getDescription2Instance());
          response.append('~');
        }
      }
      if(response.lastIndexOf("~") != -1)
        response.deleteCharAt(response.lastIndexOf("~"));
    }
    response.append('|');
    return response.toString();
  }
}
