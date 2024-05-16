package com.linea.posappEnginePromotions.messages;

import com.fal.ws.impl.RewardsResponse;

public interface MessageWorker
{
  /**
   * Metodo encargado de extraer los Mensajes de manera compilada
   */
    public String getMessages();
    /**
     * Se modifica el RewardResponse sobre el que se trabajará
     * @param rwr El RewardResponse del que se extraerán los mensajes
     */
    public void setRwr(RewardsResponse rwr);
    /**
     * Se obtiene el RewardResponse, no la veo necesaria puede elminarse
     * @return RewardResponse con el que es está trabajando
     */
    public RewardsResponse getRwr();
}
