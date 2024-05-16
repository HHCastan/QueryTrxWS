package com.lineai.posappframework.PEF.userdefined.WS_FALSolutions;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class SocketPEF implements Runnable
{
  private static ServerSocket socketPef;
  private Socket recibido;
  private static final String NOMBRE_CLASE = "[SocketPEF]";
  private static final int DEFAULT_PORT = 9999;
  private static Logger log= Logger.getLogger(SocketPEF.class);
  private static Logger errorLog = Logger.getLogger("error." + SocketPEF.class.getName());
  
  public SocketPEF(int port) throws IOException
  {
//    new ServerSocket();
    socketPef = new ServerSocket(port);
  }
  public SocketPEF() throws IOException
  {
    socketPef = new ServerSocket(DEFAULT_PORT);
    log = Logger.getLogger(getClass());
  }
  public boolean waitToConnect(int milis)
  {
    try
    {
      socketPef.setSoTimeout(milis);
      recibido = socketPef.accept();
      return true;
    }
    catch(SocketTimeoutException e)
    {
      errorLog.error(NOMBRE_CLASE + "No hubo conexiones entrantes", e);
//      Log.logError(NOMBRE_CLASE + "No se hubo conexiones entrantes");
      
      return false;
    }
    catch (SocketException e)
    {
      // TODO Auto-generated catch block
      errorLog.error(NOMBRE_CLASE + "Error TCP: " + e.getClass() + ":" + e.getMessage(),e);
//      Log.logError(NOMBRE_CLASE + "Error TCP: " + e.getMessage());
//      Log.logError(NOMBRE_CLASE + "\tCaused by: " + e.getCause().getClass().getName() + ": " + e.getCause().getMessage());
//      e.printStackTrace();
      return false;
    }
    catch (IOException e)
    {
      errorLog.error(NOMBRE_CLASE + "Error: " + e.getClass() + ":" + e.getMessage(),e);
//      e.printStackTrace();
      return false;
    }
    catch(Exception e)
    {
      errorLog.error(NOMBRE_CLASE + "Error: " + e.getClass() + ":" + e.getMessage(),e);
//      e.printStackTrace();
      return false;
    }
  }
  public void run()
  {
    while(true)
    {
      if(this.waitToConnect(500))
      {
//        SocketChannel sck = recibido.getChannel();
        try
        {
          String consulta = "";
          InputStream in = recibido.getInputStream();
          byte[] buffer = new byte[256];
          int max = in.read(buffer);
          while(max == buffer.length)
          {
            consulta = consulta.concat(new String(buffer, Charset.forName("UTF-8")));
            max = in.read(buffer);
          }
          if(max != -1)
          {
            consulta = consulta.concat(new String(buffer, Charset.forName("UTF-8")));
          }
          Calendar cal = Calendar.getInstance();
          long timeMilisInicio = cal.getTimeInMillis();
          String respuesta = Core.execute(consulta);
          cal = Calendar.getInstance();
          long timeMilisfin = cal.getTimeInMillis();
          respuesta = respuesta.concat("|" + dateBonito(timeMilisfin - timeMilisInicio));
          byte[] bufferSalida = respuesta.getBytes(Charset.forName("UTF-8"));
          recibido.getOutputStream().write(buffer);
        }
        catch (IOException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      try
      {
        Thread.sleep(300);
      }
      catch (InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // TODO Auto-generated method stub
  }
  /**
   * @return tiempo formato HH:mm:ss:nnn
   */
  public String dateBonito(long milis)
  {
    String respuesta = "";
    long seconds = milis/1000;
    respuesta = (String.valueOf(milis%1000).concat(respuesta));
    long minutes = seconds/60;
    respuesta = (String.valueOf(seconds%60).concat(":" + respuesta));
    long hours = minutes/60;
    respuesta = (String.valueOf(minutes%60).concat(":" + respuesta));
    return String.valueOf(hours).concat(":" + respuesta);
//    return respuesta;
  }
}
