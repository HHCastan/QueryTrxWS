package com.linea.sig.util;

import org.apache.log4j.Logger;

import com.fal.ws.impl.Reward;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.InfoReward;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.Instancia;

public class UtilidadesDescuentos
{

  private static Logger log = Logger.getLogger(UtilidadesDescuentos.class);
  private static Reward reward[] = null;// =
                                        // r.getRewardsGranted().getRewards().getReward();

  // este codigo es el mismo que se encuentra en el eot.

  public static void inicializar()
  {

    // solo se extraen item e item0 (todos los que tengan un idice)
    Instancia.reStartVectorItem();
    Instancia.reStartVectorItem0();
    if (reward != null)
    {
      if (reward.length == 0)
      {
        log.warn("(inicializando retefuente) No se han entregado descuentos por parte del WS, favor revisar... "
            + " tamaño reward :" + reward.length + "reward: " + reward.toString());
        // Log.logWarning("(inicializando retefuente) No se han entregado descuentos por parte del WS, favor revisar... "
        // + " tamaño reward :" + reward.length + "reward: " + reward.toString()
        // );
      }
      for (int i = 0; i < reward.length; i++)
      {
        String mensage = reward[i].getRewardDescription().replace(',', '.');
        String rewardId = reward[i].getRewardID();
        double descontable;
        // Me verifica que el indice sea uno o mas
        // Con el fin de identificar un tipo de descuento
        // distintos para los
        // items con indice cero
        if (reward[i].getIndex() > 0)
        {
          int pCode = -1;
          for (int j = 0; j < Instancia.b.getTicket().getLineItems().getLineItem().length; j++)
          {
            // if
            // (Instancia.b.getTicket().getLineItems().getLineItem(j).getProductCode()
            if (Instancia.b.getTicket().getLineItems().getLineItem()[j].getProductCode().equals(
              reward[i].getProductCode()))
            {
              pCode = j;
              break;
            }
            if (Instancia.b.getTicket().getVouchers() != null)
            {
              for (int k = 0; k < Instancia.b.getTicket().getVouchers().getVoucher().length; k++)
              {
                if (Instancia.b.getTicket().getVouchers().getVoucher()[k].getVoucherCode().equals(
                  reward[i].getProductCode()))
                {
                  pCode = k;
                }
              }
            }
          }
          if (pCode == -1)
            descontable = 0;
          else
            // descontable =
            // Instancia.b.getTicket().getLineItems().getLineItem(pCode).getProductPrice();
            descontable = Instancia.b.getTicket().getLineItems().getLineItem()[pCode].getProductPrice();
          double descuento = reward[i].getRewardAmount();
          String productcode = reward[i].getProductCode();
          InfoReward info = new InfoReward(mensage, rewardId, descontable, descuento, productcode,
            reward[i].getCategory());
          if (log.isDebugEnabled())
            log.debug("InfoReward agregado a Item: " + info.getMensaje() + " con rewardID: " + info.getRewardId());
          // Log.logDebug("InfoReward agregado a Item: " + info.getMensaje() +
          // " con rewardID: " + info.getRewardId());
          Instancia.setElementOfVectorItem(info);
        }
        else
        {
          descontable = 0;// price[reward[i].getIndex()-1];
          double descuento = reward[i].getRewardAmount();
          String productcode = reward[i].getProductCode();
          InfoReward info = new InfoReward(mensage, rewardId, descontable, descuento, productcode,
            reward[i].getCategory());
          if (log.isDebugEnabled())
            log.debug("InfoReward agregado a Item0: " + info.getMensaje() + " con rewardID: " + info.getRewardId());
          // Log.logDebug("InfoReward agregado a Item0: " + info.getMensaje() +
          // " con rewardID: " + info.getRewardId());
          Instancia.setElementOfVectorItem0(info);
        }
      }
    }
    else
    {
      log.warn(" No se han entregado rewards de parte del WS, favor revisar...");
      // Log.logWarning(" No se han entregado rewards de parte del WS, favor revisar...");
    }

  }

  public static String consolidadoAticulos()
  {
    if (reward != null)
      return Instancia.consolidadoItem(0);

    return "";
  }

  public static String acumuladoItem0()
  {
    if (reward != null)
      return Instancia.acumuladoItem0();

    return "";
  }

  public static Reward[] getReward()
  {
    return reward;
  }

  public static void setReward(Reward[] rewardin)
  {
    if (log.isDebugEnabled())
      log.debug("ingresando rewars a retefuente: " + rewardin);
    // Log.logDebug("ingresando rewars a retefuente: " + rewardin);
    reward = rewardin;
  }

}
