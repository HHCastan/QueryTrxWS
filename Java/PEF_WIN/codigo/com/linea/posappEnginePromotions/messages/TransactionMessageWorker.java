package com.linea.posappEnginePromotions.messages;

import org.apache.log4j.Logger;

import com.fal.ws.impl.RewardsResponse;
import com.fal.ws.impl.TicketMessage;
import com.fal.ws.impl.TicketMessages;

/**
 * @author edgar.cuesta Trabaja con mensajes de tipo transacción
 * 
 */
public class TransactionMessageWorker implements MessageWorker
{
  public static Logger log = Logger.getLogger(TransactionMessageWorker.class);
  public static final String CLASSNAME = "[TransactionMessageWorker]";
  private RewardsResponse rwr;

  public TransactionMessageWorker()
  {
    log = Logger.getLogger(getClass());
  }
  public String getMessages()
  {
    String response = "";
    if(rwr != null)
    {
      TicketMessages mensajesT = rwr.getTicketMessages();
      if (mensajesT != null && mensajesT.getTicketMessage() != null)
      {
        for (int countMsgs = 0; countMsgs < (mensajesT.getTicketMessage()).length; countMsgs++)
        {
          String aux = "";
          TicketMessage ticketMsg = mensajesT.getTicketMessage(countMsgs);
          if(ticketMsg != null )
            aux = ticketMsg.getMessage();
          response = response.concat(aux + "~");
        }
        // Elimina la última guirgulilla
        response = response.substring(0, response.length() - 1);
      }
      if(log!=null && log.isInfoEnabled())
        log.info(CLASSNAME + "Respuesta parcial" + response);
//      Log.logDebug(CLASSNAME + "Respuesta parcial" + response);
    }
    else
    {
      log.warn(CLASSNAME + "El reward está null...revisar el constructor");
//      Log.logWarning(CLASSNAME + "El reward está null...revisar el constructor");
    }
    return response;
  }

  public void setRwr(RewardsResponse rwr)
  {
    this.rwr = rwr;
  }

  public RewardsResponse getRwr()
  {
    return rwr;
  }
}