package com.flamingo.controladores;

import com.flamingo.test.Prueba;
import com.flamingo.util.ManejoXML;
import org.apache.log4j.Logger;

public class ControladorPeticiones
{
  private Logger log;
  private final String VERSION ="0.0.1";
  ManejoXML manager = new ManejoXML(Prueba.class.getResourceAsStream("/xmlInterpreter/confMensajes.xml"));
  
  public ControladorPeticiones()
    throws Exception
  {
    System.out.println("[BinInterpreter] - Iniciando Modulo version: " + VERSION);
    log = Logger.getLogger(ControladorPeticiones.class);
    log.debug("[BinInterpreter] - Iniciando Modulo version: " + VERSION);
  }
  
  public String procesar(String trama)
  {
    try
    {
      this.log.debug("procesando trama-> " + trama);
      
      return("999|" + manager.validateMessage(trama));
    }
    catch (Exception e)
    {
      this.log.error("[BinInterpreter] - Error en BIN -> " + e.getMessage(), e);
    }
    return "300|Error en BIN";
  }
}
