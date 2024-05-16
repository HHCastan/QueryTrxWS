package com.linea.posappEnginePromotions.messages;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.fal.ws.impl.Reward;
import com.fal.ws.impl.RewardMessage;
import com.fal.ws.impl.Rewards;
import com.fal.ws.impl.RewardsResponse;
import com.fal.ws.impl.TicketMessage;

/**
 * @author edgar.cuesta
 * 
 */
public class RewardMessageWorker implements MessageWorker
{
  private static final String CLASSNAME = "[RewardMessageWorker]";
  private static Logger log = Logger.getLogger(RewardMessageWorker.class);
  private RewardsResponse rwr;
  private HashSet rwId;
  HashMap msgRewards;

  /**
   * Constructor por defecto
   */
  public RewardMessageWorker()
  {
    rwId = new HashSet();
    msgRewards = new HashMap();
  }

  /**
   * Constructor que recibe un RewardResponse del que se extraerán los mensajes
   * 
   * @param rwr
   *          RewardResponse del que se extraerán los mensajes
   */
  public RewardMessageWorker(RewardsResponse rwr)
  {
    msgRewards = new HashMap();
    this.setRwr(rwr);
  }

  public String getMessages()
  {
    String response = "";
    Rewards rewards = rwr.getRewardsGranted().getRewards();
    Reward[] rws = rewards.getReward();
    if (rws != null)
    {
      for (int i = 0; i < rws.length; i++)
      {
        RewardMessage msgRwrd = rws[i].getRewardMessage();
        if (msgRwrd != null)
        {
          String ticketAux = this.getTicketMessagesForRewardMessage(msgRwrd);
          if (response != null && !response.equals(""))
            response = response + "~";
          response = response + ticketAux;

          /*
           * edgar.cuesta 12-02-2014 De esta manera se toman los mensajes a
           * tiquete que lleguen por reward NOTA: se concatenan al
           * ticketMessageExistente (añadiendo una '~' por cada nuevo mensaje
           */
//          if (rws[i].getCategory() == 5)
//          {
//            if (ticketAux.lastIndexOf('=') != -1)
//            {
//              StringTokenizer stringValues = new StringTokenizer(ticketAux, "=", true);
//              String msgPart = stringValues.nextToken() + stringValues.nextToken();
//              BigDecimal value = new BigDecimal(stringValues.nextToken().trim().replace(',', '.'));
//              if (msgRewards.containsKey(msgPart))
//              {
//                BigDecimal valueExist = (BigDecimal) msgRewards.get(msgPart);
//                if (value.compareTo(valueExist) > 0)
//                {
//                  msgRewards.put(msgPart, value);
//                }
//              }
//              else
//                msgRewards.put(msgPart, value);
//            }
//            else
//            {
//              Log.logWarning(CLASSNAME + "Lo siento pero el formato de regalo no permite acumular");
//            }
//            rwId.add(rws[i].getRewardID());
//          }
        }
      }
    }
    Iterator it = msgRewards.keySet().iterator();
    while (it.hasNext())
    {
      String msgAux = (String) it.next();
      BigDecimal value = (BigDecimal) msgRewards.get(msgAux);
      response = response + "~" + msgAux + value.setScale(0).toString();
    }
    if(log.isInfoEnabled())
      log.info(CLASSNAME + "Mensaje al tiquete parcial: " + response);
//    Log.logInfo(CLASSNAME + "Mensaje al tiquete parcial: " + response);
    return response;
  }

  /**
   * @return
   */
  public RewardsResponse getRwr()
  {
    return rwr;
  }

  /**
   * @param rwr
   */
  public void setRwr(RewardsResponse rwr)
  {
    this.rwr = rwr;
  }

  private String getTicketMessagesForRewardMessage(RewardMessage rwdMsg)
  {
    String ticketMessageByReward = "";
    TicketMessage[] ticketReward = rwdMsg.getTicketMessage();
    if(ticketReward != null)
    {
      
      for (int countMsgs = 0; countMsgs < ticketReward.length; countMsgs++)
      {
        ticketMessageByReward = ticketMessageByReward.concat(ticketReward[countMsgs].getMessage() + "~");
      }
      ticketMessageByReward = ticketMessageByReward.substring(0, ticketMessageByReward.length() - 1);
      
    }
    return ticketMessageByReward;
  }

}
