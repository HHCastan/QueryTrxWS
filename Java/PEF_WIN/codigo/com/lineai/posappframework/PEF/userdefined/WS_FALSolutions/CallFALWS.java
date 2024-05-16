/*
 * Class: com.linea.posappframework.PEF.userdefined.WS_FALSolutions.CallFALWS
 * 
 * Client: Almatex
 * 
 * Deployment: \PEF\PEF.jar
 * 
 * Module information: CallFALWS
 * 
 * Brief summary: Env�a al webservice el mensaje de petici�n y recibe el de
 * respuesta
 * 
 * Copyright
 */
package com.lineai.posappframework.PEF.userdefined.WS_FALSolutions;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.fal.ws.impl.FALWebServicesImplServiceLocator;
import com.fal.ws.impl.RewardsResponse;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.Instancia;
// import com.fal.ws.impl.FALWebServicesImplServiceStub;
// import com.fal.ws.impl.RequestRewards;
// import com.fal.ws.impl.RequestRewardsE;

public class CallFALWS
{
  private static Logger log = Logger.getLogger(CallFALWS.class);
  private static Logger errorLog = Logger.getLogger("error." + CallFALWS.class.getName());
  private FALWebServicesImplServiceLocator FalWSL;
  // private FALWebServicesImplServiceStub falWSL;
  private static final String CLASS_NAME = "[CALWS]";

  // public CallFALWS(String con) {
  public CallFALWS()
  {
    log.info("[CallFALWS]Construyendo objeto encargado de consultar al WS");
//    Log.logDebug("[CallFALWS]Construyende objeto encargado de consultar al WS");

    try
    {
      FalWSL = new FALWebServicesImplServiceLocator();
      // falWSL = new FALWebServicesImplServiceStub(con);
      //
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      errorLog.error(CLASS_NAME + "Exception: " + e.getClass().getName() + ":" + e.getMessage(), e);
    }

  }

  // public RewardsResponse conectWS() throws RemoteException, ServiceException
  // {
  public RewardsResponse conectWS(String con) throws RemoteException, ServiceException
  {
    log.debug("[CALLFALWS] Se pasan los argumentos para invocar al ws");
//    Log.logDebug("[CALLFALWS] Se pasan los argumentos para invocar al ws");
    FalWSL.setFALWebServicesImplPortEndpointAddress(con);
    log.info("[CALLFALWS] Se solicitan descuentos");
//    Log.logInfo("[CALLFALWS] Se solicitan descuentos");
    return FalWSL.getFALWebServicesImplPort().requestRewards(Instancia.b);
  }

};
